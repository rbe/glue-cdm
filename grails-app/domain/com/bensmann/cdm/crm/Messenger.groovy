package com.bensmann.cdm.crm

import com.bensmann.cdm.*

/**
 * 
 */
class Messenger extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	MessengerType messengerType
	
	/**
	 * 
	 */
	String accountId
	
	static constraints = {
		name(nullable: false)
		messengerType(nullable: true)
		accountId(nullable: true)
	}
	
	static mapping = {
		table "T1_IM"
	}
	
	static glueConstraints = {
		glue {
			property(name: "messengerType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
