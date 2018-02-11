
package it.univaq.disim.sose.cald.cinemainserting;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.cinemainserting package. 
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

    private final static QName _CinemaInsertRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInserting", "cinemaInsertRequest");
    private final static QName _CinemaInsertResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInserting", "cinemaInsertResponse");
    private final static QName _CinemaInsertFault_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInserting", "cinemaInsertFault");
    private final static QName _CinemaUpdateRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInserting", "cinemaUpdateRequest");
    private final static QName _CinemaUpdateResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInserting", "cinemaUpdateResponse");
    private final static QName _CinemaUpdateFault_QNAME = new QName("http://it.univaq.disim.sose.cald/cinemaInserting", "cinemaUpdateFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.cinemainserting
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CinemaInsertRequest }
     * 
     */
    public CinemaInsertRequest createCinemaInsertRequest() {
        return new CinemaInsertRequest();
    }

    /**
     * Create an instance of {@link CinemaInsertResponse }
     * 
     */
    public CinemaInsertResponse createCinemaInsertResponse() {
        return new CinemaInsertResponse();
    }

    /**
     * Create an instance of {@link CinemaInsertFault }
     * 
     */
    public CinemaInsertFault createCinemaInsertFault() {
        return new CinemaInsertFault();
    }

    /**
     * Create an instance of {@link CinemaUpdateRequest }
     * 
     */
    public CinemaUpdateRequest createCinemaUpdateRequest() {
        return new CinemaUpdateRequest();
    }

    /**
     * Create an instance of {@link CinemaUpdateResponse }
     * 
     */
    public CinemaUpdateResponse createCinemaUpdateResponse() {
        return new CinemaUpdateResponse();
    }

    /**
     * Create an instance of {@link CinemaUpdateFault }
     * 
     */
    public CinemaUpdateFault createCinemaUpdateFault() {
        return new CinemaUpdateFault();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaInsertRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInserting", name = "cinemaInsertRequest")
    public JAXBElement<CinemaInsertRequest> createCinemaInsertRequest(CinemaInsertRequest value) {
        return new JAXBElement<CinemaInsertRequest>(_CinemaInsertRequest_QNAME, CinemaInsertRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaInsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInserting", name = "cinemaInsertResponse")
    public JAXBElement<CinemaInsertResponse> createCinemaInsertResponse(CinemaInsertResponse value) {
        return new JAXBElement<CinemaInsertResponse>(_CinemaInsertResponse_QNAME, CinemaInsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaInsertFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInserting", name = "cinemaInsertFault")
    public JAXBElement<CinemaInsertFault> createCinemaInsertFault(CinemaInsertFault value) {
        return new JAXBElement<CinemaInsertFault>(_CinemaInsertFault_QNAME, CinemaInsertFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaUpdateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInserting", name = "cinemaUpdateRequest")
    public JAXBElement<CinemaUpdateRequest> createCinemaUpdateRequest(CinemaUpdateRequest value) {
        return new JAXBElement<CinemaUpdateRequest>(_CinemaUpdateRequest_QNAME, CinemaUpdateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaUpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInserting", name = "cinemaUpdateResponse")
    public JAXBElement<CinemaUpdateResponse> createCinemaUpdateResponse(CinemaUpdateResponse value) {
        return new JAXBElement<CinemaUpdateResponse>(_CinemaUpdateResponse_QNAME, CinemaUpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CinemaUpdateFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/cinemaInserting", name = "cinemaUpdateFault")
    public JAXBElement<CinemaUpdateFault> createCinemaUpdateFault(CinemaUpdateFault value) {
        return new JAXBElement<CinemaUpdateFault>(_CinemaUpdateFault_QNAME, CinemaUpdateFault.class, null, value);
    }

}
