package pt.ist.socialframework.domain;

import java.util.HashSet;
import java.util.Set;

public class InformationVersion extends InformationVersion_Base {
    
    public  InformationVersion() {
        super();
    }
    
    
	
	public Set<InformationVersion> getRelatedInformationVersionSet(InformationRelationType informationRelationType) {
		Set<InformationVersion> informationVersionSet = new HashSet<InformationVersion>();
		
		for(InformationRelation informationRelation : getInformation().getSourceInformationRelationSet()) {
			
		}
		
		return informationVersionSet;
	}
    
}
