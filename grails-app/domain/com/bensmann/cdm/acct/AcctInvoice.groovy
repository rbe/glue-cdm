package com.bensmann.cdm.acct

/**
 * 
 */
class AcctInvoice {
	
	String name
	
	AcctOrder order
	
	String paymentTarget
	Date expectedDateOfPayment
	Date effectiveDateOfPayment
	int paymentOverdue
	
	static constraints = {
		name(nullable: false)
		order(nullable: true, editable: false)
		paymentTarget(nullable: true, editable: false)
		expectedDateOfPayment(nullable: true, editable: false)
		effectiveDateOfPayment(nullable: true, editable: false)
		paymentOverdue(nullable: true, editable: false)
	}
	
	static mapping = {
		table "T1_ACCT_INVOICE_A"
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
