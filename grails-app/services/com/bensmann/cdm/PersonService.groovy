package com.bensmann.cdm

import com.bensmann.cdm.voip.*

/**
 * Manage a person.
 */
class PersonService {
	
	/**
	 * The scope. See http://www.grails.org/Services.
	 */
	def scope = "singleton" // prototype request flash flow conversation session singleton
	
	/**
	 * Transactional?
	 */
	boolean transactional = true
	
	/**
	 * Set the VoIP account for a person.
	 * @param arg Map with personId, voipAccountId
	 * 		OR map voipAccount with keys = name, username, password, localUri
	 */
	def setVoipAccount(arg) {
		assert arg.personId
		def vid = arg.voipAccountId
		// No ID for voipAccount
		if (!vid && arg.voipAccount) {
			def voipAccount = new VoipAccount(arg.voipAccount)
			voipAccount.save(flush: true)
			voipAccount.refresh()
			vid = voipAccount.id
		}
		def ret = false
		if (vid) {
			try {
				Person.get(arg.personId).voipAccount = VoipAccount.get(vid)
				ret = true
			} catch (e) {
				if (log.debugEnabled) e.printStackTrace()
				log.error "setVoipAccount(${arg.inspect()}): Could not associate: ${e}"
			}
		} else {
			log.error "No VoIP account information"
		}
		ret
	}
	
	/**
	 * Get VoIP account for a person.
	 */
	def getVoipAccount(arg) {
		assert arg.personId
		try {
			Person.get(arg.personId).voipAccount
		} catch (e) {
			if (log.debugEnabled) e.printStackTrace()
			log.error "getVoipAccount(${arg.inspect()}): Got no VoIP account: ${e}"
		}
	}
	
	/**
	 * Get credentials for VoIP account of a person.
	 */
	def getVoipAccountCredentials(arg) {
		assert arg.personId
		def ret = [:]
		try {
			def voipAccount = Person.get(arg.personId).voipAccount
			if (voipAccount) {
				ret = [username: voipAccount.username, password: voipAccount.password, localUri: voipAccount.localUri]
			}
		} catch (e) {
			if (log.debugEnabled) e.printStackTrace()
			log.error "getVoipAccountCredentials(${arg.inspect()}): Got no VoIP credentials: ${e}"
		}
		ret
	}
	
}
