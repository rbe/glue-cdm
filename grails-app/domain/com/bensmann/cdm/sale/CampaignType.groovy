package com.bensmann.cdm.sale

import com.bensmann.cdm.*

/**
 * 
 */
class CampaignType extends Base {
	
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_CA_TY"
	}
	
}
