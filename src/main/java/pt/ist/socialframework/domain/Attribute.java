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
}
