package com.bensmann.cdm.crm

import com.bensmann.cdm.*

/**
 * 
 */
class AddressType extends Base {
	
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_ADR_TY"
	}
	
}
