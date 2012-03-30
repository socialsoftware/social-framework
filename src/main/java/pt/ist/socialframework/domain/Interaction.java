package pt.ist.socialframework.domain;

import java.util.ArrayList;

public class Interaction extends Interaction_Base {
	
	public void connectInteraction(Interaction interactionToConnect) {
		if(interactionToConnect !=  null) {
			this.addDestinationInteraction(interactionToConnect);
			interactionToConnect.setSourceInteraction(this);
		}
	}
	
	public Interaction fulfillInteraction(ArrayList<Information> originalInformation, ArrayList<Information> clonedInformation) {
		if(clonedInformation != null) {
			int clonedInformationSize =  clonedInformation.size();
			for(int i = 0; i < clonedInformationSize ; ++i) {
				this.addInformation(clonedInformation.get(i));
				 clonedInformation.get(i).setInteraction(this);
			}
		}
		else {
			int originalInformationSize =  originalInformation.size();
			for(int i = 0; i < originalInformationSize ; ++i) {
				this.addInformation(originalInformation.get(i));
				 originalInformation.get(i).setInteraction(this);
			}
		}
		return this;
	}
	
	

}
