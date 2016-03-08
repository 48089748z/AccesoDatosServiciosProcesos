package UF1AAD.ApuntsDomSax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "persons")
public class PersonList {
    @XmlElement(name="person")
    private List<Person> personList = new ArrayList<Person>();
 
    public List<Person> getPersons() {
        return personList;
    }
 
    public void setPersons(List<Person> persons) {
        this.personList = persons;
    }
    
    public void printList(){
    	System.out.println("El nombre de persones �s "+personList.size());
    }
}