package main.java.evaluator.repository;

import main.java.evaluator.exception.DuplicateIntrebareException;
import main.java.evaluator.model.Intrebare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class IntrebariRepository {
	
	private List<Intrebare> intrebari;
	
	public IntrebariRepository()
	{
		this.intrebari=new ArrayList<>();
	//	setIntrebari(new LinkedList<Intrebare>());
	}
	
	public void addIntrebare(Intrebare i) throws DuplicateIntrebareException {
		if(exists(i))
			throw new DuplicateIntrebareException("Intrebarea deja exista!");
		intrebari.add(i);
	}
	
	public boolean exists(Intrebare i){
		Boolean exists=Boolean.FALSE;
		for(Intrebare intrebare : intrebari)
			if(intrebare.equals(i))
				exists=Boolean.TRUE;
		return exists;
	}
	
	public Intrebare pickRandomIntrebare(){
		Random random = new Random();
		return intrebari.get(random.nextInt(intrebari.size()));
	}
	
	public int getNumberOfDistinctDomains(){
		return getDistinctDomains().size();
		
	}
	
	public List<String> getDistinctDomains(){
	//	Set<String> domains = new TreeSet<String>();
		List<String> domains=new ArrayList<>();
		for(Intrebare intrebre : intrebari)
			domains.add(intrebre.getDomeniu());
		return domains;
	}
	
	public List<Intrebare> getIntrebariByDomain(String domain){
		List<Intrebare> intrebariByDomain = new LinkedList<Intrebare>();
		for(Intrebare intrebare : intrebari){
			if(intrebare.getDomeniu().equals(domain)){
				intrebariByDomain.add(intrebare);
			}
		}
		
		return intrebariByDomain;
	}

	public List<Intrebare> getAll(){
		return intrebari;
	}
	
	public int getNumberOfIntrebariByDomain(String domain){
		return getIntrebariByDomain(domain).size();
	}
	
	public List<Intrebare> loadIntrebariFromFile(String f){
		
		List<Intrebare> intrebari = new ArrayList<>();
		BufferedReader br = null; 
		String line =null;
		List<String> intrebareAux;
		Intrebare intrebare;
		
		try{
			br = new BufferedReader(new FileReader(f));
		//	line = br.readLine();
			while ((line = br.readLine()) != null) {
			    String[] data=line.split(",");
//				intrebareAux = new ArrayList<>();
//				while(!line.equals("##")) {
//                    intrebareAux.add(line);
//                    line = br.readLine();
//                    //System.out.println(intrebareAux.get(0));
//                }
                intrebare = new Intrebare();
                intrebare.setEnunt(data[0]);
                intrebare.setVarianta1(data[1]);
                intrebare.setVarianta2(data[2]);
                intrebare.setVarianta3(data[3]);
                intrebare.setVariantaCorecta(data[4]);
                intrebare.setDomeniu(data[5]);
                intrebari.add(intrebare);
                intrebare.toString();


            }
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		finally{
			try {
				if(br!=null){
					br.close();
				}

			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		return intrebari;
	}
	
	public List<Intrebare> getIntrebari() {
		return intrebari;
	}

	public void setIntrebari(List<Intrebare> intrebari) {
		this.intrebari = intrebari;
	}
	
}
