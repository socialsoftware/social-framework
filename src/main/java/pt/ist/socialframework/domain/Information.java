package pt.ist.socialframework.domain;

import java.util.HashSet;
import java.util.Set;

public class Information extends Information_Base {
    
	public void init(InformationVersion informationVersion) {
		addVersion(informationVersion);
		setLastVersion(informationVersion);
	}
	
	public void addNewInformationVersion(InformationVersion informationVersion) {
		if(hasLastVersion()) {
			addVersion(informationVersion);
			getLastVersion().setNextVersion(informationVersion);
			setLastVersion(informationVersion);			
		} else {
			init(informationVersion);
		}
	}
	
	public Set<Information> getRelatedInformation(InformationRelation informationRelation) {
		Set<Information> information = new HashSet<Information>();
		InformationVersion informationVersion = getLastVersion();
		return information;
	}
	
}
