package com.bensmann.cdm

import com.bensmann.cdm.auth.*
import com.bensmann.cdm.crm.*
import com.bensmann.cdm.dms.*
import com.bensmann.cdm.voip.*

class Person extends Base {
	
	String name
	
	PersonType personType
	
	String firstname
	
	String middlename
	
	String lastname
	
	String username
	String passwd
	Boolean enabled
	
	VoipAccount voipAccount
	
	/**
	 * 
	 */
	def beforeInsert = {
		checkName()
	}
	
	/**
	 * 
	 */
	def beforeUpdate = {
		checkName()
	}
	
	/**
	 * 
	 */
	private def checkName() {
		def builder = new StringBuilder()
		if (!name || (name ==~ "GENERATED.*")) {
			// Check for names
			name = [firstname, middlename, lastname].grep {
				it != null
			}?.join(" ")
		} else {
			// Break up name: <firstname> <middlename?> <lastname...>
			def sp = name.split("\\ ")
			firstname = sp[0]
			if (sp.length == 2) {
				lastname = sp[1]
			} else if (sp.length >= 3) {
				middlename = sp[1]
				lastname = sp[2..sp.length - 1].join(" ")
			}
		}
		// Got nothing, so we let it GENERATED
		if (!name) {
			name = "GENERATED-${this.class.simpleName}-${new java.util.Date()}"
		}
	}
	
	static hasMany = [
		personRole: PersonRole,
		messenger: Messenger,
		emailAddress: EmailAddress
	]
	
	static transients = [
		"passwd"
	]
	
	static mapping = {
		table "T1_PE"
	}
	
	static constraints = {
		name(nullable: false)
		personType(nullable: true)
		personRole(nullable: true)
		firstname(nullable: true)
		middlename(nullable: true)
		lastname(nullable: true)
		messenger(nullable: true)
		emailAddress(nullable: true)
		voipAccount(nullable: true)
		username(nullable: true)
		passwd(nullable: true)
		enabled(nullable: true)
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
			property(name: "personType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
			}
			property(name: "personRole") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "messenger") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "email") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "voipAccount") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
