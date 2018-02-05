
package it.univaq.disim.sose.cald.cinemabooking;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.cinemabooking package. 
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

    private final static QName _CinemaBookingRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaBooking", "cinemaBookingRequest");
    private final static QName _CinemaBookingResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaBooking", "cinemaBookingResponse");
    private final static QName _CinemaBookingFault_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaBooking", "cinemaBookingFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.cinemabooking
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CinemaBookingRequest }
     * 
     */
    public CinemaBookingRequest createCinemaBookingRequest() {
        return new CinemaBookingRequest();
    }

    /**
     * Create an instance of {@link CinemaBookingResponse }
     * 
     */
    public CinemaBookingResponse createCinemaBookingResponse() {
        return new CinemaBookingResponse();
    }

    /**
     * Create an instance of {@link CinemaBookingFault }
     * 
     */
    public CinemaBookingFault createCinemaBookingFault() {
        return new CinemaBookingFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaBookingRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaBooking", name = "cinemaBookingRequest")
    public JAXBElement<CinemaBookingRequest> createCinemaBookingRequest(CinemaBookingRequest value) {
        return new JAXBElement<CinemaBookingRequest>(_CinemaBookingRequest_QNAME, CinemaBookingRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaBooking", name = "cinemaBookingResponse")
    public JAXBElement<CinemaBookingResponse> createCinemaBookingResponse(CinemaBookingResponse value) {
        return new JAXBElement<CinemaBookingResponse>(_CinemaBookingResponse_QNAME, CinemaBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaBookingFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaBooking", name = "cinemaBookingFault")
    public JAXBElement<CinemaBookingFault> createCinemaBookingFault(CinemaBookingFault value) {
        return new JAXBElement<CinemaBookingFault>(_CinemaBookingFault_QNAME, CinemaBookingFault.class, null, value);
    }

}
