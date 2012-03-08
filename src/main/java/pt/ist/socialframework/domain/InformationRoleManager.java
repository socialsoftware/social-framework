package pt.ist.socialframework.domain;

import java.util.Set;

public class InformationRoleManager extends InformationRoleManager_Base {
    
    public  InformationRoleManager() {
        super();
    }
    
    public InformationRole createInformationRole(String role) {
    	Set<InformationRole> informationRoleSet = getInformationRoleSet();
    	
    	for(InformationRole informationRole : informationRoleSet) {
    		if(informationRole.equals(role))
    			return informationRole;
    	}
    	
    	InformationRole newInformationRole = new InformationRole();
    	newInformationRole.setRole(role);
    	this.addInformationRole(newInformationRole);
    	newInformationRole.setInformationRoleManager(this);
    	return newInformationRole;
    }
    
}
