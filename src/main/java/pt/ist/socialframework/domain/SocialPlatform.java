package pt.ist.socialframework.domain;

import org.apache.ojb.jdo.jdoql.ThisExpression;

public class SocialPlatform extends SocialPlatform_Base {

	public SocialPlatform() {
		InformationRoleManager informationRoleManager =  new InformationRoleManager();
		informationRoleManager.setSocialPlatform(this);
		this.setInformationRoleManager(informationRoleManager);
		
		AttributeRoleManager attributeRoleManager = new AttributeRoleManager();
		attributeRoleManager.setSocialPlatform(this);
		this.setAttributeRoleManager(attributeRoleManager);
	}
	
}
