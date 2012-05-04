package com.bensmann.cdm

/**
 * 
 */
class CompanyType extends Base {
	
	/**
	 * 
	 */
	String name
	
	static mapping = {
		table "T1_CO_TY"
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
