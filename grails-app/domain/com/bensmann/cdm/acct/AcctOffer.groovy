package com.bensmann.cdm.acct

/**
 * 
 */
class AcctOffer {
	
	String name
	
	AcctCompany company
	
	double rebateInPercent
	
	Date validFrom
	Date validTo
	
	Date offerAcceptedOn
	String offerAcceptedByPerson
	
	static hasMany = [
		item: AcctItem
	]
	
	static mapping = {
		table "T1_ACCT_OFFER_A"
	}
	
	static constraints = {
		name(nullable: false)
		company(nullable: true, editable: false)
		item(nullable: true, editable: false)
		rebateInPercent(nullable: true, editable: false)
		validFrom(nullable: true, editable: false)
		validTo(nullable: true, editable: false)
		offerAcceptedOn(nullable: true, editable: false)
		offerAcceptedByPerson(nullable: true, editable: false)
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
