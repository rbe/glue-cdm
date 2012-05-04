package com.bensmann.cdm.crm

/**
 * 
 */
class ContactType {
	
	/**
	 * 
	 */
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_CTA_TY"
	}
	
}
