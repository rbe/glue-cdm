package com.bensmann.cdm.mail

import com.bensmann.cdm.*

/**
 * 
 */
class MailRouting extends Base {
	
	/**
	 * Name of the routing entry.
	 */
	String name
	
	/**
	 * 
	 */
	java.sql.Timestamp startDate
	java.sql.Timestamp endDate
	
	def beforeInsert = {
		check()
	}
	
	def beforeUpdate = {
		check()
	}
	
	def check() {
		if (!startDate) startDate = new java.sql.Timestamp(new Date().getTime())
	}
	
	static hasMany = [
		destination: MailAddressEntry
	]
	
	static mapping = {
		table "T1_MRT"
	}
	
	static constraints = {
		name(nullable: false)
		startDate(nullable: true)
		endDate(nullable: false)
		destination(nullable: true)
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
			property(name: "destination") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
