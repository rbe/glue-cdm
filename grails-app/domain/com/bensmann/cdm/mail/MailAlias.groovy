package com.bensmann.cdm.mail

import com.bensmann.cdm.*

/**
 * 
 */
class MailAlias extends Base {
	
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
		mailAccount: MailAccount,
		mailRouting: MailRouting
	]
	
	static mapping = {
		table "T1_MALI"
	}
	
	static constraints = {
		name(nullable: false)
		mailAccount(nullable: true)
		mailRouting(nullable: true)
	}
	
	static glueConstraints = {
		glue {
			property(name: "mailAccount") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "mailRouting") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
