package com.bensmann.cdm.crm

/**
 * 
 */
class MessengerType {
	
	/**
	 * 
	 */
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_IM_TY"
	}
	
}
