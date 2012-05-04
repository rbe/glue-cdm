package com.bensmann.cdm

/**
 * A base class for all entities.
 */
abstract class Base implements java.io.Serializable {
	
	/**
	 * 
	 */
	Long id
	
	/**
	 * 
	 */
	Long version
	
	/**
	 * 
	 */
	Date dateCreated
	
	/**
	 * 
	 */
	Long createdByPersonId
	
	/**
	 * 
	 */
	Date lastUpdated
	
	/**
	 * 
	 */
	Long updatedByPersonId
	
	static hasMany = [
		reminder: Reminder
	]
	
	static constraints = {
		dateCreated(nullable: true, display: true, editable: false)
		createdByPersonId(nullable: true, display: false, editable: false)
		lastUpdated(nullable: true, display: true, editable: false)
		updatedByPersonId(nullable: true, display: false, editable: false)
		reminder(nullable: true)
	}
	
	static mapping = {
		createdByPersonId column: "cre_per_id"
		updatedByPersonId column: "upd_per_id"
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
