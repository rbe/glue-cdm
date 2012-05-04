package com.bensmann.cdm.product

import com.bensmann.cdm.*
import com.bensmann.cdm.crm.*

/**
 * A product.
 */
class Product extends Base {
	
	/**
	 * Name.
	 */
	String name
	
	/**
	 * Ident of product.
	 */
	String productIdent
	
	/**
	 * Type of product: e.g. an article or a service?
	 */
	ProductType productType
	
	/**
	 * Optional description.
	 */
	String description
	
	/**
	 * Price for this product.
	 */
	Price price
	
	/**
	 * An optional comment.
	 */
	String info
	
	/**
	 * Unique, one-time product?
	 */
	Boolean oneTime
	
	/**
	 * 
	def beforeInsert = {
		if (!productIdent) {
			productIdent = generateName()
		}
		//calculateComposites()
	}
	
	def beforeUpdate = {
		//calculateComposites()
		//calculatePrice(this)
	}
	 */
	
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
	 * Calculate price of a single product.
	def calculatePrice(p) {
		if (p.priceNet && p.vatPercent) {
			p.vatAmount = p.priceNet * (p.vatPercent / 100)
			p.priceGross = p.priceNet + p.vatAmount
		}
	}
	 */
	
	/**
	 * Calculate and summarize net price of composites, if any
	def calculateComposites() {
		if (composite) {
			this.priceNet = composite?.collect { p ->
				calculatePrice(p)
				p.priceNet
			}?.sum {
				it
			}
		}
	}
	 */
	
	/**
	 * 
	Double getPriceGross() {
		calculateComposites()
		calculatePrice(this)
		this.priceGross
	}
	 */
	
	/**
	 * Generate a name.
	 */
	def generateName() {
		String.format("P-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Product.count() + 1)
	}
	
	static hasMany = [
		composite: Product,
		sector: Sector,
	]
	
	static constraints = {
		name(nullable: false)
		productIdent(nullable: true)
		productType(nullable: true)
		oneTime(nullable: true)
		composite(nullable: true)
		sector(nullable: true)
		description(nullable: true, maxSize: 4000)
		price(nullable: true)
		info(nullable: true, maxSize: 4000)
	}
	
	static mapping = {
		table "T1_PROD"
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
			property(name: "productType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "composite") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
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
			property(name: "price") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
				context {
					domain(name: "Product")
				}
			}
		}
	}
	
}
