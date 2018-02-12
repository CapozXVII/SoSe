
package it.univaq.disim.sose.cald.accountmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.sose.cald.accountmanager package. 
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

    private final static QName _UserSignupRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userSignupRequest");
    private final static QName _UserSignupResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userSignupResponse");
    private final static QName _UserSignupFault_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userSignupFault");
    private final static QName _UserLoginRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userLoginRequest");
    private final static QName _UserLoginResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userLoginResponse");
    private final static QName _UserLoginFault_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userLoginFault");
    private final static QName _UserLogoutRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userLogoutRequest");
    private final static QName _UserLogoutResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userLogoutResponse");
    private final static QName _UserLogoutFault_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "userLogoutFault");
    private final static QName _CheckSessionRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkSessionRequest");
    private final static QName _CheckSessionResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkSessionResponse");
    private final static QName _CheckSessionFault_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkSessionFault");
    private final static QName _CheckCinemaOwnerRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkCinemaOwnerRequest");
    private final static QName _CheckCinemaOwnerResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkCinemaOwnerResponse");
    private final static QName _CheckCinemaOwnerFault_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkCinemaOwnerFault");
    private final static QName _CheckRestaurantOwnerRequest_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkRestaurantOwnerRequest");
    private final static QName _CheckRestaurantOwnerResponse_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkRestaurantOwnerResponse");
    private final static QName _CheckRestaurantOwnerFault_QNAME = new QName("http://it.univaq.disim.sose.cald/accountManager", "checkRestaurantOwnerFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.sose.cald.accountmanager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserSignupRequest }
     * 
     */
    public UserSignupRequest createUserSignupRequest() {
        return new UserSignupRequest();
    }

    /**
     * Create an instance of {@link UserSignupResponse }
     * 
     */
    public UserSignupResponse createUserSignupResponse() {
        return new UserSignupResponse();
    }

    /**
     * Create an instance of {@link UserSignupFault }
     * 
     */
    public UserSignupFault createUserSignupFault() {
        return new UserSignupFault();
    }

    /**
     * Create an instance of {@link UserLoginRequest }
     * 
     */
    public UserLoginRequest createUserLoginRequest() {
        return new UserLoginRequest();
    }

    /**
     * Create an instance of {@link UserLoginResponse }
     * 
     */
    public UserLoginResponse createUserLoginResponse() {
        return new UserLoginResponse();
    }

    /**
     * Create an instance of {@link UserLoginFault }
     * 
     */
    public UserLoginFault createUserLoginFault() {
        return new UserLoginFault();
    }

    /**
     * Create an instance of {@link UserLogoutRequest }
     * 
     */
    public UserLogoutRequest createUserLogoutRequest() {
        return new UserLogoutRequest();
    }

    /**
     * Create an instance of {@link UserLogoutResponse }
     * 
     */
    public UserLogoutResponse createUserLogoutResponse() {
        return new UserLogoutResponse();
    }

    /**
     * Create an instance of {@link UserLogoutFault }
     * 
     */
    public UserLogoutFault createUserLogoutFault() {
        return new UserLogoutFault();
    }

    /**
     * Create an instance of {@link CheckSessionRequest }
     * 
     */
    public CheckSessionRequest createCheckSessionRequest() {
        return new CheckSessionRequest();
    }

    /**
     * Create an instance of {@link CheckSessionResponse }
     * 
     */
    public CheckSessionResponse createCheckSessionResponse() {
        return new CheckSessionResponse();
    }

    /**
     * Create an instance of {@link CheckSessionFault }
     * 
     */
    public CheckSessionFault createCheckSessionFault() {
        return new CheckSessionFault();
    }

    /**
     * Create an instance of {@link CheckCinemaOwnerRequest }
     * 
     */
    public CheckCinemaOwnerRequest createCheckCinemaOwnerRequest() {
        return new CheckCinemaOwnerRequest();
    }

    /**
     * Create an instance of {@link CheckCinemaOwnerResponse }
     * 
     */
    public CheckCinemaOwnerResponse createCheckCinemaOwnerResponse() {
        return new CheckCinemaOwnerResponse();
    }

    /**
     * Create an instance of {@link CheckCinemaOwnerFault }
     * 
     */
    public CheckCinemaOwnerFault createCheckCinemaOwnerFault() {
        return new CheckCinemaOwnerFault();
    }

    /**
     * Create an instance of {@link CheckRestaurantOwnerRequest }
     * 
     */
    public CheckRestaurantOwnerRequest createCheckRestaurantOwnerRequest() {
        return new CheckRestaurantOwnerRequest();
    }

    /**
     * Create an instance of {@link CheckRestaurantOwnerResponse }
     * 
     */
    public CheckRestaurantOwnerResponse createCheckRestaurantOwnerResponse() {
        return new CheckRestaurantOwnerResponse();
    }

    /**
     * Create an instance of {@link CheckRestaurantOwnerFault }
     * 
     */
    public CheckRestaurantOwnerFault createCheckRestaurantOwnerFault() {
        return new CheckRestaurantOwnerFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserSignupRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userSignupRequest")
    public JAXBElement<UserSignupRequest> createUserSignupRequest(UserSignupRequest value) {
        return new JAXBElement<UserSignupRequest>(_UserSignupRequest_QNAME, UserSignupRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserSignupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userSignupResponse")
    public JAXBElement<UserSignupResponse> createUserSignupResponse(UserSignupResponse value) {
        return new JAXBElement<UserSignupResponse>(_UserSignupResponse_QNAME, UserSignupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserSignupFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userSignupFault")
    public JAXBElement<UserSignupFault> createUserSignupFault(UserSignupFault value) {
        return new JAXBElement<UserSignupFault>(_UserSignupFault_QNAME, UserSignupFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLoginRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userLoginRequest")
    public JAXBElement<UserLoginRequest> createUserLoginRequest(UserLoginRequest value) {
        return new JAXBElement<UserLoginRequest>(_UserLoginRequest_QNAME, UserLoginRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userLoginResponse")
    public JAXBElement<UserLoginResponse> createUserLoginResponse(UserLoginResponse value) {
        return new JAXBElement<UserLoginResponse>(_UserLoginResponse_QNAME, UserLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLoginFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userLoginFault")
    public JAXBElement<UserLoginFault> createUserLoginFault(UserLoginFault value) {
        return new JAXBElement<UserLoginFault>(_UserLoginFault_QNAME, UserLoginFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLogoutRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userLogoutRequest")
    public JAXBElement<UserLogoutRequest> createUserLogoutRequest(UserLogoutRequest value) {
        return new JAXBElement<UserLogoutRequest>(_UserLogoutRequest_QNAME, UserLogoutRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userLogoutResponse")
    public JAXBElement<UserLogoutResponse> createUserLogoutResponse(UserLogoutResponse value) {
        return new JAXBElement<UserLogoutResponse>(_UserLogoutResponse_QNAME, UserLogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLogoutFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "userLogoutFault")
    public JAXBElement<UserLogoutFault> createUserLogoutFault(UserLogoutFault value) {
        return new JAXBElement<UserLogoutFault>(_UserLogoutFault_QNAME, UserLogoutFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkSessionRequest")
    public JAXBElement<CheckSessionRequest> createCheckSessionRequest(CheckSessionRequest value) {
        return new JAXBElement<CheckSessionRequest>(_CheckSessionRequest_QNAME, CheckSessionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkSessionFault")
    public JAXBElement<CheckSessionFault> createCheckSessionFault(CheckSessionFault value) {
        return new JAXBElement<CheckSessionFault>(_CheckSessionFault_QNAME, CheckSessionFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCinemaOwnerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkCinemaOwnerRequest")
    public JAXBElement<CheckCinemaOwnerRequest> createCheckCinemaOwnerRequest(CheckCinemaOwnerRequest value) {
        return new JAXBElement<CheckCinemaOwnerRequest>(_CheckCinemaOwnerRequest_QNAME, CheckCinemaOwnerRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCinemaOwnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkCinemaOwnerResponse")
    public JAXBElement<CheckCinemaOwnerResponse> createCheckCinemaOwnerResponse(CheckCinemaOwnerResponse value) {
        return new JAXBElement<CheckCinemaOwnerResponse>(_CheckCinemaOwnerResponse_QNAME, CheckCinemaOwnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckCinemaOwnerFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkCinemaOwnerFault")
    public JAXBElement<CheckCinemaOwnerFault> createCheckCinemaOwnerFault(CheckCinemaOwnerFault value) {
        return new JAXBElement<CheckCinemaOwnerFault>(_CheckCinemaOwnerFault_QNAME, CheckCinemaOwnerFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRestaurantOwnerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkRestaurantOwnerRequest")
    public JAXBElement<CheckRestaurantOwnerRequest> createCheckRestaurantOwnerRequest(CheckRestaurantOwnerRequest value) {
        return new JAXBElement<CheckRestaurantOwnerRequest>(_CheckRestaurantOwnerRequest_QNAME, CheckRestaurantOwnerRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRestaurantOwnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkRestaurantOwnerResponse")
    public JAXBElement<CheckRestaurantOwnerResponse> createCheckRestaurantOwnerResponse(CheckRestaurantOwnerResponse value) {
        return new JAXBElement<CheckRestaurantOwnerResponse>(_CheckRestaurantOwnerResponse_QNAME, CheckRestaurantOwnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRestaurantOwnerFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.univaq.disim.sose.cald/accountManager", name = "checkRestaurantOwnerFault")
    public JAXBElement<CheckRestaurantOwnerFault> createCheckRestaurantOwnerFault(CheckRestaurantOwnerFault value) {
        return new JAXBElement<CheckRestaurantOwnerFault>(_CheckRestaurantOwnerFault_QNAME, CheckRestaurantOwnerFault.class, null, value);
    }

}
