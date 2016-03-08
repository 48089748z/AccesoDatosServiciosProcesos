package UF1AAD.ApuntsDomSax;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAX {
	
	private List<Person> persons = new ArrayList<Person>();
	private PersonList pl = new PersonList();
	
	public void testParsingWithSAX(File filename) throws Exception {
	    SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser saxParser = factory.newSAXParser();
	    SAXHandler handler = new SAXHandler(persons);
	    
	    saxParser.parse(filename, handler);
	}
	
	public PersonList getList(){
		 pl.setPersons(this.persons);
		 return pl;
		}

}
