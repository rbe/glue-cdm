package com.bensmann.cdm.acct

import com.bensmann.cdm.*
import com.bensmann.cdm.crm.*
import com.bensmann.cdm.product.*

/**
 * 
 */
class Order extends Base {
	
	String name
	
	Customer customer
	Offer offer
	
	Person orderTakenByPerson
	Date orderTakenOn
	
	double rebateInPercent
	
	boolean payableInAdvance
	PaymentTarget paymentTarget
	
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
		String.format("R-%03d", 100 + Order.count() + 1)
	}
	
	static mapping = {
		table "T1_ACCT_ORDER"
	}
	static constraints = {
		name(nullable: false)
		offer(nullable: true)
		orderTakenByPerson(nullable: true)
		orderTakenOn(nullable: true)
		customer(nullable: true)
		product(nullable: true)
		payableInAdvance(nullable: true)
		paymentTarget(nullable: true)
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
			property(name: "offer") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
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
			property(name: "orderTakenByPerson") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
