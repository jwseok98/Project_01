package sample.cwe20;

import org.apache.struts.validator.ValidatorForm;

class GangsterForm extends ValidatorForm {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
