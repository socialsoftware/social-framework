package pt.ist.socialframework.domain;


public class Information extends Information_Base{
	
	public void createAttribute(AttributeRole attributeRole, String type, String value) {
		Attribute attribute = new Attribute(attributeRole);
//		attribute.setType(attributeRequestDto.getType());
		attribute.setValue(value);
		attribute.setInformation(this);
		this.addAttribute(attribute);
	}

	public void createAttribute(Attribute stringAttribute, AttributeRole createAttributeRole) {
		this.addAttribute(stringAttribute);
		stringAttribute.setInformation(this);
		stringAttribute.setAttributeRole(createAttributeRole);
		createAttributeRole.addAttribute(stringAttribute);
	}
	
	public void createInformationRelation(Information informationDestination) {
		InformationRelation informationRelation = new InformationRelation();
		this.setInformationRelationSource(informationRelation);
		informationRelation.setInformationSource(this);
		informationDestination.addInformationRelationDestination(informationRelation);
		informationRelation.addInformationDestination(informationDestination);
	}
	
	
	
	public Information createClone(SynchronizationMode mode, Information clonedInformation) {
		
		this.addOriginalSynchronizationMode(mode);
		mode.setOriginalInformation(this);
		
		mode.addInformationCloned(clonedInformation);
		clonedInformation.setClonedSynchronizationMode(mode);
//		if(this.hasAnyAttribute()) {
//			for(Attribute attr : this.getAttribute()) {
//				Attribute clonedAttribute =  new Attribute();
//				clonedAttribute.setAttributeRole(attr.getAttributeRole());
//				attr.getAttributeRole().addAttribute(clonedAttribute);
//				clonedAttribute.setInformation(clonedInformation);
//				clonedInformation.addAttribute(clonedAttribute);
//				clonedAttribute.setValue(attr.getValue());
//			}
//		}
		clonedInformation.setRole(this.getRole());
		this.getRole().addInformation(clonedInformation);
		return clonedInformation;
	}	
}
