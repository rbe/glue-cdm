package com.bensmann.cdm.voip

import com.bensmann.cdm.*

/**
 * A notification.
 */
class VoipNotify {
	
	Date createdDate
	Date lastUpdated
	
	/**
	 * The account this notification is for.
	 */
	VoipAccount voipAccount
	
	/**
	 * Reference to a fax job.
	 */
	//VoipFaxJob faxJob
	
	/**
	 * What?
	 */
	String message
	
	/**
	 * This notification was read?
	 */
	boolean notificationRead
	
	/**
	 * 
	 */
	def beforeInsert = {
	}
	
	/**
	 * 
	 */
	def beforeUpdate = {
	}
	
	/**
	 * 
	 */
	def beforeDelete = {
	}
	
	static mapping = {
		table "T3_NTFY"
	}
	
	static constraints = {
		lastUpdated(nullable: true)
		voipAccount(nullable: false)
		//faxJob(nullable: false)
		message(nullable: false, blank: false, maxSize: 4000)
		notificationRead(nullable: true)
		// validator: { val, obj, errors -> }
	}
	
}
