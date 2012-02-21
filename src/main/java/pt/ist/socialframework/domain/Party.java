package pt.ist.socialframework.domain;

public class Party extends Party_Base {

	public void init(PartyInteractionRole partyInteractionRole)
	{
		addPartyInteractionRole(partyInteractionRole);
	}
}
