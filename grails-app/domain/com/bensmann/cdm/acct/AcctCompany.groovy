package com.bensmann.cdm.acct

import com.bensmann.cdm.*

/**
 * 
 */
class AcctCompany {
	
	String name
	
	String company2
	
	String contactFirstname
	String contactLastname
	
	String websiteUrl
	String emailAddress
	
	String addressStreet
	String addressPostcode
	String addressCity
	String telephone
	String fax
	
	String taxInformationTaxId
	String taxInformationVatId
	
	String bankAccountHolder
	String bankAccountNumber
	String bankAccountBankName
	String bankAccountBankCode
	Boolean bankAccountDebitEntryAllowed
	String paymentType
	
	static mapping = {
		table "T1_ACCT_CO"
		contactFirstname column: "c_firstname"
		contactLastname column: "c_lastname"
		taxInformationTaxId column: "ti_taxid"
		taxInformationVatId column: "ti_vatid"
		bankAccountHolder column: "ba_holder"
		bankAccountNumber column: "ba_number"
		bankAccountBankName column: "ba_bankname"
		bankAccountBankCode column: "ba_code"
		bankAccountDebitEntryAllowed column: "ba_debitallowed"
	}
	
	static constraints = {
		name(nullable: false)
		company2(nullable: true)
		contactFirstname(nullable: true)
		contactLastname(nullable: true)
		websiteUrl(nullable: true)
		emailAddress(nullable: true)
		addressStreet(nullable: true)
		addressPostcode(nullable: true)
		addressCity(nullable: true)
		telephone(nullable: true)
		fax(nullable: true)
		taxInformationTaxId(nullable: true)
		taxInformationVatId(nullable: true)
		bankAccountHolder(nullable: true)
		bankAccountNumber(nullable: true)
		bankAccountBankName(nullable: true)
		bankAccountBankCode(nullable: true)
		bankAccountDebitEntryAllowed(nullable: true)
		paymentType(nullable: true)
	}
	
	static glueConstraints = {
		glue {
		}
	}
	
}
