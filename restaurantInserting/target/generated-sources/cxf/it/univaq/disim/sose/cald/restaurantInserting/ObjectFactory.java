
package it.univaq.disim.sose.cald.restaurantInserting;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.restaurantInserting package. 
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

    private final static QName _RestaurantInsertRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantInsertRequest");
    private final static QName _RestaurantInsertResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantInsertResponse");
    private final static QName _RestaurantInsertFault_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantInsertFault");
    private final static QName _RestaurantUpdateRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantUpdateRequest");
    private final static QName _RestaurantUpdateResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantUpdateResponse");
    private final static QName _RestaurantUpdateFault_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantUpdateFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.restaurantInserting
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RestaurantInsertRequest }
     * 
     */
    public RestaurantInsertRequest createRestaurantInsertRequest() {
        return new RestaurantInsertRequest();
    }

    /**
     * Create an instance of {@link RestaurantInsertResponse }
     * 
     */
    public RestaurantInsertResponse createRestaurantInsertResponse() {
        return new RestaurantInsertResponse();
    }

    /**
     * Create an instance of {@link RestaurantInsertFault }
     * 
     */
    public RestaurantInsertFault createRestaurantInsertFault() {
        return new RestaurantInsertFault();
    }

    /**
     * Create an instance of {@link RestaurantUpdateRequest }
     * 
     */
    public RestaurantUpdateRequest createRestaurantUpdateRequest() {
        return new RestaurantUpdateRequest();
    }

    /**
     * Create an instance of {@link RestaurantUpdateResponse }
     * 
     */
    public RestaurantUpdateResponse createRestaurantUpdateResponse() {
        return new RestaurantUpdateResponse();
    }

    /**
     * Create an instance of {@link RestaurantUpdateFault }
     * 
     */
    public RestaurantUpdateFault createRestaurantUpdateFault() {
        return new RestaurantUpdateFault();
    }

    /**
     * Create an instance of {@link RestaurantType }
     * 
     */
    public RestaurantType createRestaurantType() {
        return new RestaurantType();
    }

    /**
     * Create an instance of {@link RestaurantInfoType }
     * 
     */
    public RestaurantInfoType createRestaurantInfoType() {
        return new RestaurantInfoType();
    }

    /**
     * Create an instance of {@link DiscountType }
     * 
     */
    public DiscountType createDiscountType() {
        return new DiscountType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantInsertRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInserting", name = "restaurantInsertRequest")
    public JAXBElement<RestaurantInsertRequest> createRestaurantInsertRequest(RestaurantInsertRequest value) {
        return new JAXBElement<RestaurantInsertRequest>(_RestaurantInsertRequest_QNAME, RestaurantInsertRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantInsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInserting", name = "restaurantInsertResponse")
    public JAXBElement<RestaurantInsertResponse> createRestaurantInsertResponse(RestaurantInsertResponse value) {
        return new JAXBElement<RestaurantInsertResponse>(_RestaurantInsertResponse_QNAME, RestaurantInsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantInsertFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInserting", name = "restaurantInsertFault")
    public JAXBElement<RestaurantInsertFault> createRestaurantInsertFault(RestaurantInsertFault value) {
        return new JAXBElement<RestaurantInsertFault>(_RestaurantInsertFault_QNAME, RestaurantInsertFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantUpdateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInserting", name = "restaurantUpdateRequest")
    public JAXBElement<RestaurantUpdateRequest> createRestaurantUpdateRequest(RestaurantUpdateRequest value) {
        return new JAXBElement<RestaurantUpdateRequest>(_RestaurantUpdateRequest_QNAME, RestaurantUpdateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInserting", name = "restaurantUpdateResponse")
    public JAXBElement<RestaurantUpdateResponse> createRestaurantUpdateResponse(RestaurantUpdateResponse value) {
        return new JAXBElement<RestaurantUpdateResponse>(_RestaurantUpdateResponse_QNAME, RestaurantUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantUpdateFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInserting", name = "restaurantUpdateFault")
    public JAXBElement<RestaurantUpdateFault> createRestaurantUpdateFault(RestaurantUpdateFault value) {
        return new JAXBElement<RestaurantUpdateFault>(_RestaurantUpdateFault_QNAME, RestaurantUpdateFault.class, null, value);
    }

}
