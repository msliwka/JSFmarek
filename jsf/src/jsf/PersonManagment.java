package jsf;



import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

@ManagedBean(name="PersonManagment")
@ViewScoped
public class PersonManagment{
	

	private List<Person> persons;
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public static void add(Person p)
	{
		
		
		String data= p.getImie()+";"+p.getNazwisko()+";"+p.getPesel()+";"+ "null" +";"+p.getAdres()+";"+p.getTel()+";"+p.getWaga()+";"+p.getWzrost()+";;";
		 

			 
			 FileWriter w;
			try {
				w = new FileWriter("c:/user.txt",true);
				 w.write(data);
				 w.close();
			} catch (IOException e) {
		
				e.printStackTrace();
			}

		 

		
	
		
		
	}
	

	@PostConstruct
	public void getall()
	
	{
		this.persons = new ArrayList<Person>();
		File file = new File("c:/user.txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
		
			byte[] data = new byte[(int) file.length()];
		
			fis.read(data);
			fis.close();
			
			String dataString = new String(data, "UTF-8");
			
			for(String dataStringPerson : dataString.split(";;"))
			{
				
				String[] dataPerson = dataStringPerson.split(";");
				
					Person p = new Person();
					p.setImie(dataPerson[0]);
					p.setNazwisko(dataPerson[1]);
					p.setPesel(dataPerson[2]);
					p.setDataUrodzenia(dataPerson[3]);
					p.setAdres(dataPerson[4]);
					p.setTel(Integer.parseInt(dataPerson[5]));
					p.setWaga(Double.parseDouble(dataPerson[6]));
					p.setWzrost(Double.parseDouble(dataPerson[7]));
					this.persons.add(p);
					
					
					
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
	

}
