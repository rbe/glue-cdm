package com.bensmann.cdm.crm

import com.bensmann.cdm.*
import com.bensmann.cdm.project.*

/**
 * 
 */
class Customer extends Company {
	
	/**
	 * 
	 */
	Date gotCustomerState
	
	/**
	 * 
	 */
	CustomerType customerType
	
	static hasMany = [
		project: Project
	]
	
	static constraints = {
		name(nullable: false)
		company2(nullable: true)
		parentCompany(nullable: true)
		customerType(nullable: true)
		sector(nullable: true)
		gotCustomerState(nullable: true)
		companyType(nullable: true)
		companyRole(nullable: true)
		project(nullable: true)
		person(nullable: true)
		address(nullable: true)
		mainTelephone(nullable: true)
		mainFax(nullable: true)
		mainEmailAddress(nullable: true, email: true)
		websiteUrl(nullable: true)
		preferredContactType(nullable: true)
		taxInformation(nullable: true)
		bankAccount(nullable: true)
		paymentType(nullable: true)
		info(nullable: true, maxSize: 4000)
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
			property(name: "parentCompany") {
				widget {
					component(test: "lessThan", value: 5, type: "radioGroup")
					component(test: "moreThan", value: 5, type: "list")
				}
				autoComplete true
			}
			property(name: "customerType") {
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
			property(name: "companyType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "companyRole") {
				widget {
					component(test: "lessThan", value: 10, type: "checkbox")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "project") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "person") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "address") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "preferredContactType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "taxInformation") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "bankAccount") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "paymentType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
