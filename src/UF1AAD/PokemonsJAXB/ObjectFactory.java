//
// This file was UF1AAD.PokemonsJAXB by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.27 at 05:02:04 PM CET 
//


package UF1AAD.PokemonsJAXB;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * UF1AAD.PokemonsJAXB in the UF1AAD.PokemonsJAXB package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Etapa_QNAME = new QName("", "Etapa");
    private final static QName _PV_QNAME = new QName("", "PV");
    private final static QName _Ataque2_QNAME = new QName("", "Ataque2");
    private final static QName _Ataque1_QNAME = new QName("", "Ataque1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: UF1AAD.PokemonsJAXB
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Nombre }
     * 
     */
    public Nombre createNombre() {
        return new Nombre();
    }

    /**
     * Create an instance of {@link Pokedex }
     * 
     */
    public Pokedex createPokedex() {
        return new Pokedex();
    }

    /**
     * Create an instance of {@link Pokemon }
     * 
     */
    public Pokemon createPokemon() {
        return new Pokemon();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Etapa")
    public JAXBElement<String> createEtapa(String value) {
        return new JAXBElement<String>(_Etapa_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PV")
    public JAXBElement<BigInteger> createPV(BigInteger value) {
        return new JAXBElement<BigInteger>(_PV_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ataque2")
    public JAXBElement<String> createAtaque2(String value) {
        return new JAXBElement<String>(_Ataque2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Ataque1")
    public JAXBElement<String> createAtaque1(String value) {
        return new JAXBElement<String>(_Ataque1_QNAME, String.class, null, value);
    }

}
