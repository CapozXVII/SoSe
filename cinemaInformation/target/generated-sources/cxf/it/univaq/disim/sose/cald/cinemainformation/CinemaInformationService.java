package it.univaq.disim.sose.cald.cinemainformation;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-10T14:16:21.084+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "CinemaInformationService", 
                  wsdlLocation = "file:/C:/Users/davi9/Desktop/Davide/università/4%20anno/sose/Soseproject/trunk/SoSe/cinemaInformation/src/main/resources/cinemaInformation.wsdl",
                  targetNamespace = "http://it.univaq.disim.sose.cald/cinemaInformation") 
public class CinemaInformationService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://it.univaq.disim.sose.cald/cinemaInformation", "CinemaInformationService");
    public final static QName CinemaInformationPort = new QName("http://it.univaq.disim.sose.cald/cinemaInformation", "cinemaInformationPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/davi9/Desktop/Davide/università/4%20anno/sose/Soseproject/trunk/SoSe/cinemaInformation/src/main/resources/cinemaInformation.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CinemaInformationService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/davi9/Desktop/Davide/università/4%20anno/sose/Soseproject/trunk/SoSe/cinemaInformation/src/main/resources/cinemaInformation.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CinemaInformationService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CinemaInformationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CinemaInformationService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CinemaInformationService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CinemaInformationService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CinemaInformationService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CinemaInformationPT
     */
    @WebEndpoint(name = "cinemaInformationPort")
    public CinemaInformationPT getCinemaInformationPort() {
        return super.getPort(CinemaInformationPort, CinemaInformationPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CinemaInformationPT
     */
    @WebEndpoint(name = "cinemaInformationPort")
    public CinemaInformationPT getCinemaInformationPort(WebServiceFeature... features) {
        return super.getPort(CinemaInformationPort, CinemaInformationPT.class, features);
    }

}
