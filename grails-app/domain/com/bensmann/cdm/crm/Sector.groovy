package com.bensmann.cdm.crm

import com.bensmann.cdm.*

/**
 * A sector.
 */
class Sector extends Base {
	
	/**
	 * Name.
	 */
	String name
	
	/**
	 * Sector is a sub-sector.
	 */
	Sector parentSector
	
	/**
	 * A description.
	 */
	String description
	
	static constraints = {
		name(nullable: false)
		parentSector(nullable: true)
		description(nullable: true, maxSize: 4000)
	}
	
	static mapping = {
		table "T1_SECTOR"
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
