package com.bensmann.cdm.acct

/**
 * 
 */
class AcctOrder {
	
	String name
	
	AcctCompany company
	AcctOffer offer
	
	double rebateInPercent
	
	Date orderTakenOn
	String orderTakenByPerson
	
	static hasMany = [
		item: AcctItem
	]
	
	static mapping = {
		table "T1_ACCT_ORDER_A"
	}
	
	static constraints = {
		name(nullable: false)
		company(nullable: true, editable: false)
		offer(nullable: true, editable: false)
		item(nullable: true, editable: false)
		rebateInPercent(nullable: true, editable: false)
		orderTakenOn(nullable: true, editable: false)
		orderTakenByPerson(nullable: true, editable: false)
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
