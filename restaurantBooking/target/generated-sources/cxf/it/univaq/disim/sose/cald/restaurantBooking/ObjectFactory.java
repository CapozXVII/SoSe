
package it.univaq.disim.sose.cald.restaurantBooking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.restaurantBooking package. 
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

    private final static QName _RestaurantBookingRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantBooking", "restaurantBookingRequest");
    private final static QName _RestaurantBookingResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantBooking", "restaurantBookingResponse");
    private final static QName _RestaurantBookingFault_QNAME = new QName("http://it.univaq.disim.sose.cald/restaurantBooking", "restaurantBookingFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.restaurantBooking
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RestaurantBookingRequest }
     * 
     */
    public RestaurantBookingRequest createRestaurantBookingRequest() {
        return new RestaurantBookingRequest();
    }

    /**
     * Create an instance of {@link RestaurantBookingResponse }
     * 
     */
    public RestaurantBookingResponse createRestaurantBookingResponse() {
        return new RestaurantBookingResponse();
    }

    /**
     * Create an instance of {@link RestaurantBookingFault }
     * 
     */
    public RestaurantBookingFault createRestaurantBookingFault() {
        return new RestaurantBookingFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantBookingRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantBooking", name = "restaurantBookingRequest")
    public JAXBElement<RestaurantBookingRequest> createRestaurantBookingRequest(RestaurantBookingRequest value) {
        return new JAXBElement<RestaurantBookingRequest>(_RestaurantBookingRequest_QNAME, RestaurantBookingRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantBooking", name = "restaurantBookingResponse")
    public JAXBElement<RestaurantBookingResponse> createRestaurantBookingResponse(RestaurantBookingResponse value) {
        return new JAXBElement<RestaurantBookingResponse>(_RestaurantBookingResponse_QNAME, RestaurantBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestaurantBookingFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/restaurantBooking", name = "restaurantBookingFault")
    public JAXBElement<RestaurantBookingFault> createRestaurantBookingFault(RestaurantBookingFault value) {
        return new JAXBElement<RestaurantBookingFault>(_RestaurantBookingFault_QNAME, RestaurantBookingFault.class, null, value);
    }

}
