
package it.univaq.disim.sose.cald.restaurantinformation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.restaurantinformation package. 
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

    private final static QName _RestaurantInformationRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInformation", "restaurantInformationRequest");
    private final static QName _RestaurantInformationResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInformation", "restaurantInformationResponse");
    private final static QName _RestaurantInformationFault_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantInformation", "restaurantInformationFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.restaurantinformation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RestaurantInformationRequest }
     * 
     */
    public RestaurantInformationRequest createRestaurantInformationRequest() {
        return new RestaurantInformationRequest();
    }

    /**
     * Create an instance of {@link RestaurantInformationResponse }
     * 
     */
    public RestaurantInformationResponse createRestaurantInformationResponse() {
        return new RestaurantInformationResponse();
    }

    /**
     * Create an instance of {@link RestaurantInformationFault }
     * 
     */
    public RestaurantInformationFault createRestaurantInformationFault() {
        return new RestaurantInformationFault();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantInformationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInformation", name = "restaurantInformationRequest")
    public JAXBElement<RestaurantInformationRequest> createRestaurantInformationRequest(RestaurantInformationRequest value) {
        return new JAXBElement<RestaurantInformationRequest>(_RestaurantInformationRequest_QNAME, RestaurantInformationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInformation", name = "restaurantInformationResponse")
    public JAXBElement<RestaurantInformationResponse> createRestaurantInformationResponse(RestaurantInformationResponse value) {
        return new JAXBElement<RestaurantInformationResponse>(_RestaurantInformationResponse_QNAME, RestaurantInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantInformationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantInformation", name = "restaurantInformationFault")
    public JAXBElement<RestaurantInformationFault> createRestaurantInformationFault(RestaurantInformationFault value) {
        return new JAXBElement<RestaurantInformationFault>(_RestaurantInformationFault_QNAME, RestaurantInformationFault.class, null, value);
    }

}
