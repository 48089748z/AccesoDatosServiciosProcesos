package UF1AAD.ApuntsDomSax;

import java.io.File;

public class Llansadora {

	public static void main(String[] args) throws Exception {
		// TODO Auto-UF1AAD.CarrersBarcelonaJAXB method stub
		
		String nomfitxer = "persons.xml";
		
		File fitxer = new File(nomfitxer);
		
		DOM domi = new DOM();
		domi.testParsingWithDom(fitxer);
		domi.getList().printList();
		System.out.println(domi.getList().getPersons().get(2).getName());
		
		SAX saxi = new SAX();
		saxi.testParsingWithSAX(fitxer);
		saxi.getList().printList();
		System.out.println(saxi.getList().getPersons().get(3).getName());
		
		JAXB jaxbi = new JAXB();
		jaxbi.testUnMarshallUsingJAXB(nomfitxer).printList();
		System.out.println(jaxbi.getList().getPersons().get(8).getName());

	}

}
