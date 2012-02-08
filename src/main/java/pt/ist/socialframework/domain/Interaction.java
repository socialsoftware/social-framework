package pt.ist.socialframework.domain;

import java.util.HashSet;
import java.util.Set;

public class Interaction extends Interaction_Base {

	public Set<InteractionRole> getInteractionRoleSetForParty(Party party) {
		Set<InteractionRole> interactionRoleSet = new HashSet<InteractionRole>();
		for(InteractionRolePlay interactionRolePlay : getRolePlaySet()) {
			if(interactionRolePlay.isPlayedBy(party)) {
				interactionRoleSet.add(interactionRolePlay.getRole());
			}
		}
		return interactionRoleSet;
	}
	
}
