package com.bensmann.cdm

/**
 * A unit.
 */
class Unit {
	
	/**
	 * Name of unit.
	 */
	String name
	
	static constraints = {
		name(blank: false)
	}
	
	static mapping = {
		table "T1_UNIT"
	}
	
}
