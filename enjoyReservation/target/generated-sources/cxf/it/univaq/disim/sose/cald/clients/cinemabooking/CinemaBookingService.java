package it.univaq.disim.sose.cald.clients.cinemabooking;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-03T15:05:52.025+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "CinemaBookingService", 
                  wsdlLocation = "file:/Users/Luca/Documents/Università/Magistrale/Primo%20Anno/Primo%20Semestre/Service-Oriented%20Software%20Engineering/Progetto/SoSe/enjoyreservation/src/main/resources/clients/cinemaBooking.wsdl",
                  targetNamespace = "http://it.univaq.disim.sose.cald/cinemaBooking") 
public class CinemaBookingService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://it.univaq.disim.sose.cald/cinemaBooking", "CinemaBookingService");
    public final static QName CinemaBookingPort = new QName("http://it.univaq.disim.sose.cald/cinemaBooking", "cinemaBookingPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/Luca/Documents/Università/Magistrale/Primo%20Anno/Primo%20Semestre/Service-Oriented%20Software%20Engineering/Progetto/SoSe/enjoyreservation/src/main/resources/clients/cinemaBooking.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CinemaBookingService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/Luca/Documents/Università/Magistrale/Primo%20Anno/Primo%20Semestre/Service-Oriented%20Software%20Engineering/Progetto/SoSe/enjoyreservation/src/main/resources/clients/cinemaBooking.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CinemaBookingService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CinemaBookingService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CinemaBookingService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CinemaBookingService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CinemaBookingService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CinemaBookingService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CinemaBookingPT
     */
    @WebEndpoint(name = "cinemaBookingPort")
    public CinemaBookingPT getCinemaBookingPort() {
        return super.getPort(CinemaBookingPort, CinemaBookingPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CinemaBookingPT
     */
    @WebEndpoint(name = "cinemaBookingPort")
    public CinemaBookingPT getCinemaBookingPort(WebServiceFeature... features) {
        return super.getPort(CinemaBookingPort, CinemaBookingPT.class, features);
    }

}