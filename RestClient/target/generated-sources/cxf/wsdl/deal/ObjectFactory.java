
package wsdl.deal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import wsdl.bean.ArrayOfDeal;
import wsdl.bean.Deal;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl.deal package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddDealNewdeal_QNAME = new QName("http://dealservice.com", "newdeal");
    private final static QName _GetDealResponseGetDealResult_QNAME = new QName("http://dealservice.com", "GetDealResult");
    private final static QName _GetAllDealsResponseGetAllDealsResult_QNAME = new QName("http://dealservice.com", "GetAllDealsResult");
    private final static QName _UpdateDealDeals_QNAME = new QName("http://dealservice.com", "deals");
    private final static QName _GetDealsByPeriodResponseGetDealsByPeriodResult_QNAME = new QName("http://dealservice.com", "GetDealsByPeriodResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl.deal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddDeal }
     * 
     */
    public AddDeal createAddDeal() {
        return new AddDeal();
    }

    /**
     * Create an instance of {@link AddDealResponse }
     * 
     */
    public AddDealResponse createAddDealResponse() {
        return new AddDealResponse();
    }

    /**
     * Create an instance of {@link GetDeal }
     * 
     */
    public GetDeal createGetDeal() {
        return new GetDeal();
    }

    /**
     * Create an instance of {@link GetDealResponse }
     * 
     */
    public GetDealResponse createGetDealResponse() {
        return new GetDealResponse();
    }

    /**
     * Create an instance of {@link GetAllDeals }
     * 
     */
    public GetAllDeals createGetAllDeals() {
        return new GetAllDeals();
    }

    /**
     * Create an instance of {@link GetAllDealsResponse }
     * 
     */
    public GetAllDealsResponse createGetAllDealsResponse() {
        return new GetAllDealsResponse();
    }

    /**
     * Create an instance of {@link UpdateDeal }
     * 
     */
    public UpdateDeal createUpdateDeal() {
        return new UpdateDeal();
    }

    /**
     * Create an instance of {@link UpdateDealResponse }
     * 
     */
    public UpdateDealResponse createUpdateDealResponse() {
        return new UpdateDealResponse();
    }

    /**
     * Create an instance of {@link RemoveDeal }
     * 
     */
    public RemoveDeal createRemoveDeal() {
        return new RemoveDeal();
    }

    /**
     * Create an instance of {@link RemoveDealResponse }
     * 
     */
    public RemoveDealResponse createRemoveDealResponse() {
        return new RemoveDealResponse();
    }

    /**
     * Create an instance of {@link GetDealsByPeriod }
     * 
     */
    public GetDealsByPeriod createGetDealsByPeriod() {
        return new GetDealsByPeriod();
    }

    /**
     * Create an instance of {@link GetDealsByPeriodResponse }
     * 
     */
    public GetDealsByPeriodResponse createGetDealsByPeriodResponse() {
        return new GetDealsByPeriodResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dealservice.com", name = "newdeal", scope = AddDeal.class)
    public JAXBElement<Deal> createAddDealNewdeal(Deal value) {
        return new JAXBElement<Deal>(_AddDealNewdeal_QNAME, Deal.class, AddDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dealservice.com", name = "GetDealResult", scope = GetDealResponse.class)
    public JAXBElement<Deal> createGetDealResponseGetDealResult(Deal value) {
        return new JAXBElement<Deal>(_GetDealResponseGetDealResult_QNAME, Deal.class, GetDealResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dealservice.com", name = "GetAllDealsResult", scope = GetAllDealsResponse.class)
    public JAXBElement<ArrayOfDeal> createGetAllDealsResponseGetAllDealsResult(ArrayOfDeal value) {
        return new JAXBElement<ArrayOfDeal>(_GetAllDealsResponseGetAllDealsResult_QNAME, ArrayOfDeal.class, GetAllDealsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dealservice.com", name = "deals", scope = UpdateDeal.class)
    public JAXBElement<Deal> createUpdateDealDeals(Deal value) {
        return new JAXBElement<Deal>(_UpdateDealDeals_QNAME, Deal.class, UpdateDeal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dealservice.com", name = "GetDealsByPeriodResult", scope = GetDealsByPeriodResponse.class)
    public JAXBElement<ArrayOfDeal> createGetDealsByPeriodResponseGetDealsByPeriodResult(ArrayOfDeal value) {
        return new JAXBElement<ArrayOfDeal>(_GetDealsByPeriodResponseGetDealsByPeriodResult_QNAME, ArrayOfDeal.class, GetDealsByPeriodResponse.class, value);
    }

}
