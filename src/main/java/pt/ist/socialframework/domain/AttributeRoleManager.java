package pt.ist.socialframework.domain;

import java.util.Set;

public class AttributeRoleManager extends AttributeRoleManager_Base {
    
    public  AttributeRoleManager() {
        super();
    }
    
    public AttributeRole createAttributeRole(String role) {
    	Set<AttributeRole> attributeRoleSet =  getAttributeRoleSet();
    	
    	for(AttributeRole attributeRole : attributeRoleSet) {
    		if(attributeRole.equals(role))
    			return attributeRole;
    	}
    	
    	AttributeRole newAttributeRole = new AttributeRole();
    	newAttributeRole.setRole(role);
    	this.addAttributeRole(newAttributeRole);
    	newAttributeRole.setAttributeRoleManager(this);
    	return newAttributeRole;
    }
}
