
package wsdl.region;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import wsdl.bean.ArrayOfRegion;
import wsdl.bean.Region;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl.region package. 
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

    private final static QName _AddRegionRegion_QNAME = new QName("http://regionservice.com", "region");
    private final static QName _GetRegionResponseGetRegionResult_QNAME = new QName("http://regionservice.com", "GetRegionResult");
    private final static QName _GetAllRegionsResponseGetAllRegionsResult_QNAME = new QName("http://regionservice.com", "GetAllRegionsResult");
    private final static QName _UpdateRegionRegions_QNAME = new QName("http://regionservice.com", "regions");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl.region
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddRegion }
     * 
     */
    public AddRegion createAddRegion() {
        return new AddRegion();
    }

    /**
     * Create an instance of {@link AddRegionResponse }
     * 
     */
    public AddRegionResponse createAddRegionResponse() {
        return new AddRegionResponse();
    }

    /**
     * Create an instance of {@link GetRegion }
     * 
     */
    public GetRegion createGetRegion() {
        return new GetRegion();
    }

    /**
     * Create an instance of {@link GetRegionResponse }
     * 
     */
    public GetRegionResponse createGetRegionResponse() {
        return new GetRegionResponse();
    }

    /**
     * Create an instance of {@link GetAllRegions }
     * 
     */
    public GetAllRegions createGetAllRegions() {
        return new GetAllRegions();
    }

    /**
     * Create an instance of {@link GetAllRegionsResponse }
     * 
     */
    public GetAllRegionsResponse createGetAllRegionsResponse() {
        return new GetAllRegionsResponse();
    }

    /**
     * Create an instance of {@link UpdateRegion }
     * 
     */
    public UpdateRegion createUpdateRegion() {
        return new UpdateRegion();
    }

    /**
     * Create an instance of {@link UpdateRegionResponse }
     * 
     */
    public UpdateRegionResponse createUpdateRegionResponse() {
        return new UpdateRegionResponse();
    }

    /**
     * Create an instance of {@link RemoveRegion }
     * 
     */
    public RemoveRegion createRemoveRegion() {
        return new RemoveRegion();
    }

    /**
     * Create an instance of {@link RemoveRegionResponse }
     * 
     */
    public RemoveRegionResponse createRemoveRegionResponse() {
        return new RemoveRegionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://regionservice.com", name = "region", scope = AddRegion.class)
    public JAXBElement<Region> createAddRegionRegion(Region value) {
        return new JAXBElement<Region>(_AddRegionRegion_QNAME, Region.class, AddRegion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://regionservice.com", name = "GetRegionResult", scope = GetRegionResponse.class)
    public JAXBElement<Region> createGetRegionResponseGetRegionResult(Region value) {
        return new JAXBElement<Region>(_GetRegionResponseGetRegionResult_QNAME, Region.class, GetRegionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRegion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://regionservice.com", name = "GetAllRegionsResult", scope = GetAllRegionsResponse.class)
    public JAXBElement<ArrayOfRegion> createGetAllRegionsResponseGetAllRegionsResult(ArrayOfRegion value) {
        return new JAXBElement<ArrayOfRegion>(_GetAllRegionsResponseGetAllRegionsResult_QNAME, ArrayOfRegion.class, GetAllRegionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://regionservice.com", name = "regions", scope = UpdateRegion.class)
    public JAXBElement<Region> createUpdateRegionRegions(Region value) {
        return new JAXBElement<Region>(_UpdateRegionRegions_QNAME, Region.class, UpdateRegion.class, value);
    }

}
