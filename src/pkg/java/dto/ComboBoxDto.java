package pkg.java.dto;

public class ComboBoxDto {
	
	private String value;
	private String name;
	
	public ComboBoxDto(String v, String n) {
        value = v;
        name = n;
    }
	
	
	public String getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(String v) {
		value = v;
	}
	
	public void setName(String v) {
		name = v;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
