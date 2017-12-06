
package wsdl.flat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import wsdl.bean.Flat;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flats" type="{http://beans.com}Flat" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "flats"
})
@XmlRootElement(name = "UpdateFlat")
public class UpdateFlat {

    @XmlElementRef(name = "flats", namespace = "http://flatservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Flat> flats;

    /**
     * Gets the value of the flats property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Flat }{@code >}
     *     
     */
    public JAXBElement<Flat> getFlats() {
        return flats;
    }

    /**
     * Sets the value of the flats property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Flat }{@code >}
     *     
     */
    public void setFlats(JAXBElement<Flat> value) {
        this.flats = value;
    }

}
