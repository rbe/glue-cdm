package com.bensmann.cdm

import com.bensmann.cdm.acct.*
import com.bensmann.cdm.crm.*

/**
 * 
 */
class Company extends Base {
	
	String name
	
	String company2
	
	Company parentCompany
	
	CompanyType companyType
	
	ContactType preferredContactType
	
	String websiteUrl
	String mainEmailAddress	
	String mainTelephone
	String mainFax
	
	TaxInformation taxInformation
	PaymentType paymentType
	
	String info
	
	//java.sql.Blob aDocument
	//String aDocumentOriginalFilename
	//String aDocumentMimeType
	
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
		String.format("CO-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Company.count() + 1)
	}
	
	static hasMany = [
		sector: Sector,
		companyRole: CompanyRole,
		address: Address,
		bankAccount: BankAccount,
		person: Person
	]
	
	static mapping = {
		table "T1_CO"
		name column: "name"
		company2 column: "company2"
		parentCompany column: "parent"
		sector column: "sector"
		gotCustomerState column: "custstate"
		companyType column: "type"
		companyRole column: "role"
		person column: "person"
		address column: "address"
		mainTelephone column: "mailtel"
		mainFax column: "mainfax"
		mainEmailAddress column: "mainemail"
		websiteUrl column: "websiteurl"
		preferredContactType column: "pcontacttype"
		taxInformation column: "taxinfo"
		bankAccount column: "bankacct"
		paymentType column: "paymenttype"
		comment column: "comment"
	}
	
	static constraints = {
		name(nullable: false)
		company2(nullable: true, blank: true)
		parentCompany(nullable: true)
		sector(nullable: true)
		companyType(nullable: true)
		companyRole(nullable: true)
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
		//aDocument(nullable: true)
		//aDocumentOriginalFilename(nullable: true, display: false)
		//aDocumentMimeType(nullable: true, display: false)
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
				context {
					domain(name: "Customer")
				}
			}
			property(name: "person") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
				context {
					domain(name: "Customer")
				}
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
				context {
					domain(name: "Customer")
				}
			}
			property(name: "bankAccount") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
				context {
					domain(name: "Customer")
				}
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
