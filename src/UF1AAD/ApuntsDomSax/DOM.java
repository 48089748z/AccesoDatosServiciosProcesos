package UF1AAD.ApuntsDomSax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM {
	
	
	private List<Person> personsAsList = new ArrayList<Person>();
	private PersonList pl = new PersonList();
	
	
	public void testParsingWithDom(File filename) throws Exception {
	    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc = builder.parse(filename);
	    NodeList persons = doc.getChildNodes();
	//    System.out.println(persons.getLength());
	//    System.out.println(persons.item(0).getNodeName());
	    for(int i = 0; i < persons.getLength(); i++){
	    		    NodeList person = persons.item(i).getChildNodes();
	    		    for(int j=0; j < person.getLength(); j++){
	    		    	if(person.item(j).getNodeType()==Node.ELEMENT_NODE){
	    		    	//	System.out.println(person.item(j).getNodeName());
	    		    		NodeList carac = person.item(j).getChildNodes();
	    		    		Person titere = new Person();
	    		    		for(int k=0; k<carac.getLength(); k++){
	    		    			if(carac.item(k).getNodeType()==Node.ELEMENT_NODE){
	    	    		    		if(carac.item(k).getNodeName().equals("name")){
	    	    		    		//	System.out.println("El nom �s: "+carac.item(k).getChildNodes().item(0).getNodeValue());
	    	    		    			titere.setName(carac.item(k).getChildNodes().item(0).getNodeValue());
	    	    		    		}
	    	    		    		if(carac.item(k).getNodeName().equals("id")){
	    	    		    		//	System.out.println("El id �s: "+carac.item(k).getChildNodes().item(0).getNodeValue());
	    	    		    			titere.setId(carac.item(k).getChildNodes().item(0).getNodeValue());
	    	    		    		}
	    		    			}    		    			
	    		    		}
	    		    		personsAsList.add(titere);
	    		    	}
	    		    }
	    }
	}
	
	
	
	public PersonList getList(){
	 pl.setPersons(this.personsAsList);
	 return pl;
	}

}
