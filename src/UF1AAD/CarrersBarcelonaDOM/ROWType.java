//
// This file was UF1AAD.CarrersBarcelonaJAXB by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.27 at 04:22:15 PM CET 
//


package UF1AAD.CarrersBarcelonaDOM;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ROWType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ROWType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CODI_CARRER">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="000102"/>
 *               &lt;enumeration value="000180"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CODI_CARRER_INE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SIGLA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NOM_OFICIAL">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Carrer dels Llebrencs"/>
 *               &lt;enumeration value="Carrer A Zona Franca"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NOM_CURT">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Llebrencs"/>
 *               &lt;enumeration value="A"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NRE_MIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NRE_MAX" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROWType", propOrder = {
    "codicarrer",
    "codicarrerine",
    "sigla",
    "nomoficial",
    "nomcurt",
    "nremin",
    "nremax"
})
public class ROWType {

    @XmlElement(name = "CODI_CARRER", required = true)
    protected String codicarrer;
    @XmlElement(name = "CODI_CARRER_INE", required = true)
    protected String codicarrerine;
    @XmlElement(name = "SIGLA", required = true)
    protected String sigla;
    @XmlElement(name = "NOM_OFICIAL", required = true)
    protected String nomoficial;
    @XmlElement(name = "NOM_CURT", required = true)
    protected String nomcurt;
    @XmlElement(name = "NRE_MIN", required = true)
    protected String nremin;
    @XmlElement(name = "NRE_MAX", required = true)
    protected String nremax;

    /**
     * Gets the value of the codicarrer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODICARRER() {
        return codicarrer;
    }

    /**
     * Sets the value of the codicarrer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODICARRER(String value) {
        this.codicarrer = value;
    }

    /**
     * Gets the value of the codicarrerine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODICARRERINE() {
        return codicarrerine;
    }

    /**
     * Sets the value of the codicarrerine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODICARRERINE(String value) {
        this.codicarrerine = value;
    }

    /**
     * Gets the value of the sigla property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIGLA() {
        return sigla;
    }

    /**
     * Sets the value of the sigla property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIGLA(String value) {
        this.sigla = value;
    }

    /**
     * Gets the value of the nomoficial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMOFICIAL() {
        return nomoficial;
    }

    /**
     * Sets the value of the nomoficial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMOFICIAL(String value) {
        this.nomoficial = value;
    }

    /**
     * Gets the value of the nomcurt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMCURT() {
        return nomcurt;
    }

    /**
     * Sets the value of the nomcurt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMCURT(String value) {
        this.nomcurt = value;
    }

    /**
     * Gets the value of the nremin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNREMIN() {
        return nremin;
    }

    /**
     * Sets the value of the nremin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNREMIN(String value) {
        this.nremin = value;
    }

    /**
     * Gets the value of the nremax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNREMAX() {
        return nremax;
    }

    /**
     * Sets the value of the nremax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNREMAX(String value) {
        this.nremax = value;
    }

}
