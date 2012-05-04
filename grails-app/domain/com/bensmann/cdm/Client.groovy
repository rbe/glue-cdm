package com.bensmann.cdm

import com.bensmann.voip.*

/**
 * The client.
 */
class Client extends Company {
	
	static mapping = {
		table "T1_CL"
	}
	
	static constraints = {
		companyType(display: false)
		companyRole(display: false)
		preferredContactType(display: false)
		paymentType(display: false)
		info(display: false)
		// validator: { val, obj, errors -> }
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
			property(name: "project") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "person") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "address") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "taxInformation") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
			property(name: "bankAccount") {
				mapping(type: "one-to-my-many")
				widget {
					component(test: "moreThan", value: 0, type: "list")
				}
				autoComplete true
			}
		}
	}
	
}
