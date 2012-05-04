package com.bensmann.cdm

/**
 * 
 */
class CompanyRole extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	CompanyRole parentRole
	
	static mapping = {
		table "T1_CO_ROLE"
	}
	
	static constraints = {
		name(nullable: false)
		parentRole(nullable: true)
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
