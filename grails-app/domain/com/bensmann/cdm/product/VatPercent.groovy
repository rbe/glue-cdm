package com.bensmann.cdm.product

import com.bensmann.cdm.*

/**
 * VAT in percent.
 */
class VatPercent extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	Double value
	
	static constraints = {
		name(nullable: false)
		value(nullable: true)
	}
	
	static mapping = {
		table "T1_VAT"
	}
	
}