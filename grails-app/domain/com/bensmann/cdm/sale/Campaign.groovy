package com.bensmann.cdm.sale

import com.bensmann.cdm.*
import com.bensmann.cdm.crm.*
import com.bensmann.cdm.product.*

/**
 * 
 */
class Campaign extends Base {
	
	String name
	CampaignType campaignType
	String infoText // for Emails
	
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
		String.format("CP-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Campaign.count() + 1)
	}
	
	static hasMany = [
		sector: Sector,
		customer: Customer,
		product: Product
	]
	
	static constraints = {
		name(nullable: false)
		campaignType(nullable: true)
		infoText(nullable: true, maxSize: 4000)
		sector(nullable: true)
		customer(nullable: true)
		product(nullable: true)
		info(nullable: true, maxSize: 4000)
		// validator: { val, obj, errors -> }
	}
	
	static mapping = {
		table "T1_CA"
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
			property(name: "campaignType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "sector") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
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
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
