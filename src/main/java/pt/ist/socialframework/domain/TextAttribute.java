package pt.ist.socialframework.domain;

public class TextAttribute extends TextAttribute_Base {
    
    public  TextAttribute() {
        super();
    }
    
    public TextAttribute(AttributeRole attributeRole) {
    	super();
    	this.setAttributeRole(attributeRole);
		attributeRole.addAttribute(this);
    }
    
    public String getValue() {
    	return getTextValue();
    }
    
    public void createClone(Attribute clonedAttribute){
    	((TextAttribute)clonedAttribute).setTextValue(getTextValue());
    	super.createClone(clonedAttribute);
    }
}
