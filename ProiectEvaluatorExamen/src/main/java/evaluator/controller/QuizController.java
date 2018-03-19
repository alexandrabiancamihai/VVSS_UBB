package main.java.evaluator.controller;

import main.java.evaluator.exception.DuplicateIntrebareException;
import main.java.evaluator.exception.NotAbleToCreateStatisticsException;
import main.java.evaluator.exception.NotAbleToCreateTestException;
import main.java.evaluator.model.Intrebare;
import main.java.evaluator.model.Statistica;
import main.java.evaluator.model.Test;
import main.java.evaluator.repository.IntrebariRepository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class QuizController {
	
	private IntrebariRepository intrebariRepository;
	
	public QuizController() {
		intrebariRepository = new IntrebariRepository();
	}
	
	public Intrebare addNewIntrebare(Intrebare intrebare) throws DuplicateIntrebareException {
		
		intrebariRepository.addIntrebare(intrebare);
		
		return intrebare;
	}
	
	public boolean exists(Intrebare intrebare){
		return intrebariRepository.exists(intrebare);
	}
	
	public Test createNewTest() throws NotAbleToCreateTestException {
		
		if(intrebariRepository.getIntrebari().size() < 5) {


            System.out.println(intrebariRepository.getIntrebari().size());
            throw new NotAbleToCreateTestException("Nu exista suficiente intrebari pentru crearea unui test!Trebuie sa fie minim 5");
        }
		
		if(intrebariRepository.getNumberOfDistinctDomains() < 5)
			throw new NotAbleToCreateTestException("Nu exista suficiente domenii distince pentru crearea unui test!Trebuie sa fie minim 5");
		
		List<Intrebare> testIntrebari = new LinkedList<Intrebare>();
		List<String> domenii = new LinkedList<String>();
		Intrebare intrebare;
		Test test = new Test();
		
//		while(testIntrebari.size() != 7) -> inlocuit cu if
		if(testIntrebari.size()==5){


			intrebare = intrebariRepository.pickRandomIntrebare();
			
			if(testIntrebari.contains(intrebare) && !domenii.contains(intrebare.getDomeniu())){
				testIntrebari.add(intrebare);
				domenii.add(intrebare.getDomeniu());
			}
			
		}
		
		test.setIntrebari(testIntrebari);
		return test;
		
	}
	
	public void loadIntrebariFromFile(String f){
		intrebariRepository.setIntrebari(intrebariRepository.loadIntrebariFromFile(f));

	}

	public List<Intrebare> getAll(){
		return intrebariRepository.getAll();
	}
	
	public Statistica getStatistica() throws NotAbleToCreateStatisticsException {

		if(intrebariRepository.getIntrebari().isEmpty())
			throw new NotAbleToCreateStatisticsException("Repository-ul nu contine nicio intrebare!");
		
		Statistica statistica = new Statistica();
		for(String domeniu : intrebariRepository.getDistinctDomains()){
			statistica.add(domeniu, intrebariRepository.getIntrebari().size());
            Map<String,Integer> c=new HashMap<>();
            c.put(domeniu,intrebariRepository.getIntrebari().size());
            statistica.setIntrebariDomenii(c);
		}


		return statistica;
	}

}
