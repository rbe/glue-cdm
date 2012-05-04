package com.bensmann.cdm.voip

import com.bensmann.cdm.*

/**
 * 
 */
class VoipFaxJob extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	VoipAccount voipAccount
	
	/**
	 * 
	 */
	String toUri
	
	/**
	 * 
	 */
	String documentName
	
	/**
	 * 
	 */
	java.sql.Blob document
	
	/**
	 * 
	 */
	byte[] byteArray
	
	/**
	 * 
	 */
	Boolean success
	
	static transients = [
		"byteArray"
	]
	
	/**
	 * 
	 */
	def domainClassService
	
	/**
	 * 
	 */
	def beforeInsert = {
		if (!name) {
			name = "Fax job for ${document.name}, ${voipAccount.localUri} -> ${toUri}"
		}
		if (byteArray) {
			document = domainClassService.toBlob(byteArray)
		}
	}
	
	/**
	 * 
	 */
	def beforeUpdate = {
		if (byteArray) {
			document = domainClassService.toBlob(byteArray)
		}
	}
	
	static mapping = {
		table "T3_FAXJOB"
	}
	
	static constraints = {
		lastUpdated(nullable: true)
		name(nullable: true, blank: false)
		voipAccount(nullable: false)
		toUri(nullable: false)
		documentName(nullable: true)
		document(nullable: false)
		success(nullable: true)
		// validator: { val, obj, errors -> }
	}
	
}
