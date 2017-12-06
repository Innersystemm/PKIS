
package wsdl.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl.bean package. 
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

    private final static QName _Flat_QNAME = new QName("http://beans.com", "Flat");
    private final static QName _ArrayOfDeal_QNAME = new QName("http://beans.com", "ArrayOfDeal");
    private final static QName _Deal_QNAME = new QName("http://beans.com", "Deal");
    private final static QName _Region_QNAME = new QName("http://beans.com", "Region");
    private final static QName _ArrayOfFlat_QNAME = new QName("http://beans.com", "ArrayOfFlat");
    private final static QName _RegionRegionFlats_QNAME = new QName("http://beans.com", "RegionFlats");
    private final static QName _RegionRegionName_QNAME = new QName("http://beans.com", "RegionName");
    private final static QName _DealDealFlat_QNAME = new QName("http://beans.com", "DealFlat");
    private final static QName _FlatFlatDeals_QNAME = new QName("http://beans.com", "FlatDeals");
    private final static QName _FlatFlatRegion_QNAME = new QName("http://beans.com", "FlatRegion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl.bean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Flat }
     * 
     */
    public Flat createFlat() {
        return new Flat();
    }

    /**
     * Create an instance of {@link ArrayOfDeal }
     * 
     */
    public ArrayOfDeal createArrayOfDeal() {
        return new ArrayOfDeal();
    }

    /**
     * Create an instance of {@link Deal }
     * 
     */
    public Deal createDeal() {
        return new Deal();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link ArrayOfFlat }
     * 
     */
    public ArrayOfFlat createArrayOfFlat() {
        return new ArrayOfFlat();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "Flat")
    public JAXBElement<Flat> createFlat(Flat value) {
        return new JAXBElement<Flat>(_Flat_QNAME, Flat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "ArrayOfDeal")
    public JAXBElement<ArrayOfDeal> createArrayOfDeal(ArrayOfDeal value) {
        return new JAXBElement<ArrayOfDeal>(_ArrayOfDeal_QNAME, ArrayOfDeal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "Deal")
    public JAXBElement<Deal> createDeal(Deal value) {
        return new JAXBElement<Deal>(_Deal_QNAME, Deal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "Region")
    public JAXBElement<Region> createRegion(Region value) {
        return new JAXBElement<Region>(_Region_QNAME, Region.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFlat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "ArrayOfFlat")
    public JAXBElement<ArrayOfFlat> createArrayOfFlat(ArrayOfFlat value) {
        return new JAXBElement<ArrayOfFlat>(_ArrayOfFlat_QNAME, ArrayOfFlat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFlat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "RegionFlats", scope = Region.class)
    public JAXBElement<ArrayOfFlat> createRegionRegionFlats(ArrayOfFlat value) {
        return new JAXBElement<ArrayOfFlat>(_RegionRegionFlats_QNAME, ArrayOfFlat.class, Region.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "RegionName", scope = Region.class)
    public JAXBElement<String> createRegionRegionName(String value) {
        return new JAXBElement<String>(_RegionRegionName_QNAME, String.class, Region.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "DealFlat", scope = Deal.class)
    public JAXBElement<Flat> createDealDealFlat(Flat value) {
        return new JAXBElement<Flat>(_DealDealFlat_QNAME, Flat.class, Deal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "FlatDeals", scope = Flat.class)
    public JAXBElement<ArrayOfDeal> createFlatFlatDeals(ArrayOfDeal value) {
        return new JAXBElement<ArrayOfDeal>(_FlatFlatDeals_QNAME, ArrayOfDeal.class, Flat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Region }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans.com", name = "FlatRegion", scope = Flat.class)
    public JAXBElement<Region> createFlatFlatRegion(Region value) {
        return new JAXBElement<Region>(_FlatFlatRegion_QNAME, Region.class, Flat.class, value);
    }

}
