import com.bensmann.cdm.*
import com.bensmann.cdm.acct.*
import com.bensmann.cdm.crm.*
import com.bensmann.cdm.dms.*
import com.bensmann.cdm.product.*
import com.bensmann.cdm.project.*
import com.bensmann.cdm.purchase.*
import com.bensmann.cdm.sale.*
import com.bensmann.voip.*

/**
 * 
 */
class CdmBootStrap {
	
	/**
	 * 
	 */
	private def createIf(arg) {
		if (!arg.dc.findByName(arg.name)) {
			def inst = arg.dc.newInstance(name: arg.name)
			arg.findAll { k, v -> !(k in ["dc", "name"]) }.each { k, v ->
				inst."${k}" = v
			}
			inst.save()
		}
	}
	
	/**
	 * 
	 */
	def init = { servletContext ->
		println "CdmBootStrap.init"
		//
		createIf(dc: CompanyType, name: "Einzelunternehmen")
		createIf(dc: CompanyType, name: "KMU")
		createIf(dc: CompanyType, name: "Konzern")
		createIf(dc: CompanyType, name: "Selbständige Niederlassung")
		createIf(dc: CompanyType, name: "Unselbständige Nierderlassung")
		//
		createIf(dc: CompanyRole, name: "Interessent")
		createIf(dc: CompanyRole, name: "Kunde")
		createIf(dc: CompanyRole, name: "Lieferant")
		createIf(dc: CompanyRole, name: "Partner")
		//
		createIf(dc: PersonType, name: "Geschäftsführer")
		createIf(dc: PersonType, name: "Geschäftsleitung")
		createIf(dc: PersonType, name: "Personalleiter")
		createIf(dc: PersonType, name: "Abteilungsleiter")
		createIf(dc: PersonType, name: "Teamleiter")
		createIf(dc: PersonType, name: "Mitarbeiter")
		//
		createIf(dc: PersonRole, name: "Einkauf")
		createIf(dc: PersonRole, name: "Marketing")
		createIf(dc: PersonRole, name: "Vertrieb")
		createIf(dc: PersonRole, name: "Verkauf")
		createIf(dc: PersonRole, name: "Support")
		//
		createIf(dc: AddressType, name: "Besuchsadresse")
		createIf(dc: AddressType, name: "Rechnungsadresse")
		createIf(dc: AddressType, name: "Lieferadresse")
		//
		createIf(dc: ContactType, name: "Telefon")
		createIf(dc: ContactType, name: "Brief")
		createIf(dc: ContactType, name: "Fax")
		createIf(dc: ContactType, name: "Email")
		//
		createIf(dc: MessengerType, name: "AIM/ICQ")
		createIf(dc: MessengerType, name: "Facebook")
		createIf(dc: MessengerType, name: "GoogleTalk")
		createIf(dc: MessengerType, name: "Jabber")
		createIf(dc: MessengerType, name: "MSN")
		createIf(dc: MessengerType, name: "Skype")
		createIf(dc: MessengerType, name: "Yahoo!")
		//
		createIf(dc: Unit, name: "Stück")
		createIf(dc: Unit, name: "Verpackungseinheit")
		createIf(dc: Unit, name: "Stunden")
		createIf(dc: Unit, name: "Tage")
		createIf(dc: Unit, name: "kg")
		//
		createIf(dc: PaymentType, name: "Vorkasse")
		createIf(dc: PaymentType, name: "sofort")
		createIf(dc: PaymentType, name: "wöchentlich")
		createIf(dc: PaymentType, name: "monatlich")
		createIf(dc: PaymentType, name: "quartalsweise")
		createIf(dc: PaymentType, name: "halbjährlich")
		createIf(dc: PaymentType, name: "jährlich")
		//
		createIf(dc: PaymentTarget, name: "Vorkasse, 0% Skonto", workdays: 0, discountInPercent: 0)
		createIf(dc: PaymentTarget, name: "Vorkasse, 3% Skonto", workdays: 0, discountInPercent: 3)
		createIf(dc: PaymentTarget, name: "sofort, 0% Skonto", workdays: 0, discountInPercent: 0)
		createIf(dc: PaymentTarget, name: "sofort, 3% Skonto", workdays: 0, discountInPercent: 3)
		createIf(dc: PaymentTarget, name: "7 Tage, 0% Skonto", workdays: 7, discountInPercent: 0)
		createIf(dc: PaymentTarget, name: "10 Tage, 0% Skonto", workdays: 10, discountInPercent: 0)
		createIf(dc: PaymentTarget, name: "14 Tage, 0% Skonto", workdays: 14, discountInPercent: 0)
		createIf(dc: PaymentTarget, name: "30 Tage, 0% Skonto", workdays: 30, discountInPercent: 0)
		createIf(dc: PaymentTarget, name: "90 Tage, 0% Skonto", workdays: 90, discountInPercent: 0)
		//
		createIf(dc: VatPercent, name: "DE-7%", value: 7.0d)
		createIf(dc: VatPercent, name: "DE-19%", value: 19.0d)
		//
		createIf(dc: CampaignType, name: "Telefon")
		createIf(dc: CampaignType, name: "Email")
		createIf(dc: CampaignType, name: "Brief")
		createIf(dc: CampaignType, name: "Fax")
		//
		createIf(dc: TicketType, name: "Aufgabe")
		createIf(dc: TicketType, name: "Neue Funktionalität")
		createIf(dc: TicketType, name: "Verbesserung")
		createIf(dc: TicketType, name: "Fehlerbehebung")
		//
		createIf(dc: TicketState, name: "Neu")
		createIf(dc: TicketState, name: "In Arbeit")
		createIf(dc: TicketState, name: "Erledigt")
		createIf(dc: TicketState, name: "Abgelehnt")
		createIf(dc: TicketState, name: "Funktioniert hier")
		//
		createIf(dc: TicketPriority, name: "Normal")
		createIf(dc: TicketPriority, name: "Wichtig")
		createIf(dc: TicketPriority, name: "Blocker")
		createIf(dc: TicketPriority, name: "Kritisch")
		//
		createIf(dc: TicketLogType, name: "Beschreibung")
		createIf(dc: TicketLogType, name: "Rückfrage")
	}
	
	/**
	 * 
	 */
	def destroy = {
	}
	
}
