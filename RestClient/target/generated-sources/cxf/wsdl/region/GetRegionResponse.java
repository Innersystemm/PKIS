
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
 *         &lt;element name="GetRegionResult" type="{http://beans.com}Region" minOccurs="0"/&gt;
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
    "getRegionResult"
})
@XmlRootElement(name = "GetRegionResponse")
public class GetRegionResponse {

    @XmlElementRef(name = "GetRegionResult", namespace = "http://regionservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Region> getRegionResult;

    /**
     * Gets the value of the getRegionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Region }{@code >}
     *     
     */
    public JAXBElement<Region> getGetRegionResult() {
        return getRegionResult;
    }

    /**
     * Sets the value of the getRegionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Region }{@code >}
     *     
     */
    public void setGetRegionResult(JAXBElement<Region> value) {
        this.getRegionResult = value;
    }

}
