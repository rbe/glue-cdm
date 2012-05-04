package com.bensmann.cdm.mail

import com.bensmann.cdm.*

/**
 * 
 */
class MailAccount extends Base {
	
	/**
	 * Name of the email account.
	 */
	String name
	
	/**
	 * Password.
	 */
	String password
	
	Boolean popEnabled
	Boolean imapEnabled
	Double quota
	
	def beforeInsert = {
		check()
	}
	
	def beforeUpdate = {
		check()
	}
	
	def check() {
	}
	
	static hasMany = [
		mailRouting: MailRouting,
		white: MailAddressEntry,
		black: MailAddressEntry
	]
	
	static mapping = {
		table "T1_MACCT"
	}
	
	static constraints = {
		name(nullable: false)
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
			property(name: "white") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "lessThan", value: 5, type: "checkbox")
					component(test: "moreThan", value: 5, type: "list")
				}
				autoComplete true
			}
			property(name: "black") {
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
