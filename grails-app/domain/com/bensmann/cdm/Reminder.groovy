package com.bensmann.cdm

/**
 * A reminder.
 */
class Reminder {
	
	/**
	 * The name.
	 */
	String name
	
	/**
	 * For whom?
	 */
	Person person
	
	/**
	 * The date and time.
	 */
	Date remindOn
	
	/**
	 * Optional message.
	 */
	String message
	
	
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
		String.format("REM-%s-%03d", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 100 + Reminder.count() + 1)
	}
	
	static constraints = {
		name(nullable: false)
		person(nullable: true)
		remindOn(nullable: true)
		message(nullable: true, maxSize: 4000)
	}
	
	static mapping = {
		table "T1_REM"
	}
	
	static glueConstraints = {
		glue {
			property(name: "person") {
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
}
