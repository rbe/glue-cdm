package com.bensmann.cdm.project

import com.bensmann.cdm.*
import com.bensmann.cdm.crm.*
import java.util.concurrent.TimeUnit
import java.sql.Timestamp

/**
 * A project.
 */
class Project extends Base {
	
	/**
	 * Name.
	 */
	String name
	
	/**
	 * Description.
	 */
	String description
	
	/**
	 * 
	 */
	Customer customer
	
	/**
	 * Manager of this project.
	 */
	Person manager
	
	/**
	 * Worker of this project.
	 */
	Person worker
	
	/**
	 * When was this project started?
	 */
	Timestamp workStartedAt
	
	/**
	 * When was this project completed?
	 */
	Timestamp workCompletedAt
	
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
		String.format("PJ-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Project.count() + 1)
	}
	
	static hasMany = [
		worker: Person,
		attachment: java.sql.Blob,
		timeSheetEntry: TimeSheetEntry, // Timesheet for e.g. project leader
		ticket: Ticket // Tickets for this project, used for requirements to fullfil as well
	]
	
	static constraints = {
		name(nullable: false)
		description(nullable: true, maxSize: 4000)
		customer(nullable: true,)
		manager(nullable: true)
		worker(nullable: true)
		workStartedAt(nullable: true)
		workCompletedAt(nullable: true)
		timeSheetEntry(nullable: true)
		ticket(nullable: true)
	}
	
	static mapping = {
		table "T1_PROJ"
		attachment column: "att"
		timeSheetEntry column: "tse"
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
			property(name: "customer") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "manager") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				context { // Property 'manager'
					domain(name: "Customer") { // From domain class Customer
						person(role: "Manager") // Use all persons having role=Manager
					}
					domain(name: "Client") { // From domain class Client
						person(role: "Project Manager") // Use all persons having role=Project Manager
					}
				}
				autoComplete true
			}
			property(name: "worker") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "timeSheetEntry") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "ticket") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
	// How to map data of this project to OOo templates, use GPath for values
	def odiseeRequest = {
		odisee {
			request(name: "Projektbericht", id: id) {
				ooo(
					host: "127.0.0.1",
					port: 2002,
					"pre-save-macro": "",
					outputPath: "",
					outputFormat: "PDF"
				)
				template(name: "Projektbericht", revision: "LATEST")
				archive(database: false, files: false)
				userfields {
					userfield(name: "customer_name", "post-set-macro": "", customer?.name)
				}
			}
		}
	}
	
}
