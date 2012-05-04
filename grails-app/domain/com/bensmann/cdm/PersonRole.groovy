package com.bensmann.cdm

/**
 * Role of a person.
 */
class PersonRole extends Base {
	
	/**
	 * Is a sub-role?
	 */
	PersonRole parentRole
	
	/**
	 * Name.
	 */
	String name
	
	/**
	 * Optional description.
	 */
	String description
	
	static constraints = {
		parentRole(nullable: true)
		name(blank: false)
		description(nullable: true)
	}
	
	static mapping = {
		table "T1_PE_ROLE"
	}
	
}
