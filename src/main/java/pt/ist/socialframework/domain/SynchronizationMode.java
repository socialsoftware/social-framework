package pt.ist.socialframework.domain;

public class SynchronizationMode extends SynchronizationMode_Base {
    
	public enum SynchronizationState {READONLY, AUTOMATICWRITE, MANUALWRITE}
	
    public SynchronizationMode() {
        super();
    }

    public void sync() {
    	System.out.println("sync do sync mode");
    }
}
