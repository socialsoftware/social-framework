package pt.ist.socialframework.domain;

import org.joda.time.DateTime;

public class PartyInteractionRole extends PartyInteractionRole_Base{

	public PartyInteractionRole(Party party, Interaction interaction,
			InteractionRole interactionRole) {
		setParty(party);
		setInteraction(interaction);
		setInteractionRole(interactionRole);

		addEffectivePeriod(new EffectivePeriod(new DateTime()));
		
	}

}
