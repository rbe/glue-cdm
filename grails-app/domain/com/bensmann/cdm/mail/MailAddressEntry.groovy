package com.bensmann.cdm.mail

import com.bensmann.cdm.*

/**
 * 
 */
class MailAddressEntry extends Base {
	
	/**
	 * The email address.
	 */
	String name
	
	def beforeInsert = {
		check()
	}
	
	def beforeUpdate = {
		check()
	}
	
	def check() {
	}
	
	static mapping = {
		table "T1_MADR_EN"
	}
	
	static constraints = {
		name(nullable: false)
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
		}
	}
	
}
