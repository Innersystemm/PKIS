
package wsdl.flat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import wsdl.bean.ArrayOfFlat;
import wsdl.bean.Flat;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl.flat package. 
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

    private final static QName _AddFlatNewflat_QNAME = new QName("http://flatservice.com", "newflat");
    private final static QName _GetFlatResponseGetFlatResult_QNAME = new QName("http://flatservice.com", "GetFlatResult");
    private final static QName _GetAllFlatsResponseGetAllFlatsResult_QNAME = new QName("http://flatservice.com", "GetAllFlatsResult");
    private final static QName _UpdateFlatFlats_QNAME = new QName("http://flatservice.com", "flats");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl.flat
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFlat }
     * 
     */
    public AddFlat createAddFlat() {
        return new AddFlat();
    }

    /**
     * Create an instance of {@link AddFlatResponse }
     * 
     */
    public AddFlatResponse createAddFlatResponse() {
        return new AddFlatResponse();
    }

    /**
     * Create an instance of {@link GetFlat }
     * 
     */
    public GetFlat createGetFlat() {
        return new GetFlat();
    }

    /**
     * Create an instance of {@link GetFlatResponse }
     * 
     */
    public GetFlatResponse createGetFlatResponse() {
        return new GetFlatResponse();
    }

    /**
     * Create an instance of {@link GetAllFlats }
     * 
     */
    public GetAllFlats createGetAllFlats() {
        return new GetAllFlats();
    }

    /**
     * Create an instance of {@link GetAllFlatsResponse }
     * 
     */
    public GetAllFlatsResponse createGetAllFlatsResponse() {
        return new GetAllFlatsResponse();
    }

    /**
     * Create an instance of {@link UpdateFlat }
     * 
     */
    public UpdateFlat createUpdateFlat() {
        return new UpdateFlat();
    }

    /**
     * Create an instance of {@link UpdateFlatResponse }
     * 
     */
    public UpdateFlatResponse createUpdateFlatResponse() {
        return new UpdateFlatResponse();
    }

    /**
     * Create an instance of {@link RemoveFlat }
     * 
     */
    public RemoveFlat createRemoveFlat() {
        return new RemoveFlat();
    }

    /**
     * Create an instance of {@link RemoveFlatResponse }
     * 
     */
    public RemoveFlatResponse createRemoveFlatResponse() {
        return new RemoveFlatResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flatservice.com", name = "newflat", scope = AddFlat.class)
    public JAXBElement<Flat> createAddFlatNewflat(Flat value) {
        return new JAXBElement<Flat>(_AddFlatNewflat_QNAME, Flat.class, AddFlat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flatservice.com", name = "GetFlatResult", scope = GetFlatResponse.class)
    public JAXBElement<Flat> createGetFlatResponseGetFlatResult(Flat value) {
        return new JAXBElement<Flat>(_GetFlatResponseGetFlatResult_QNAME, Flat.class, GetFlatResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFlat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flatservice.com", name = "GetAllFlatsResult", scope = GetAllFlatsResponse.class)
    public JAXBElement<ArrayOfFlat> createGetAllFlatsResponseGetAllFlatsResult(ArrayOfFlat value) {
        return new JAXBElement<ArrayOfFlat>(_GetAllFlatsResponseGetAllFlatsResult_QNAME, ArrayOfFlat.class, GetAllFlatsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://flatservice.com", name = "flats", scope = UpdateFlat.class)
    public JAXBElement<Flat> createUpdateFlatFlats(Flat value) {
        return new JAXBElement<Flat>(_UpdateFlatFlats_QNAME, Flat.class, UpdateFlat.class, value);
    }

}
