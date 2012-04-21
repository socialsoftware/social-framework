package pt.ist.socialframework.domain;

import java.util.ArrayList;

import org.apache.ojb.jdo.jdoql.ThisExpression;
import org.joda.time.DateTime;

import pt.ist.socialframework.domain.InteractionState.StateOfInteraction;
import pt.ist.socialframework.domain.SynchronizationMode.AcessSynchronization;
import pt.ist.socialframework.domain.SynchronizationMode.WhenSynchronizationMade;
import pt.ist.socialframework.exception.InteractionNotClosedException;
import pt.ist.socialframework.exception.ReadOnlySynchronizationModeException;


public class Interaction extends Interaction_Base {
	

	public Interaction(){
		InteractionState state = new InteractionState();
		state.setStateOfInteraction(StateOfInteraction.OPEN);
		setState(state);
		state.setInteraction(this);
	}
	
	public void createDiscussion(Party party, String theme) {
		Discussion discussion =  new Discussion();
		discussion.setCreationTime(new DateTime());
		discussion.setTheme(theme);
		discussion.setCreator(party);

		addDiscussion(discussion);
//		discussion.setInteraction(this);
	}
	
	public void connectInteraction(Interaction interactionToConnect) {
		if(interactionToConnect !=  null) {
			this.addDestinationInteraction(interactionToConnect);
			interactionToConnect.setSourceInteraction(this);
		}
	}
	
	public Interaction fulfillInteraction(ArrayList<Information> informationList) {
		int clonedInformationSize =  informationList.size();
		for(int i = 0; i < clonedInformationSize ; ++i) {
			this.addAceptedInformation(informationList.get(i));
			informationList.get(i).setInteractionWithAcceptedInformation(this);
			}
		return this;
	}
	
	public void createOriginalInformation(){
		
	}
	
	public void closeInteraction(){
		getState().setStateOfInteraction(StateOfInteraction.CLOSED);
		for(Information info : getAceptedInformation()){
			if(info.getClonedSynchronizationMode().getAcessSynchronization().equals(AcessSynchronization.WRITE)){
				if(info.getClonedSynchronizationMode().getWhenSynchronizationMade().equals(WhenSynchronizationMade.INTERACTION)){
//					info.
				}
			}
		
		}
	}
	
	public void synchronizeInformation(Interaction sourceInteraction ,ArrayList<Information> informationToSync){		
		ArrayList<Information> informationSynchronized = new ArrayList<Information>();
		int informationToSyncCount = informationToSync.size();
		
		for(int i = 0; i <= informationToSyncCount; ++i){
			Information info = informationToSync.get(i);
			if(info.hasClonedSynchronizationMode()){
				try {
					info.getClonedSynchronizationMode().sync();
				} catch (ReadOnlySynchronizationModeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InteractionNotClosedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int j = i; j <= informationToSyncCount; ++j){
					Information relatedInformation = informationToSync.get(j);
					for(InformationRelation relation : relatedInformation.getInformationRelationDestination()){
						for(InformationRelation relatedRelation : info.getInformationRelationSource()){
							if(relation.equals(relatedRelation)){
//								if(info.getClonedSynchronizationMode().getOriginalInformation())
//									info.getClonedSynchronizationMode().getOriginalInformation();
									}
							}
						}
					}
				}
			else{
//				No caso de ser um novo objecto criado numa sub interacção, talvez o modo de sincronização devia de ser manual

			}
		}	
	}
}
