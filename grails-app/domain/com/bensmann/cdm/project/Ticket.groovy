package com.bensmann.cdm.project

import com.bensmann.cdm.*

/**
 * 
 */
class Ticket extends Base {
	
	/**
	 * 
	 */
	String name
	
	/**
	 * 
	 */
	String description
	
	/**
	 * 
	 */
	TicketType ticketType
	
	/**
	 * 
	 */
	TicketPriority ticketPriority
	
	/**
	 * 
	 */
	TicketState ticketState
	
	/**
	 * 
	 */
	Person reporter
	
	/**
	 * 
	 */
	Person assignee
	
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
		String.format("TC-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Ticket.count() + 1)
	}
	
	static hasMany = [
		ticketLog: TicketLog
	]
	
	static constraints = {
		name(nullable: false)
		reporter(nullable: true)
		assignee(nullable: true)
		ticketType(nullable: true)
		ticketPriority(nullable: true)
		ticketState(nullable: true)
		description(nullable: true, maxSize: 4000)
		ticketLog(nullable: true)
	}
	
	static mapping = {
		table "T1_TC"
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
			property(name: "reporter") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				context {
					domain(name: "Customer") {
						person(role: "Manager")
					}
					domain(name: "Client") {
						person(role: "Project Manager")
					}
				}
			}
			property(name: "assignee") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				context {
					domain(name: "Customer") {
						person(role: "Manager")
					}
					domain(name: "Client") {
						person(role: "Project Manager")
					}
				}
			}
			property(name: "ticketType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "ticketPriority") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "ticketState") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "ticketType") {
				widget {
					component(test: "lessThan", value: 10, type: "radioGroup")
					component(test: "moreThan", value: 10, type: "list")
				}
				autoComplete true
			}
			property(name: "ticketLog") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
