package com.bensmann.cdm.mail

import com.bensmann.cdm.*

/**
 * 
 */
class MailDomain extends Base {
	
	/**
	 * Name of the email domain.
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
	
	static hasMany = [
		mailAlias: MailAlias,
		white: MailAddressEntry,
		black: MailAddressEntry
	]
	
	static mapping = {
		table "T1_MDOM"
	}
	
	static constraints = {
		name(nullable: false)
		mailAlias(nullable: true)
		white(nullable: true)
		black(nullable: true)
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
			property(name: "mailAlias") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "white") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "black") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
