package pt.ist.socialframework.domain;

public class NumericAttribute extends NumericAttribute_Base {
    
    public  NumericAttribute() {
        super();
    }
    
    public NumericAttribute(AttributeRole attributeRole){
    	super();
    	this.setAttributeRole(attributeRole);
		attributeRole.addAttribute(this);
    }
    
    public void createClone(Attribute clonedAttribute) {
    	((NumericAttribute)clonedAttribute).setNumericValue(getNumericValue());
    	super.createClone(clonedAttribute);
    }
}
