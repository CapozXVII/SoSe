
package it.univaq.disim.sose.cald.cinemaInformation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.cinemaInformation package. 
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

    private final static QName _CinemaInformationRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInformation", "cinemaInformationRequest");
    private final static QName _CinemaInformationResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInformation", "cinemaInformationResponse");
    private final static QName _CinemaInformationFault_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInformation", "cinemaInformationFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.cinemaInformation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CinemaInformationRequest }
     * 
     */
    public CinemaInformationRequest createCinemaInformationRequest() {
        return new CinemaInformationRequest();
    }

    /**
     * Create an instance of {@link CinemaInformationResponse }
     * 
     */
    public CinemaInformationResponse createCinemaInformationResponse() {
        return new CinemaInformationResponse();
    }

    /**
     * Create an instance of {@link CinemaInformationFault }
     * 
     */
    public CinemaInformationFault createCinemaInformationFault() {
        return new CinemaInformationFault();
    }

    /**
     * Create an instance of {@link CinemaType }
     * 
     */
    public CinemaType createCinemaType() {
        return new CinemaType();
    }

    /**
     * Create an instance of {@link CinemaInfoType }
     * 
     */
    public CinemaInfoType createCinemaInfoType() {
        return new CinemaInfoType();
    }

    /**
     * Create an instance of {@link HallType }
     * 
     */
    public HallType createHallType() {
        return new HallType();
    }

    /**
     * Create an instance of {@link HallInfoType }
     * 
     */
    public HallInfoType createHallInfoType() {
        return new HallInfoType();
    }

    /**
     * Create an instance of {@link FilmType }
     * 
     */
    public FilmType createFilmType() {
        return new FilmType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaInformationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInformation", name = "cinemaInformationRequest")
    public JAXBElement<CinemaInformationRequest> createCinemaInformationRequest(CinemaInformationRequest value) {
        return new JAXBElement<CinemaInformationRequest>(_CinemaInformationRequest_QNAME, CinemaInformationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInformation", name = "cinemaInformationResponse")
    public JAXBElement<CinemaInformationResponse> createCinemaInformationResponse(CinemaInformationResponse value) {
        return new JAXBElement<CinemaInformationResponse>(_CinemaInformationResponse_QNAME, CinemaInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaInformationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInformation", name = "cinemaInformationFault")
    public JAXBElement<CinemaInformationFault> createCinemaInformationFault(CinemaInformationFault value) {
        return new JAXBElement<CinemaInformationFault>(_CinemaInformationFault_QNAME, CinemaInformationFault.class, null, value);
    }

}
