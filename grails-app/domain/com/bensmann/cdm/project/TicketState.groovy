package com.bensmann.cdm.project

import com.bensmann.cdm.*

/**
 * 
 */
class TicketState extends Base {
	
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_TC_ST"
	}
	
}
