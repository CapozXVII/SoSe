
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.enjoyreservation package. 
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

    private final static QName _InsertCinemaRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "insertCinemaRequest");
    private final static QName _GetCinemaInfoRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "getCinemaInfoRequest");
    private final static QName _BookingCinemaRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "bookingCinemaRequest");
    private final static QName _UpdateCinemaRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "updateCinemaRequest");
    private final static QName _InsertRestaurantRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "insertRestaurantRequest");
    private final static QName _GetRestaurantInfoRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "getRestaurantInfoRequest");
    private final static QName _BookingRestaurantRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "bookingRestaurantRequest");
    private final static QName _UpdateRestaurantRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "updateRestaurantRequest");
    private final static QName _InsertCinemaResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "insertCinemaResponse");
    private final static QName _GetCinemaInfoResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "getCinemaInfoResponse");
    private final static QName _BookingCinemaResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "bookingCinemaResponse");
    private final static QName _UpdateCinemaResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "updateCinemaResponse");
    private final static QName _InsertRestaurantResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "insertRestaurantResponse");
    private final static QName _GetRestaurantInfoResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "getRestaurantInfoResponse");
    private final static QName _BookingRestaurantResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "bookingRestaurantResponse");
    private final static QName _UpdateRestaurantResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "updateRestaurantResponse");
    private final static QName _GetRestaurantInfoFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "getRestaurantInfoFault");
    private final static QName _GetCinemaInfoFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "getCinemaInfoFault");
    private final static QName _BookingCinemaFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "bookingCinemaFault");
    private final static QName _BookingRestaurantFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "bookingRestaurantFault");
    private final static QName _InsertRestaurantFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "insertRestaurantFault");
    private final static QName _UpdateRestaurantFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "updateRestaurantFault");
    private final static QName _InsertCinemaFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "insertCinemaFault");
    private final static QName _UpdateCinemaFault_QNAME = new QName("http://it.univaq.disim.sose.cald/enjoyReservation", "updateCinemaFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.enjoyreservation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertCinemaRequest }
     * 
     */
    public InsertCinemaRequest createInsertCinemaRequest() {
        return new InsertCinemaRequest();
    }

    /**
     * Create an instance of {@link GetCinemaInfoRequest }
     * 
     */
    public GetCinemaInfoRequest createGetCinemaInfoRequest() {
        return new GetCinemaInfoRequest();
    }

    /**
     * Create an instance of {@link BookingCinemaRequest }
     * 
     */
    public BookingCinemaRequest createBookingCinemaRequest() {
        return new BookingCinemaRequest();
    }

    /**
     * Create an instance of {@link UpdateCinemaRequest }
     * 
     */
    public UpdateCinemaRequest createUpdateCinemaRequest() {
        return new UpdateCinemaRequest();
    }

    /**
     * Create an instance of {@link InsertRestaurantRequest }
     * 
     */
    public InsertRestaurantRequest createInsertRestaurantRequest() {
        return new InsertRestaurantRequest();
    }

    /**
     * Create an instance of {@link GetRestaurantInfoRequest }
     * 
     */
    public GetRestaurantInfoRequest createGetRestaurantInfoRequest() {
        return new GetRestaurantInfoRequest();
    }

    /**
     * Create an instance of {@link BookingRestaurantRequest }
     * 
     */
    public BookingRestaurantRequest createBookingRestaurantRequest() {
        return new BookingRestaurantRequest();
    }

    /**
     * Create an instance of {@link UpdateRestaurantRequest }
     * 
     */
    public UpdateRestaurantRequest createUpdateRestaurantRequest() {
        return new UpdateRestaurantRequest();
    }

    /**
     * Create an instance of {@link InsertCinemaResponse }
     * 
     */
    public InsertCinemaResponse createInsertCinemaResponse() {
        return new InsertCinemaResponse();
    }

    /**
     * Create an instance of {@link GetCinemaInfoResponse }
     * 
     */
    public GetCinemaInfoResponse createGetCinemaInfoResponse() {
        return new GetCinemaInfoResponse();
    }

    /**
     * Create an instance of {@link BookingCinemaResponse }
     * 
     */
    public BookingCinemaResponse createBookingCinemaResponse() {
        return new BookingCinemaResponse();
    }

    /**
     * Create an instance of {@link UpdateCinemaResponse }
     * 
     */
    public UpdateCinemaResponse createUpdateCinemaResponse() {
        return new UpdateCinemaResponse();
    }

    /**
     * Create an instance of {@link InsertRestaurantResponse }
     * 
     */
    public InsertRestaurantResponse createInsertRestaurantResponse() {
        return new InsertRestaurantResponse();
    }

    /**
     * Create an instance of {@link GetRestaurantInfoResponse }
     * 
     */
    public GetRestaurantInfoResponse createGetRestaurantInfoResponse() {
        return new GetRestaurantInfoResponse();
    }

    /**
     * Create an instance of {@link BookingRestaurantResponse }
     * 
     */
    public BookingRestaurantResponse createBookingRestaurantResponse() {
        return new BookingRestaurantResponse();
    }

    /**
     * Create an instance of {@link UpdateRestaurantResponse }
     * 
     */
    public UpdateRestaurantResponse createUpdateRestaurantResponse() {
        return new UpdateRestaurantResponse();
    }

    /**
     * Create an instance of {@link GetRestaurantInfoFault }
     * 
     */
    public GetRestaurantInfoFault createGetRestaurantInfoFault() {
        return new GetRestaurantInfoFault();
    }

    /**
     * Create an instance of {@link GetCinemaInfoFault }
     * 
     */
    public GetCinemaInfoFault createGetCinemaInfoFault() {
        return new GetCinemaInfoFault();
    }

    /**
     * Create an instance of {@link BookingCinemaFault }
     * 
     */
    public BookingCinemaFault createBookingCinemaFault() {
        return new BookingCinemaFault();
    }

    /**
     * Create an instance of {@link BookingRestaurantFault }
     * 
     */
    public BookingRestaurantFault createBookingRestaurantFault() {
        return new BookingRestaurantFault();
    }

    /**
     * Create an instance of {@link InsertRestaurantFault }
     * 
     */
    public InsertRestaurantFault createInsertRestaurantFault() {
        return new InsertRestaurantFault();
    }

    /**
     * Create an instance of {@link UpdateRestaurantFault }
     * 
     */
    public UpdateRestaurantFault createUpdateRestaurantFault() {
        return new UpdateRestaurantFault();
    }

    /**
     * Create an instance of {@link InsertCinemaFault }
     * 
     */
    public InsertCinemaFault createInsertCinemaFault() {
        return new InsertCinemaFault();
    }

    /**
     * Create an instance of {@link UpdateCinemaFault }
     * 
     */
    public UpdateCinemaFault createUpdateCinemaFault() {
        return new UpdateCinemaFault();
    }

    /**
     * Create an instance of {@link OSMRestaurantType }
     * 
     */
    public OSMRestaurantType createOSMRestaurantType() {
        return new OSMRestaurantType();
    }

    /**
     * Create an instance of {@link OSMRestaurantInfoType }
     * 
     */
    public OSMRestaurantInfoType createOSMRestaurantInfoType() {
        return new OSMRestaurantInfoType();
    }

    /**
     * Create an instance of {@link OSMTableType }
     * 
     */
    public OSMTableType createOSMTableType() {
        return new OSMTableType();
    }

    /**
     * Create an instance of {@link OSMTableInfoType }
     * 
     */
    public OSMTableInfoType createOSMTableInfoType() {
        return new OSMTableInfoType();
    }

    /**
     * Create an instance of {@link OSMDiscountType }
     * 
     */
    public OSMDiscountType createOSMDiscountType() {
        return new OSMDiscountType();
    }

    /**
     * Create an instance of {@link OSMCinemaType }
     * 
     */
    public OSMCinemaType createOSMCinemaType() {
        return new OSMCinemaType();
    }

    /**
     * Create an instance of {@link OSMCinemaInfoType }
     * 
     */
    public OSMCinemaInfoType createOSMCinemaInfoType() {
        return new OSMCinemaInfoType();
    }

    /**
     * Create an instance of {@link OSMHallType }
     * 
     */
    public OSMHallType createOSMHallType() {
        return new OSMHallType();
    }

    /**
     * Create an instance of {@link OSMHallInfoType }
     * 
     */
    public OSMHallInfoType createOSMHallInfoType() {
        return new OSMHallInfoType();
    }

    /**
     * Create an instance of {@link OSMFilmType }
     * 
     */
    public OSMFilmType createOSMFilmType() {
        return new OSMFilmType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCinemaRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "insertCinemaRequest")
    public JAXBElement<InsertCinemaRequest> createInsertCinemaRequest(InsertCinemaRequest value) {
        return new JAXBElement<InsertCinemaRequest>(_InsertCinemaRequest_QNAME, InsertCinemaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCinemaInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "getCinemaInfoRequest")
    public JAXBElement<GetCinemaInfoRequest> createGetCinemaInfoRequest(GetCinemaInfoRequest value) {
        return new JAXBElement<GetCinemaInfoRequest>(_GetCinemaInfoRequest_QNAME, GetCinemaInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingCinemaRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "bookingCinemaRequest")
    public JAXBElement<BookingCinemaRequest> createBookingCinemaRequest(BookingCinemaRequest value) {
        return new JAXBElement<BookingCinemaRequest>(_BookingCinemaRequest_QNAME, BookingCinemaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCinemaRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "updateCinemaRequest")
    public JAXBElement<UpdateCinemaRequest> createUpdateCinemaRequest(UpdateCinemaRequest value) {
        return new JAXBElement<UpdateCinemaRequest>(_UpdateCinemaRequest_QNAME, UpdateCinemaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRestaurantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "insertRestaurantRequest")
    public JAXBElement<InsertRestaurantRequest> createInsertRestaurantRequest(InsertRestaurantRequest value) {
        return new JAXBElement<InsertRestaurantRequest>(_InsertRestaurantRequest_QNAME, InsertRestaurantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "getRestaurantInfoRequest")
    public JAXBElement<GetRestaurantInfoRequest> createGetRestaurantInfoRequest(GetRestaurantInfoRequest value) {
        return new JAXBElement<GetRestaurantInfoRequest>(_GetRestaurantInfoRequest_QNAME, GetRestaurantInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingRestaurantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "bookingRestaurantRequest")
    public JAXBElement<BookingRestaurantRequest> createBookingRestaurantRequest(BookingRestaurantRequest value) {
        return new JAXBElement<BookingRestaurantRequest>(_BookingRestaurantRequest_QNAME, BookingRestaurantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRestaurantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "updateRestaurantRequest")
    public JAXBElement<UpdateRestaurantRequest> createUpdateRestaurantRequest(UpdateRestaurantRequest value) {
        return new JAXBElement<UpdateRestaurantRequest>(_UpdateRestaurantRequest_QNAME, UpdateRestaurantRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCinemaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "insertCinemaResponse")
    public JAXBElement<InsertCinemaResponse> createInsertCinemaResponse(InsertCinemaResponse value) {
        return new JAXBElement<InsertCinemaResponse>(_InsertCinemaResponse_QNAME, InsertCinemaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCinemaInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "getCinemaInfoResponse")
    public JAXBElement<GetCinemaInfoResponse> createGetCinemaInfoResponse(GetCinemaInfoResponse value) {
        return new JAXBElement<GetCinemaInfoResponse>(_GetCinemaInfoResponse_QNAME, GetCinemaInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingCinemaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "bookingCinemaResponse")
    public JAXBElement<BookingCinemaResponse> createBookingCinemaResponse(BookingCinemaResponse value) {
        return new JAXBElement<BookingCinemaResponse>(_BookingCinemaResponse_QNAME, BookingCinemaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCinemaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "updateCinemaResponse")
    public JAXBElement<UpdateCinemaResponse> createUpdateCinemaResponse(UpdateCinemaResponse value) {
        return new JAXBElement<UpdateCinemaResponse>(_UpdateCinemaResponse_QNAME, UpdateCinemaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "insertRestaurantResponse")
    public JAXBElement<InsertRestaurantResponse> createInsertRestaurantResponse(InsertRestaurantResponse value) {
        return new JAXBElement<InsertRestaurantResponse>(_InsertRestaurantResponse_QNAME, InsertRestaurantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "getRestaurantInfoResponse")
    public JAXBElement<GetRestaurantInfoResponse> createGetRestaurantInfoResponse(GetRestaurantInfoResponse value) {
        return new JAXBElement<GetRestaurantInfoResponse>(_GetRestaurantInfoResponse_QNAME, GetRestaurantInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "bookingRestaurantResponse")
    public JAXBElement<BookingRestaurantResponse> createBookingRestaurantResponse(BookingRestaurantResponse value) {
        return new JAXBElement<BookingRestaurantResponse>(_BookingRestaurantResponse_QNAME, BookingRestaurantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "updateRestaurantResponse")
    public JAXBElement<UpdateRestaurantResponse> createUpdateRestaurantResponse(UpdateRestaurantResponse value) {
        return new JAXBElement<UpdateRestaurantResponse>(_UpdateRestaurantResponse_QNAME, UpdateRestaurantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantInfoFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "getRestaurantInfoFault")
    public JAXBElement<GetRestaurantInfoFault> createGetRestaurantInfoFault(GetRestaurantInfoFault value) {
        return new JAXBElement<GetRestaurantInfoFault>(_GetRestaurantInfoFault_QNAME, GetRestaurantInfoFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCinemaInfoFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "getCinemaInfoFault")
    public JAXBElement<GetCinemaInfoFault> createGetCinemaInfoFault(GetCinemaInfoFault value) {
        return new JAXBElement<GetCinemaInfoFault>(_GetCinemaInfoFault_QNAME, GetCinemaInfoFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingCinemaFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "bookingCinemaFault")
    public JAXBElement<BookingCinemaFault> createBookingCinemaFault(BookingCinemaFault value) {
        return new JAXBElement<BookingCinemaFault>(_BookingCinemaFault_QNAME, BookingCinemaFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingRestaurantFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "bookingRestaurantFault")
    public JAXBElement<BookingRestaurantFault> createBookingRestaurantFault(BookingRestaurantFault value) {
        return new JAXBElement<BookingRestaurantFault>(_BookingRestaurantFault_QNAME, BookingRestaurantFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertRestaurantFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "insertRestaurantFault")
    public JAXBElement<InsertRestaurantFault> createInsertRestaurantFault(InsertRestaurantFault value) {
        return new JAXBElement<InsertRestaurantFault>(_InsertRestaurantFault_QNAME, InsertRestaurantFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRestaurantFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "updateRestaurantFault")
    public JAXBElement<UpdateRestaurantFault> createUpdateRestaurantFault(UpdateRestaurantFault value) {
        return new JAXBElement<UpdateRestaurantFault>(_UpdateRestaurantFault_QNAME, UpdateRestaurantFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCinemaFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "insertCinemaFault")
    public JAXBElement<InsertCinemaFault> createInsertCinemaFault(InsertCinemaFault value) {
        return new JAXBElement<InsertCinemaFault>(_InsertCinemaFault_QNAME, InsertCinemaFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCinemaFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "updateCinemaFault")
    public JAXBElement<UpdateCinemaFault> createUpdateCinemaFault(UpdateCinemaFault value) {
        return new JAXBElement<UpdateCinemaFault>(_UpdateCinemaFault_QNAME, UpdateCinemaFault.class, null, value);
    }

}