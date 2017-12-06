
package wsdl.deal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import wsdl.bean.ArrayOfDeal;


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
 *         &lt;element name="GetAllDealsResult" type="{http://beans.com}ArrayOfDeal" minOccurs="0"/&gt;
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
    "getAllDealsResult"
})
@XmlRootElement(name = "GetAllDealsResponse")
public class GetAllDealsResponse {

    @XmlElementRef(name = "GetAllDealsResult", namespace = "http://dealservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDeal> getAllDealsResult;

    /**
     * Gets the value of the getAllDealsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDeal }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDeal> getGetAllDealsResult() {
        return getAllDealsResult;
    }

    /**
     * Sets the value of the getAllDealsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDeal }{@code >}
     *     
     */
    public void setGetAllDealsResult(JAXBElement<ArrayOfDeal> value) {
        this.getAllDealsResult = value;
    }

}
