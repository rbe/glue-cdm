package com.bensmann.cdm.acct

import com.bensmann.cdm.*

/**
 * 
 */
class PaymentType {
	
	String name
	
	static constraints = {
		name(nullable: false)
		// validator: { val, obj, errors -> }
	}
	
	static mapping = {
		table "T1_PAYTYPE"
	}
	
}
