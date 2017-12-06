
package wsdl.region;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import wsdl.bean.Region;


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
 *         &lt;element name="regions" type="{http://beans.com}Region" minOccurs="0"/&gt;
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
    "regions"
})
@XmlRootElement(name = "UpdateRegion")
public class UpdateRegion {

    @XmlElementRef(name = "regions", namespace = "http://regionservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Region> regions;

    /**
     * Gets the value of the regions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Region }{@code >}
     *     
     */
    public JAXBElement<Region> getRegions() {
        return regions;
    }

    /**
     * Sets the value of the regions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Region }{@code >}
     *     
     */
    public void setRegions(JAXBElement<Region> value) {
        this.regions = value;
    }

}
