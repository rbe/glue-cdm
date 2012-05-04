package com.bensmann.cdm.acct

/**
 * Items are a copy of e.g. a Product instance: we need an unchangeable instance (of a product)
 * at the time it was offered, ordered or sold.
 */
class AcctItem {
	
	String name
	String productIdent
	
	double priceNet
	double vatPercent
	double vatAmount
	double priceGross
	
	double quantity
	String unit
	
	static mapping = {
		table "T1_ACCT_ITEM"
	}
	
	static constraints = {
		name(nullable: false)
		productIdent(nullable: false)
		priceNet(nullable: false)
		vatPercent(nullable: false)
		vatAmount(nullable: false)
		priceGross(nullable: false)
		quantity(nullable: false)
		unit(nullable: false)
	}
	
}
