package com.bensmann.cdm.crm

import com.bensmann.cdm.*

/**
 * 
 */
class CustomerType extends Base {
	
	/**
	 * 
	 */
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_CU_TY"
	}
	
}
