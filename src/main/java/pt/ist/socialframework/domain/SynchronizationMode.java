package pt.ist.socialframework.domain;

import pt.ist.socialframework.exception.InteractionNotClosedException;
import pt.ist.socialframework.exception.ReadOnlySynchronizationModeException;

public class SynchronizationMode extends SynchronizationMode_Base {
    
	public enum HowSynchronizationMade {AUTOMATIC, ACCEPTANCE}
	public enum WhenSynchronizationMade {INSTANT, INTERACTION, BYDEMAND}
	public enum AcessSynchronization {WRITE, READ}
	
    public SynchronizationMode() {
        super();
    }

    public void syncAttributes(){
    	
    }
    
    public void interactionClosed()
    {
    	
    }
    
    public void sync() throws ReadOnlySynchronizationModeException, InteractionNotClosedException {
//    	if(getAcessSynchronization().equals(AcessSynchronization.READ)){
//    		throw new ReadOnlySynchronizationModeException("Unable to sync because acess is read only");
//    	}else{
//    		if(getWhenSynchronizationMade().equals(WhenSynchronizationMade.INSTANT)){
//    			if(getHowSynchronizationMade().equals(HowSynchronizationMade.AUTOMATIC)){
//    				automaticSync();
//    			}
//    			if(getHowSynchronizationMade().equals(HowSynchronizationMade.ACCEPTANCE)){
//    				acceptanceSync();
//    			}
//    		}else if(getWhenSynchronizationMade().equals(WhenSynchronizationMade.INTERACTION)){
//    			if(this.getInformationCloned().getInteraction().getState().equals(StateOfInteraction.OPEN)){
//    				throw new InteractionNotClosedException("Unable to sync, because the interaction is not closed");
//    			}else{
//    				if(getHowSynchronizationMade().equals(HowSynchronizationMade.AUTOMATIC)){
//        				automaticSync();
//        				}
//        			if(getHowSynchronizationMade().equals(HowSynchronizationMade.ACCEPTANCE)){
//        				acceptanceSync();
//        				}
//        			}
//    			}
//    		System.out.println("sync do sync mode");
//    		}
    	}

	private void acceptanceSync() {
		// TODO Auto-generated method stub
		
	}

	private void automaticSync() {
		// TODO Auto-generated method stub
		
	}
}
