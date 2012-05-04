package com.bensmann.cdm.dms

import com.bensmann.cdm.*

/**
 * An email.
 */
class Email extends Base {
	
	/**
	 * Sender, the From: header.
	 */
	String fromAddress
	
	/**
	 * To: header.
	 */
	String[] toAddress
	
	/**
	 * Cc: header.
	 */
	String[] ccAddress
	
	/**
	 * Date this mail was sent.
	 */
	Date sentDate
	
	/**
	 * Subject: header.
	 */
	String subject
	
	/**
	 * All headers as a string with newlines.
	 */
	String header
	
	/**
	 * The body.
	 */
	String body
	
	static hasMany = [
		attachment: java.sql.Blob
	]

	static constraints = {
		fromAddress(nullable: true)
		toAddress(nullable: true)
		ccAddress(nullable: true)
		sentDate(nullable: true)
		subject(nullable: true)
		header(nullable: true)
		body(nullable: true)
		attachment(nullable: true)
	}
	
	static mapping = {
		table "T1_EMAIL"
		attachment column: "att"
	}
	
}
