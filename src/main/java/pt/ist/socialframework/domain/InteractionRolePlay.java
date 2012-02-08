package pt.ist.socialframework.domain;

public class InteractionRolePlay extends InteractionRolePlay_Base {

	public boolean isPlayedBy(Party party) {
		return hasParty() && getParty().equals(party);
	}

    
}
