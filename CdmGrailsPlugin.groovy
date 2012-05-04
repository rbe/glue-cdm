import grails.util.GrailsUtil

/**
 * 
 */
class CdmGrailsPlugin {
	
	/**
	 * Author and plugin.
	 */
	def author = "Ralf Bensmann"
	def authorEmail = "grails@bensmann.com"
	def title = "Cdm plugin."
	def description = """Data structures needed for company administration."""
	
	/**
	 * URL to the plugin's documentation.
	 */
	def documentation = "http://grails.org/cdm+Plugin"
	
	/**
	 * The plugin version.
	 */
	def version = "1.2.0"
	
	/**
	 * The version or versions of Grails the plugin is designed for.
	 */
	def grailsVersion = "1.2.0> *"
	
	/**
	 * Other plugins this plugin depends on.
	 */
	def dependsOn = [
		core: GrailsUtil.grailsVersion,
		hibernate: GrailsUtil.grailsVersion
	]
	
	/**
	 * 
	 */
	def loadAfter = [
		"hibernate"
	]
	
	/**
	 * Other plugins influenced by this plugin.
	 * See http://www.grails.org/Auto+Reloading+Plugins
	 */
	def influences = [
		//"hibernate"
	]
	
	/**
	 * Plugins to observe for changes.
	 * See http://www.grails.org/Auto+Reloading+Plugins
	 */
	def observe = [
		//"hibernate"
	]
	
	/**
	 * Resources to watch.
	 * See http://www.grails.org/Auto+Reloading+Plugins
	 */
	def watchedResources = []
	
	/**
	 * Resources that are excluded from plugin packaging.
	 */
	def pluginExcludes = [
		//"grails-app/conf/",
		"grails-app/views/"
	]
	
	/**
	 * Implement runtime spring config (optional).
	 * See http://www.grails.org/Runtime+Configuration+Plugins
	 */
	def doWithSpring = {
		// Constraints
		//ConstrainedProperty.registerNewConstraint(BestFrameworkConstraint.NAME, BestFrameworkConstraint.class);
	}
	
	/**
	 * Implement post initialization spring config (optional).
	 * See http://www.grails.org/Runtime+Configuration+Plugins
	 */
	def doWithApplicationContext = { applicationContext ->
	}
	
	/**
	 * Implement additions to web.xml (optional).
	 * See http://www.grails.org/Runtime+Configuration+Plugins
	 */
	def doWithWebDescriptor = { xml ->
	}
	
	/**
	 * Implement registering dynamic methods to classes (optional).
	 * See http://www.grails.org/Plugin+Dynamic+Methods
	 */
	def doWithDynamicMethods = { ctx ->
	}
	
	/**
	 * Implement code that is executed when any artefact that this plugin is
	 * watching is modified and reloaded. The event contains: event.source,
	 * event.application, event.manager, event.ctx, and event.plugin.
	 */
	def onChange = { event ->
		println "${this.class.name}: onChange"
	}
	
	/**
	 * Implement code that is executed when the project configuration changes.
	 * The event is the same as for 'onChange'.
	 */
	def onConfigChange = { event ->
		println "${this.class.name}: onConfigChange"
	}
	
	/**
	 * 
	 */
	def onShutdown = { event ->
		println "${this.class.name}: shutdown"
	}
	
}
