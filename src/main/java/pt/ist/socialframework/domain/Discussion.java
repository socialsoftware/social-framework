package pt.ist.socialframework.domain;

import org.joda.time.DateTime;

public class Discussion extends Discussion_Base {
    
    public  Discussion() {
        super();
    }

	public void createConversation(Party party, String message) {
		Conversation conversation = new Conversation();
		conversation.setCreationTime(new DateTime());
		conversation.setMessage(message);
		conversation.setSender(party);
		this.addConversation(conversation);
		conversation.setDiscussion(this);
	}
    
}
