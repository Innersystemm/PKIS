
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
 *         &lt;element name="deals" type="{http://beans.com}Deal" minOccurs="0"/&gt;
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
    "deals"
})
@XmlRootElement(name = "UpdateDeal")
public class UpdateDeal {

    @XmlElementRef(name = "deals", namespace = "http://dealservice.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Deal> deals;

    /**
     * Gets the value of the deals property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Deal }{@code >}
     *     
     */
    public JAXBElement<Deal> getDeals() {
        return deals;
    }

    /**
     * Sets the value of the deals property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Deal }{@code >}
     *     
     */
    public void setDeals(JAXBElement<Deal> value) {
        this.deals = value;
    }

}
