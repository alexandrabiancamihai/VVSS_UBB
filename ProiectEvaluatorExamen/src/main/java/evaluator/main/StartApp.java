package main.java.evaluator.main;

import main.java.evaluator.controller.QuizController;
import main.java.evaluator.exception.DuplicateIntrebareException;
import main.java.evaluator.exception.NotAbleToCreateStatisticsException;
import main.java.evaluator.exception.NotAbleToCreateTestException;
import main.java.evaluator.model.Intrebare;
import main.java.evaluator.model.Statistica;
import main.java.evaluator.model.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


//functionalitati
//i.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//ii.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//iii.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

	private static final String file = "F:\\Semestrul 2\\vvss\\05-ProiectEvaluatorExamen\\ProiectEvaluatorExamen\\src\\main\\java\\evaluator\\intrebari.txt";
	
	public static void main(String[] args) throws IOException, DuplicateIntrebareException, NotAbleToCreateTestException, NotAbleToCreateStatisticsException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		QuizController appController = new QuizController();
		
		boolean activ = true;
		String optiune = null;
		
		while(activ){
			
			System.out.println("");
			System.out.println("1.Adauga intrebare");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Exit");
			System.out.println("");

			Scanner in = new Scanner(System.in);
			
			optiune = console.readLine();
			Intrebare intrebare=new Intrebare();
			switch(optiune){
			case "1" :
				System.out.println("adaugati enuntul: ");
				String enunt=in.nextLine();
				intrebare.setEnunt(enunt);
				System.out.println("adaugati varianta1: ");
				String o1=in.nextLine();
				System.out.println("adaugati varianta2: ");
				String o2=in.nextLine();
				System.out.println("adaugati varianta3: ");
				String o3=in.nextLine();
				System.out.println("adaugati varianta corecta: ");
				String o4=in.nextLine();
				System.out.println("adaugati domeniul: ");
				String o5=in.nextLine();
				intrebare.setDomeniu(o1);
				intrebare.setVarianta1(o2);
				intrebare.setVarianta2(o3);
				intrebare.setVarianta3(o4);
				intrebare.setVariantaCorecta(o5);
				appController.addNewIntrebare(intrebare);
				System.out.println(intrebare.toString());
				break;
			case "2" :
				Test t=appController.createNewTest();
				System.out.println(t.toString());
				t.printTest();
				break;
			case "3" :
				appController.loadIntrebariFromFile(file);
				Statistica statistica;
				statistica = appController.getStatistica();
				System.out.println(statistica.toString());
				break;
			case "4" :
				activ = false;
				break;
			default:
				break;
			}
		}
		
	}

}
