//
// This file was UF1AAD.PokemonsJAXB by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.27 at 05:02:04 PM CET 
//


package UF1AAD.PokemonsSAX;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Nombre"/>
 *         &lt;element ref="{}PV"/>
 *         &lt;element ref="{}Ataque1"/>
 *         &lt;element ref="{}Ataque2"/>
 *         &lt;element ref="{}Etapa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nombre",
    "pv",
    "ataque1",
    "ataque2",
    "etapa"
})
@XmlRootElement(name = "Pokemon")
public class Pokemon {

    @XmlElement(name = "Nombre", required = true)
    protected Nombre nombre;
    @XmlElement(name = "PV", required = true)
    protected BigInteger pv;
    @XmlElement(name = "Ataque1", required = true)
    protected String ataque1;
    @XmlElement(name = "Ataque2", required = true)
    protected String ataque2;
    @XmlElement(name = "Etapa", required = true)
    protected String etapa;

    /**
     * Gets the value of the nombre property.
     *
     * @return
     *     possible object is
     *     {@link Nombre }
     *
     */
    public Nombre getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     *
     * @param value
     *     allowed object is
     *     {@link Nombre }
     *
     */
    public void setNombre(Nombre value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the pv property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPV() {
        return pv;
    }

    /**
     * Sets the value of the pv property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPV(BigInteger value) {
        this.pv = value;
    }

    /**
     * Gets the value of the ataque1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtaque1() {
        return ataque1;
    }

    /**
     * Sets the value of the ataque1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtaque1(String value) {
        this.ataque1 = value;
    }

    /**
     * Gets the value of the ataque2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtaque2() {
        return ataque2;
    }

    /**
     * Sets the value of the ataque2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtaque2(String value) {
        this.ataque2 = value;
    }

    /**
     * Gets the value of the etapa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtapa() {
        return etapa;
    }

    /**
     * Sets the value of the etapa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtapa(String value) {
        this.etapa = value;
    }

}
