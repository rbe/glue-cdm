package com.bensmann.cdm.purchase

import com.bensmann.cdm.*
import com.bensmann.cdm.product.*

/**
 * A supplier (is a company).
 */
class Supplier extends Company {
	
	/**
	 * 
	 */
	SupplierType supplierType
	
	/**
	 * Products (article and services), this supplier has got.
	 */
	static hasMany = [
		product: Product
	]
	
	static constraints = {
		name(nullable: false)
		company2(nullable: true)
		parentCompany(nullable: true)
		sector(nullable: true)
		companyType(nullable: true)
		supplierType(nullable: true)
		companyRole(nullable: true)
		person(nullable: true)
		address(nullable: true)
		mainTelephone(nullable: true)
		mainFax(nullable: true)
		mainEmailAddress(nullable: true)
		websiteUrl(nullable: true, blank: true)
		preferredContactType(nullable: true, display: false)
		taxInformation(nullable: true)
		bankAccount(nullable: true)
		paymentType(nullable: true)
		info(nullable: true, maxSize: 4000)
		product(nullable: true)
	}
	
	static mapping = {
		table "T1_SUP"
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
			property(name: "supplierType") {
				widget {
					component(test: "moreThan", value: 10, type: "checkbox")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "product") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
