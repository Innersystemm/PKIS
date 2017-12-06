
package wsdl.flat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import wsdl.bean.ArrayOfFlat;


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
 *         &lt;element name="GetAllFlatsResult" type="{http://beans.com}ArrayOfFlat" minOccurs="0"/&gt;
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
    "getAllFlatsResult"
})
@XmlRootElement(name = "GetAllFlatsResponse")
public class GetAllFlatsResponse {

    @XmlElementRef(name = "GetAllFlatsResult", namespace = "http://flatservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFlat> getAllFlatsResult;

    /**
     * Gets the value of the getAllFlatsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFlat }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFlat> getGetAllFlatsResult() {
        return getAllFlatsResult;
    }

    /**
     * Sets the value of the getAllFlatsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFlat }{@code >}
     *     
     */
    public void setGetAllFlatsResult(JAXBElement<ArrayOfFlat> value) {
        this.getAllFlatsResult = value;
    }

}
