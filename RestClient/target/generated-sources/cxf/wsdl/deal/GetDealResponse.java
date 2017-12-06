
package wsdl.deal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import wsdl.bean.Deal;


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
 *         &lt;element name="GetDealResult" type="{http://beans.com}Deal" minOccurs="0"/&gt;
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
    "getDealResult"
})
@XmlRootElement(name = "GetDealResponse")
public class GetDealResponse {

    @XmlElementRef(name = "GetDealResult", namespace = "http://dealservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Deal> getDealResult;

    /**
     * Gets the value of the getDealResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Deal }{@code >}
     *     
     */
    public JAXBElement<Deal> getGetDealResult() {
        return getDealResult;
    }

    /**
     * Sets the value of the getDealResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Deal }{@code >}
     *     
     */
    public void setGetDealResult(JAXBElement<Deal> value) {
        this.getDealResult = value;
    }

}
