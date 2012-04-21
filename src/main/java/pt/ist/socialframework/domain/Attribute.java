package pt.ist.socialframework.domain;

public class Attribute extends Attribute_Base {
    
	public Attribute() {
		super();
	}
	
    public Attribute(AttributeRole attributeRole) {
        super();
        this.setAttributeRole(attributeRole);
		attributeRole.addAttribute(this);
    }

	public void createClone(Attribute clonedAttribute) {
		clonedAttribute.setAttributeRole(getAttributeRole());
		getAttributeRole().addAttribute(clonedAttribute);
		if(getValue()!= null) {
			clonedAttribute.setValue(getValue());
		}
	}

	
	public void attributeChange() {
		
	}
	
	public void sync() {
		// TODO Auto-generated method stub
		
	}
}
