
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
 *         &lt;element name="newflat" type="{http://beans.com}Flat" minOccurs="0"/&gt;
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
    "newflat"
})
@XmlRootElement(name = "AddFlat")
public class AddFlat {

    @XmlElementRef(name = "newflat", namespace = "http://flatservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Flat> newflat;

    /**
     * Gets the value of the newflat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Flat }{@code >}
     *     
     */
    public JAXBElement<Flat> getNewflat() {
        return newflat;
    }

    /**
     * Sets the value of the newflat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Flat }{@code >}
     *     
     */
    public void setNewflat(JAXBElement<Flat> value) {
        this.newflat = value;
    }

}
