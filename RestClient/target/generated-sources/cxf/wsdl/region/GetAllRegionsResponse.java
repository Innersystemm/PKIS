
package wsdl.region;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import wsdl.bean.ArrayOfRegion;


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
 *         &lt;element name="GetAllRegionsResult" type="{http://beans.com}ArrayOfRegion" minOccurs="0"/&gt;
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
    "getAllRegionsResult"
})
@XmlRootElement(name = "GetAllRegionsResponse")
public class GetAllRegionsResponse {

    @XmlElementRef(name = "GetAllRegionsResult", namespace = "http://regionservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRegion> getAllRegionsResult;

    /**
     * Gets the value of the getAllRegionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRegion }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRegion> getGetAllRegionsResult() {
        return getAllRegionsResult;
    }

    /**
     * Sets the value of the getAllRegionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRegion }{@code >}
     *     
     */
    public void setGetAllRegionsResult(JAXBElement<ArrayOfRegion> value) {
        this.getAllRegionsResult = value;
    }

}
