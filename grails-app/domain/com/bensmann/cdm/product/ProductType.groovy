package com.bensmann.cdm.product

import com.bensmann.cdm.*

/**
 * 
 */
class ProductType {
	
	String name
	
	static constraints = {
		name(nullable: false)
	}
	
	static mapping = {
		table "T1_PROD_TY"
	}
	
}