package com.bensmann.cdm.project

import com.bensmann.cdm.*

/**
 * 
 */
class TicketLog extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	TicketLogType ticketLogType
	
	/**
	 * 
	 */
	String description
	
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
	}
	
	/**
	 * Generate a name.
	 */
	def generateName() {
		String.format("TL-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + TicketLog.count() + 1)
	}
	
	static constraints = {
		name(nullable: false)
		ticketLogType(nullable: true)
		description(nullable: true, maxSize: 4000)
	}
	
	static mapping = {
		table "T1_TC_LOG"
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
			property(name: "ticketLogType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
