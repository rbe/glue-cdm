package com.bensmann.cdm.product

import com.bensmann.cdm.*
import com.bensmann.cdm.purchase.*

/**
 * A price for purchasing a product.
 */
class Price extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	Supplier supplier
	
	/**
	 * 
	 */
	double quantity
	Unit unit
	
	/**
	 * Currency this price is in.
	 * TODO Migrate to currency plugin: http://www.grails.org/Currencies%20plugin
	 */
	Currency currency
	
	/**
	 * Net price.
	 */
	double priceNet
	
	/**
	 * VAT
	 */
	VatPercent vatPercent
	double vatAmount
	
	/**
	 * Gross price.
	 */
	double priceGross
	
	/**
	 * 
	 */
	String priceIntervalTerm
	
	/**
	 * Updates values before insert/update.
	 */
	def beforeInsert = {
		check()
	}
	
	def beforeUpdate = {
		check()
	}
	
	/**
	 * 
	 */
	private def check() {
		// Try to set default VAT
		try {
			if (!vatPercent) vatPercent = VatPercent.findByName("DE-19%")
		} catch (e) {
			// ignore
		}
		// Try to set default unit
		try {
			if (!unit) unit = Unit.findByName("Stück")
		} catch (e) {
			// ignore
		}
		// Name
		if (priceIntervalTerm || priceNet) {
			def builder = new StringBuilder()
			def add = { t, prepend = null, append = null ->
				if (t) {
					if (builder.length() > 0) builder << " "
					builder << (prepend ?: "") << t << (append ?: "")
				}
			}
			add priceIntervalTerm
			add priceNet
			add currency
			add quantity, "per "
			add unit?.name
			name = builder.toString()
		}
	}
	
	static constraints = {
		name(nullable: false)
		supplier(nullable: true)
		quantity(nullable: true)
		unit(nullable: true)
		currency(nullable: true)
		priceNet(nullable: true)
		vatPercent(nullable: true)
		vatAmount(nullable: true, editable: false)
		priceGross(nullable: true, editable: false)
		priceIntervalTerm(nullable: true, inList: ["einmalig", "täglich", "wöchentlich", "14-tägig", "monatlich", "3-monatlich", "halbjährlich", "jährlich"])
	}
	
	static mapping = {
		table "T1_PRI"
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
			property(name: "supplier") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "unit") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "vatPercent") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
