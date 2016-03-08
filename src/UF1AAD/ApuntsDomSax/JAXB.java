package UF1AAD.ApuntsDomSax;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JAXB {

	private PersonList pl = new PersonList();
	
	
	public PersonList testUnMarshallUsingJAXB(String filename) throws Exception {
	
	    JAXBContext jc = JAXBContext.newInstance(PersonList.class);
	    Unmarshaller unmarshaller = jc.createUnmarshaller();
	    PersonList obj = (PersonList)unmarshaller.unmarshal(new File(filename));
	    pl = obj;
	    return obj;
	    
	}
	
	public PersonList getList(){
		 return pl;
		}
}
