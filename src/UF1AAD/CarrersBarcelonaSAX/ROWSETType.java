//
// This file was UF1AAD.CarrersBarcelonaJAXB by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.27 at 04:22:15 PM CET 
//


package UF1AAD.CarrersBarcelonaSAX;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;



/**
 * <p>Java class for ROWSETType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ROWSETType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ROW" type="{}ROWType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROWSETType", propOrder = {
    "row"
})
@XmlRootElement(name="ROWSET")

public class ROWSETType {

    @XmlElement(name = "ROW")
    protected List<ROWType> row;

    /**
     * Gets the value of the row property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the row property.
     * 
     * <p>
     * For UF1AAD.ApuntsDomSax, to add a new item, do as follows:
     * <pre>
     *    getROW().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ROWType }
     * 
     * 
     */
    public List<UF1AAD.CarrersBarcelonaSAX.ROWType> getROW() {
        if (row == null) {
            row = new ArrayList<ROWType>();
        }
        return this.row;
    }

}
