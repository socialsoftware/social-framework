package pt.ist.socialframework.domain;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import pt.ist.identity.pvg.server.domain.Conversation;
import pt.ist.identity.pvg.shared.util.dto.ConversationDto;
import pt.ist.identity.pvg.shared.util.dto.ConversationSetDto;

public class Interaction extends Interaction_Base {

	public DateTime createConversation(String message)
	{
		DateTime time = new DateTime();
		Conversation conversation = new Conversation();
		conversation.setMessage(message);
		conversation.setInteraction(this);
		
		conversation.setCreationTime(time);
		return time;
	}
	
	public ConversationSetDto getConversationsOfInteration() {
		Set<ConversationDto> conversationsDto =  new HashSet<ConversationDto>();
		
		for(Information info : getInformationSet()) {
			if(info instanceof Conversation) {
				ConversationDto conversationDto =  new ConversationDto();
				conversationDto.setCreationTime(((Conversation)info).getCreationTime());
				conversationDto.setMessage(((Conversation)info).getMessage());
				conversationsDto.add(conversationDto);
			}
		}
		ConversationSetDto conversationSetDto = new ConversationSetDto(conversationsDto);
		return conversationSetDto;
	}
//	public Set<Conversation> getConversations()	{
//		Set<Conversation> conversation =  new HashSet<Conversation>();
//		for(Information info : getInformationSet()){
//			if(info instanceof Conversation) {
//				conversation.add((Conversation) info);
//			}
//		}
//		return conversation;	 
//	}
	
//	public Set<InteractionRole> getInteractionRoleSetForParty(Party party) {
//		Set<InteractionRole> interactionRoleSet = new HashSet<InteractionRole>();
//		for(PartyInteractionRole partyInteractionRole : getPartyInteractionRoleSet()) {
//			if(partyInteractionRole.getParty().equals(party)) {
//				interactionRoleSet.add(partyInteractionRole.getInteractionRole());
//			}
//		}
//		return interactionRoleSet;
//	}
	
}
