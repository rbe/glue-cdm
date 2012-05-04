package com.bensmann.cdm.crm

import com.bensmann.cdm.*

/**
 * 
 */
class EmailAddress extends Base {
	
	/**
	 * 
	 */
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_EMAIL_ADR"
	}
	
}
