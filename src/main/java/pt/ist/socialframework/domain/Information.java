package pt.ist.socialframework.domain;

public class Information extends Information_Base {
	
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
  
	
//	public void init(InformationVersion informationVersion) {
//		addVersion(informationVersion);
//		setLastVersion(informationVersion);
//	}
//	
//	public void addNewInformationVersion(InformationVersion informationVersion) {
//		if(hasLastVersion()) {
//			addVersion(informationVersion);
//			getLastVersion().setNextVersion(informationVersion);
//			setLastVersion(informationVersion);			
//		} else {
//			init(informationVersion);
//		}
//	}
//	
//	public Set<Information> getRelatedInformation(InformationRelation informationRelation) {
//		Set<Information> information = new HashSet<Information>();
//		InformationVersion informationVersion = getLastVersion();
//		return information;
//	}
	
}
