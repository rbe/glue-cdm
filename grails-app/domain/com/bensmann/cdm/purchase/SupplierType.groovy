package com.bensmann.cdm.purchase

import com.bensmann.cdm.*

/**
 * Type of a supplier.
 */
class SupplierType extends Base {
	
	/**
	 * Name.
	 */
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_SUP_TY"
	}
	
}
