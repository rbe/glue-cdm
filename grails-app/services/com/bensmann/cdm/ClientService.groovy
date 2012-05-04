package com.bensmann.cdm

/**
 * Client service.
 */
class ClientService {
	
	/**
	 * The scope. See http://www.grails.org/Services.
	 */
	def scope = "singleton" // prototype request flash flow conversation session singleton
	
	/**
	 * Transactional?
	 */
	boolean transactional = true
	
	/**
	 * 
	 */
	def grailsApplication
	
	/**
	 * Get a client.
	 */
	def getClient = { id ->
		Client.get(id)
	}
	
	/**
	 * 
	 */
	def getSipgateAccount = { id ->
		Client.get(id).sipgateAccount
	}
	
	/**
	 * 
	 */
	def getSipgateCredentials = { id ->
		def sga = Client.get(id).sipgateAccount
		[username: sga.username, password: sga.password]
	}
	
	/**
	 * 
	 */
	def getSipgateLocalUri = { id ->
		Client.get(id).sipgateAccount.localUri
	}
	
}
