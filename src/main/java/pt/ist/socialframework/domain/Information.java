package pt.ist.socialframework.domain;


public class Information extends Information_Base{
	
	public void createAttribute(String role, String value) {
		AttributeRole attributeRole = this.getInteraction().getSocialPlatform().getAttributeRoleManager().createAttributeRole(role);
		
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
	}
	
	public void createAttribute(String role, float value) {
		AttributeRole attributeRole = this.getInteraction().getSocialPlatform().getAttributeRoleManager().createAttributeRole(role);

		NumericAttribute numericAttribute = new NumericAttribute(attributeRole);
		numericAttribute.setNumericValue(value);
		numericAttribute.setInformation(this);
		this.addAttribute(numericAttribute);
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
	
//	public void sync(Lis){
//		
//	}
}
