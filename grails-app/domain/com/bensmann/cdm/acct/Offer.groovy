package com.bensmann.cdm.acct

import com.bensmann.cdm.*
import com.bensmann.cdm.crm.*
import com.bensmann.cdm.product.*

/**
 * 
 */
class Offer extends Base {
	
	String name
	
	Customer customer
	
	double rebateInPercent
	
	Date validFrom
	Date validTo
	
	boolean payableInAdvance
	PaymentTarget paymentTarget
	
	Person offerAcceptedByPerson
	Date offerAcceptedOn
	
	static hasMany = [
		product: Product
	]
	
	/**
	 * Do before insert.
	 */
	def beforeInsert = {
		if (!name || name ==~ "GENERATED.*") {
			name = generateName()
		}
		if (!validFrom) {
			validFrom = new Date()
			validTo = validFrom + 7 // TODO Configure days
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
		String.format("O-%03d", 100 + Offer.count() + 1)
	}
	
	static mapping = {
		table "T1_ACCT_OFFER"
	}
	
	static constraints = {
		name(nullable: false)
		customer(nullable: true)
		product(nullable: true)
		validFrom(nullable: true)
		validTo(nullable: true)
		payableInAdvance(nullable: true)
		paymentTarget(nullable: true)
		offerAcceptedByPerson(nullable: true)
		offerAcceptedOn(nullable: true)
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
			property(name: "customer") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "product") {
				widget {
					component(test: "lessThan", value: 5, type: "checkbox")
					component(test: "moreThan", value: 5, type: "list")
				}
				autoComplete true
			}
			property(name: "paymentTarget") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "offerAcceptedByPerson") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
