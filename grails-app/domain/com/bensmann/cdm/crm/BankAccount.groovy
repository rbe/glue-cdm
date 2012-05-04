package com.bensmann.cdm.crm

import com.bensmann.cdm.*
import com.bensmann.cdm.acct.*

/**
 * 
 */
class BankAccount extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	String accountHolder
	
	/**
	 * 
	 */
	String accountNumber
	
	/**
	 * 
	 */
	Bank bank
	
	//Currency currency
	
	/**
	 * 
	 */
	Date debitEntryPermittedSince
	
	/**
	 * 
	 */
	Date debitEntryPermittedToDate
	
	/**
	 * 
	 */
	String info
	
	/**
	 * Do before insert.
	 */
	def beforeInsert = {
		if (!name || name ==~ "GENERATED.*") {
			name = generateName()
		}
	}
	
	/**
	 * Do before update.
	 */
	def beforeUpdate = {
		if (!name || name ==~ "GENERATED.*") {
			name = generateName()
		}
	}
	
	/**
	 * Generate a name.
	 */
	def generateName() {
		String.format("BA-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + BankAccount.count() + 1)
	}
	
	static constraints = {
		name(nullable: true)
		accountHolder(nullable: true)
		accountNumber(nullable: true)
		bank(nullable: true)
		//currency(nullable: true)
		debitEntryPermittedSince(nullable: true)
		debitEntryPermittedToDate(nullable: true)
		info(nullable: true, maxSize: 4000)
	}
	
	static mapping = {
		table "T1_BANK_ACCT"
	}
	
	static glueConstraints = {
		glue {
			property(name: "reminder") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "lessThan", value: 5, type: "checkbox")
					component(test: "moreThan", value: 5, type: "list")
				}
				autoComplete true
			}
			property(name: "bank") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
