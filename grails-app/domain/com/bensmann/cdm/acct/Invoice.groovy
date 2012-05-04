package com.bensmann.cdm.acct

import com.bensmann.cdm.*
import com.bensmann.cdm.crm.*
import com.bensmann.cdm.product.*

/**
 * 
 */
class Invoice extends Base {
	
	String name
	
	Order order
	
	Date expectedDateOfPayment
	Date effectiveDateOfPayment
	int paymentOverdue
	
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
		// TODO Calculate paymentOverdue
	}
	
	/**
	 * Generate a name.
	 */
	def generateName() {
		String.format("N-%03d", 100 + Invoice.count() + 1)
	}

	static mapping = {
		table "T1_ACCT_INVOICE"
	}
	
	static constraints = {
		name(nullable: false)
		order(nullable: true)
		expectedDateOfPayment(nullable: true)
		effectiveDateOfPayment(nullable: true)
		paymentOverdue(nullable: true, editable: false)
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
		}
	}
	
}
