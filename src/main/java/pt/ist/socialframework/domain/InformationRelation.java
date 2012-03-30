package pt.ist.socialframework.domain;

public class InformationRelation extends InformationRelation_Base {
    
    public  InformationRelation() {
        super();
    }
    
    public void addInformationToInformationRelation(Information informationDestination) {
    	this.addInformationDestination(informationDestination);
		informationDestination.addInformationRelationDestination(this);
	}
}
