package com.bensmann.cdm.crm

import com.bensmann.cdm.*

/**
 * 
 */
class Address extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	AddressType addressType
	
	/**
	 * 
	 */
	String address1
	
	/**
	 * 
	 */
	String address2
	
	/**
	 * 
	 */
	String street
	
	/**
	 * 
	 */
	String postCode
	
	/**
	 * 
	 */
	String city
	
	/**
	 * 
	 */
	String country
	
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
		String.format("ADR-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Address.count() + 1)
	}
	
	static constraints = {
		name(nullable: false)
		addressType(nullable: true)
		address1(nullable: true)
		address2(nullable: true)
		street(nullable: true)
		postCode(nullable: true)
		city(nullable: true)
		country(nullable: true)
	}
	
	static mapping = {
		table "T1_ADR"
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
			property(name: "addressType") {
				widget {
					component(test: "lessThan", value: 10, type: "checkbox")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
