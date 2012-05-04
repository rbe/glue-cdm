package com.bensmann.cdm

/**
 * Type of a person.
 */
class PersonType extends Base {
	
	String name
	
	static constraints = {
		name(blank: false)
	}
	
	static mapping = {
		table "T1_PE_TY"
	}
	
}
