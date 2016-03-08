package UF1AAD.ApuntsDomSax;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	 boolean bpersonId = false;
     boolean bpersonName = false;
 	 private List<Person> persons = null;
     
     
     public SAXHandler(List<Person> pl){
    	 this.persons = pl;
     }
     
     @Override
     public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException {
    	 	if (qName.equalsIgnoreCase("id")) {
    	 			bpersonId = true;
    	 			Person person = new Person();
    	 			persons.add(person);
    	 	}else if (qName.equalsIgnoreCase("name")) {
    	 			bpersonName = true;
    	 	}
     }
       
     @Override
     public void characters(char ch[], int start, int length) throws SAXException {
    	 if (bpersonId) {
             String personID = new String(ch, start, length);
             bpersonId = false;
             Person person = persons.get(persons.size() - 1);
             person.setId(personID);
         } else if (bpersonName) {
             String name = new String(ch, start, length);
             bpersonName = false;
             Person person = persons.get(persons.size() - 1);
             person.setName(name);
         }
     }
 }
	
