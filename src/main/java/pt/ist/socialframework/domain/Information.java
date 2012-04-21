package pt.ist.socialframework.domain;

import pt.ist.socialframework.domain.ChangesState.State;
import pt.ist.socialframework.domain.SynchronizationMode.AcessSynchronization;
import pt.ist.socialframework.domain.SynchronizationMode.HowSynchronizationMade;
import pt.ist.socialframework.domain.SynchronizationMode.WhenSynchronizationMade;
import pt.ist.socialframework.exception.AttributeCreationFailException;


public class Information extends Information_Base{
	
	public Information() {
		ChangesState changes = new ChangesState();
		changes.setState(State.NEW);
		this.setChangeState(changes);
		changes.setInformation(this);
	}
	
	public void informationChanged() {
		this.getChangeState().setState(State.CHANGED);
	}
//	public Information(){
//		AcessSynchronization acess = AcessSynchronization.WRITE;
//		HowSynchronizationMade how = HowSynchronizationMade.AUTOMATIC;
//		WhenSynchronizationMade when = WhenSynchronizationMade.INSTANT;
//		
//		for(InformationRelation relation : getInformationRelationDestination()){
//			Information info =  relation.getInformationSource();
//			if(getInteraction().hasInformation(info)){
//				SynchronizationMode syncMode = relation.getInformationSource().getClonedSynchronizationMode();
//				if(syncMode.getAcessSynchronization().equals(AcessSynchronization.READ)){
//					acess = AcessSynchronization.READ;
//				}
//				if(syncMode.getHowSynchronizationMade().equals(HowSynchronizationMade.ACCEPTANCE)){
//					how = HowSynchronizationMade.ACCEPTANCE;
//				}
//				if(syncMode.getWhenSynchronizationMade().equals(WhenSynchronizationMade.INTERACTION)){
//					when = WhenSynchronizationMade.INTERACTION;
//				}
//				if(syncMode.getWhenSynchronizationMade().equals(WhenSynchronizationMade.BYDEMAND)){
//					when = WhenSynchronizationMade.BYDEMAND;
//				}
//			}
//		}	
//	}
		
	public void createAttribute(String role, String value) throws AttributeCreationFailException {
		AttributeRole attributeRole = null;
		
		if(this.hasInteractionWithAcceptedInformation()){
			attributeRole = this.getInteractionWithAcceptedInformation().getSocialPlatform().getAttributeRoleManager().createAttributeRole(role);
		}else if(this.hasInteractionWithInformationForAcceptance()){
			attributeRole = this.getInteractionWithInformationForAcceptance().getSocialPlatform().getAttributeRoleManager().createAttributeRole(role);
		}else{
			throw new AttributeCreationFailException("Unable to create the attribute");
		}
		
		if(role.equals("Text")) {
			TextAttribute textAttribute =  new TextAttribute(attributeRole);
			textAttribute.setTextValue(value);
			textAttribute.setInformation(this);
			this.addAttribute(textAttribute);
		}
		else
		{
			Attribute attribute = new Attribute(attributeRole);
			attribute.setValue(value);
			attribute.setInformation(this);
			this.addAttribute(attribute);
		}
		informationChanged();
	}
	
	public void createAttribute(String role, float value) throws AttributeCreationFailException {
		AttributeRole attributeRole = null;
		
		if(this.hasInteractionWithAcceptedInformation()){
			attributeRole = this.getInteractionWithAcceptedInformation().getSocialPlatform().getAttributeRoleManager().createAttributeRole(role);
		}else if(this.hasInteractionWithInformationForAcceptance()){
			attributeRole = this.getInteractionWithInformationForAcceptance().getSocialPlatform().getAttributeRoleManager().createAttributeRole(role);
		}else{
			throw new AttributeCreationFailException("Unable to create the attribute");
		}
		NumericAttribute numericAttribute = new NumericAttribute(attributeRole);
		numericAttribute.setNumericValue(value);
		numericAttribute.setInformation(this);
		this.addAttribute(numericAttribute);
		informationChanged();
	}
	
	public boolean isTheSameType(Information targetInformation) {
		System.out.println("IsTheSameType Method in Information");
		return (targetInformation instanceof Information);
	}
	
	public void createInformationRelation(Information informationDestination) {
		boolean added = false;
		if(this.hasAnyInformationRelationSource()) {
			for(InformationRelation relation : getInformationRelationSource()) {
				if(relation.hasAnyInformationDestination()) {
					if(informationDestination.isTheSameType(relation.getInformationDestination().get(0))) {
						relation.addInformationDestination(informationDestination);
						informationDestination.addInformationRelationDestination(relation);
						added = true;
					}
				}
				else
					break;					
				}
			}
		if(added == false){
			InformationRelation informationRelation = new InformationRelation();
			this.addInformationRelationSource(informationRelation);
			informationRelation.setInformationSource(this);
			informationDestination.addInformationRelationDestination(informationRelation);
			informationRelation.addInformationDestination(informationDestination);
		}
		informationChanged();
	}
	
	public Information createClone(SynchronizationMode mode, Information clonedInformation) {
		
		this.addOriginalSynchronizationMode(mode);
		mode.setOriginalInformation(this);
		
		mode.setInformationCloned(clonedInformation);
		clonedInformation.setClonedSynchronizationMode(mode);
		if(this.hasAnyAttribute()) {
			for(Attribute attr : this.getAttribute()) {
				Attribute clonedAttribute =  new Attribute();
				attr.createClone(clonedAttribute);
				clonedAttribute.setInformation(clonedInformation);
				clonedInformation.addAttribute(clonedAttribute);
			}
		}
		clonedInformation.setRole(this.getRole());
		this.getRole().addInformation(clonedInformation);
		return clonedInformation;
	}

	public void createOriginalAttributes(){
		
	}
	
	public void sync() {
		SynchronizationMode syncMode = this.getClonedSynchronizationMode();
		Information originalInformation = syncMode.getOriginalInformation();
		
		for(Attribute attr : this.getAttribute()){
			if(attr.hasAnyOriginalSynchronizationMode()){
				if(attr.getChangeState().equals(State.CHANGED)){
					attr.sync();
				}
			}
			else{
				if(!syncMode.getAcessSynchronization().equals(AcessSynchronization.READ)){
					Attribute originalAttribute = new Attribute();
					attr.createClone(originalAttribute);
					SynchronizationMode mode = new SynchronizationMode();
					mode.setAcessSynchronization(syncMode.getAcessSynchronization());
					mode.setHowSynchronizationMade(syncMode.getHowSynchronizationMade());
					mode.setWhenSynchronizationMade(syncMode.getWhenSynchronizationMade());
					
					originalAttribute.addOriginalSynchronizationMode(mode);
					mode.setOriginalAttribute(originalAttribute);
					
					attr.setClonedSynchronizationMode(mode);
					mode.setAttributeCloned(attr);
					originalInformation.addAttribute(originalAttribute);
					originalAttribute.setInformation(originalInformation);
					}
			}
		}
	}	
}
