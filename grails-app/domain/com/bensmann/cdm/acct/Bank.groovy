package com.bensmann.cdm.acct

import com.bensmann.cdm.*

/**
 * 
 */
class Bank {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	String bankCode
	
	/**
	 * 
	 */
	String iban
	
	/**
	 * 
	 */
	String bic
	
	/**
	 * 
	 */
	String info
	
	static mapping = {
		table "T1_BANK"
	}
	
	static constraints = {
		name(nullable: false)
		bankCode(nullable: true)
		iban(nullable: true)
		bic(nullable: true)
		info(nullable: true, maxSize: 4000)
	}
	
}
