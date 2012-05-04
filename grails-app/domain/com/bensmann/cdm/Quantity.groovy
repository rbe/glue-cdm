package com.bensmann.cdm

/**
 * A quantity: number of and a unit.
 */
class Quantity {
	
	/**
	 * Unit.
	 */
	Unit unit
	
	/**
	 * Number of...
	 */
	Double quantity
	
	static constraints = {
		unit(nullable: false)
		quantity(nullable: false)
	}
	
	static mapping = {
		table "T1_QTY"
	}
	
}
