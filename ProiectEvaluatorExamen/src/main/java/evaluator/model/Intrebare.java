package main.java.evaluator.model;

import main.java.evaluator.exception.InputValidationFailedException;
import main.java.evaluator.util.InputValidation;

import java.util.Objects;

public class Intrebare {
	
	private String enunt;
	private String varianta1;
	private String varianta2;
	private String varianta3;
	private String variantaCorecta;
	private String domeniu;
	
	public Intrebare() {
	}
	
	public Intrebare(String enunt, String varianta1, String varianta2,String varianta3,
			String variantaCorecta, String domeniu) throws InputValidationFailedException {
		
		InputValidation.validateEnunt(enunt);
		InputValidation.validateVarianta1(varianta1);
		InputValidation.validateVarianta2(varianta2);
		InputValidation.validateVarianta3(varianta3);
		InputValidation.validateVariantaCorecta(variantaCorecta);
		InputValidation.validateDomeniu(domeniu);
		
		this.enunt = enunt;
		this.varianta1 = varianta1;
		this.varianta2 = varianta2;
		this.varianta3=varianta3;
		this.variantaCorecta = variantaCorecta;
		this.domeniu = domeniu;
	}


	public String getEnunt() {
		return enunt;
	}
	public void setEnunt(String enunt) {
		this.enunt = enunt;
	}
	public String getVarianta1() {
		return varianta1;
	}
	public void setVarianta1(String varianta1) {
		this.varianta1 = varianta1;
	}
	public String getVarianta2() {
		return varianta2;
	}
	public void setVarianta2(String varianta2) {
		this.varianta2 = varianta2;
	}

	public String getVarianta3() {
		return varianta3;
	}

	public void setVarianta3(String varianta3) {
		this.varianta3 = varianta3;
	}

	public String getVariantaCorecta() {
		return variantaCorecta;
	}
	public void setVariantaCorecta(String variantaCorecta) {
		this.variantaCorecta = variantaCorecta;
	}
	public String getDomeniu() {
		return domeniu;
	}
	public void setDomeniu(String domeniu) {
		this.domeniu = domeniu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Intrebare intrebare = (Intrebare) o;
		return Objects.equals(enunt, intrebare.enunt) &&
				Objects.equals(varianta1, intrebare.varianta1) &&
				Objects.equals(varianta2, intrebare.varianta2) &&
				Objects.equals(varianta3, intrebare.varianta3) &&
				Objects.equals(variantaCorecta, intrebare.variantaCorecta) &&
				Objects.equals(domeniu, intrebare.domeniu);
	}


	@Override
	public String toString() {
		return "Intrebare{" +
				"enunt='" + enunt + '\'' +
				", varianta1='" + varianta1 + '\'' +
				", varianta2='" + varianta2 + '\'' +
				", varianta3='" + varianta3 + '\'' +
				", variantaCorecta='" + variantaCorecta + '\'' +
				", domeniu='" + domeniu + '\'' +
				'}';
	}
}
