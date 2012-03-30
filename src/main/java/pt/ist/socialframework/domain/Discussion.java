package pt.ist.socialframework.domain;

public class Discussion extends Discussion_Base {
    
    public  Discussion() {
        super();
    }

	public void createConversation(Conversation conversation) {
		this.addConversation(conversation);
		conversation.setDiscussion(this);
		
	}
    
}
