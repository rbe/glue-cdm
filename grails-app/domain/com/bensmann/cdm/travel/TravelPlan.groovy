package com.bensmann.cdm.travel

import com.bensmann.cdm.*

/**
 * 
 */
class TravelPlan extends Base {
	
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_TRA_PL"
	}
	
}
