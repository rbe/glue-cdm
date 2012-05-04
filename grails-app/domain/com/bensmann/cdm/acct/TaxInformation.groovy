package com.bensmann.cdm.acct

/**
 * 
 */
class TaxInformation {
	
	//Currency currency
	String name
	
	String salesTaxId
	
	String vatId
	
	Boolean canSubtractVat
	
	/**
	 * Do before insert.
	 */
	def beforeInsert = {
		if (!name || name ==~ "GENERATED.*") {
			name = generateName()
		}
		canSubtractVat = true
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
		String.format("TI-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + TaxInformation.count() + 1)
	}
	
	static constraints = {
		//currency(nullable: true)
		name(nullable: false)
		salesTaxId(nullable: true)
		vatId(nullable: true)
		canSubtractVat(nullable: true)
	}
	
	static mapping = {
		table "T1_TAXINFO"
	}
	
}
