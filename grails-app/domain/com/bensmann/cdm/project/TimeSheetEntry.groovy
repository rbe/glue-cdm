package com.bensmann.cdm.project

import com.bensmann.cdm.*
import java.util.concurrent.TimeUnit
import java.sql.Timestamp

/**
 * 
 */
class TimeSheetEntry extends Base {
	
	/**
	 * The name.
	 */
	String name
	
	/**
	 * Who has worked on it?
	 */
	Person worker
	
	/**
	 * Time when work was started.
	 */
	Timestamp workStartedAt
	
	/**
	 * Time when work was completed.
	 */
	Timestamp workCompletedAt
	
	/**
	 * Minutes spent on the requirement.
	 */
	Double minutes
	
	/**
	 * Do before insert.
	 */
	def beforeInsert = {
		if (!name || name ==~ "GENERATED.*") {
			name = generateName()
		}
	}
	
	/**
	 * Do before update.
	 */
	def beforeUpdate = {
		if (!name || name ==~ "GENERATED.*") {
			name = generateName()
		}
		calculateWork()
	}
	
	/**
	 * Generate a name.
	 */
	def generateName() {
		String.format("PTS-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + TimeSheetEntry.count() + 1)
	}
	
	/**
	 * 
	 */
	def calculateWork() {
		if (workStartedAt && workCompletedAt && workCompletedAt.after(workStartedAt)) {
			def seconds = TimeUnit.SECONDS.convert(workCompletedAt.getTime() - workStartedAt.getTime(), TimeUnit.MILLISECONDS)
			println "TimeSheetEntry/beforeUpdate: workStartedAt=${workStartedAt.getTime()} workCompletedAt=${workCompletedAt.getTime()} -> ${seconds} seconds"
		}
	}
	
	static constraints = {
		name(nullable: false)
		worker(nullable: true)
		workStartedAt(nullable: true)
		workCompletedAt(nullable: true)
		minutes(nullable: true)
	}
	
	static mapping = {
		table "T1_TSE"
	}
	
	static glueConstraints = {
		glue {
			property(name: "reminder") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "lessThan", value: 5, type: "checkbox")
					component(test: "moreThan", value: 5, type: "list")
				}
				autoComplete true
			}
			property(name: "worker") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
