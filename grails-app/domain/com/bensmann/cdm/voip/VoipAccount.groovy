package com.bensmann.cdm.voip

import com.bensmann.cdm.*

/**
 * 
 */
class VoipAccount extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	String username
	
	/**
	 * 
	 */
	String password
	
	/**
	 * 
	 */
	String localUri
	
	def beforeInsert = {
		check()
	}
	
	def beforeUpdate = {
		check()
	}
	
	/**
	 * 
	 */
	def check() {
		if (!name || name ==~ /GENERATED.*/) {
			if (username) {
				name = "VoIP Account for ${username}${localUri ? ", ${localUri}" : ""}"
			}
		}
	}
	
	static mapping = {
		table "T3_ACCT"
	}
	
	static constraints = {
		name(nullable: false)
		dateCreated(nullable: true)
		lastUpdated(nullable: true)
		username(nullable: true)
		password(nullable: true)
		localUri(nullable: true)
		// validator: { val, obj, errors -> }
	}
	
}
