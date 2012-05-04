package com.bensmann.cdm.acct

import com.bensmann.cdm.*

/**
 * 
 */
class PaymentTarget {
	
	String name
	int workdays
	double discountInPercent
	
	static constraints = {
		name(nullable: false)
		workdays(nullable: true)
		discountInPercent(nullable: true)
		// validator: { val, obj, errors -> }
	}
	
	static mapping = {
		table "T1_PAYTGT"
	}
	
}
