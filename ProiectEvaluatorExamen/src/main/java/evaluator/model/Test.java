package main.java.evaluator.model;

import java.util.LinkedList;
import java.util.List;

public class Test  {

	private List<Intrebare> intrebari;
	
	public Test() {
		intrebari = new LinkedList<Intrebare>(); 
	}
	
	public List<Intrebare> getIntrebari() {
		return intrebari;
	}
	
	public void setIntrebari(List<Intrebare> intrebari) {
		this.intrebari = intrebari;
	}

	public void printTest(){
		for(Intrebare i:intrebari){
			System.out.println(i.toString());
		}
	}
}
