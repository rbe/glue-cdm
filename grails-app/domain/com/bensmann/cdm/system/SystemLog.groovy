package com.bensmann.cdm.system

import com.bensmann.cdm.Base

/**
 * 
 */
class SystemLog extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	String component
	
	/**
	 * 
	 */
	String message
	
	/**
	 * 
	 */
	String status
	
	/**
	 * 
	 */
	def beforeInsert = {
		if (!name) {
			name = component ? "Log entry from ${component}" : "Anonymous log entry"
		}
	}
	
	static constraints = {
		name(nullable: true)
		component(nullable: false)
		message(nullable: false, maxSize: 4000)
		status(nullable: false, inList: ["INFO", "SUCCESS", "FAILURE"])
		// validator: { val, obj, errors -> }
	}
	
	static info = { component, message ->
		new SystemLog(component: component, message: message, status: "INFO")
	}
	
	static success = { component, message ->
		new SystemLog(component: component, message: message, status: "SUCCESS")
	}
	
	static failure = { component, message ->
		new SystemLog(component: component, message: message, status: "FAILURE")
	}
	
	static mapping = {
		table "T1_SY_LO"
	}
	
}
