package it.univaq.disim.sose.cald.clients.restaurantinserting;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-09T15:04:14.947+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "RestaurantInsertingService", 
                  wsdlLocation = "file:/Users/Luca/Documents/Università/Magistrale/Primo%20Anno/Primo%20Semestre/Service-Oriented%20Software%20Engineering/Progetto/SoSe/enjoyreservation/src/main/resources/clients/restaurantInserting.wsdl",
                  targetNamespace = "http://it.univaq.disim.sose.cald/restaurantInserting") 
public class RestaurantInsertingService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "RestaurantInsertingService");
    public final static QName RestaurantPort = new QName("http://it.univaq.disim.sose.cald/restaurantInserting", "restaurantPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/Luca/Documents/Università/Magistrale/Primo%20Anno/Primo%20Semestre/Service-Oriented%20Software%20Engineering/Progetto/SoSe/enjoyreservation/src/main/resources/clients/restaurantInserting.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RestaurantInsertingService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/Luca/Documents/Università/Magistrale/Primo%20Anno/Primo%20Semestre/Service-Oriented%20Software%20Engineering/Progetto/SoSe/enjoyreservation/src/main/resources/clients/restaurantInserting.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RestaurantInsertingService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RestaurantInsertingService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RestaurantInsertingService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public RestaurantInsertingService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RestaurantInsertingService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RestaurantInsertingService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns RestaurantPT
     */
    @WebEndpoint(name = "restaurantPort")
    public RestaurantPT getRestaurantPort() {
        return super.getPort(RestaurantPort, RestaurantPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RestaurantPT
     */
    @WebEndpoint(name = "restaurantPort")
    public RestaurantPT getRestaurantPort(WebServiceFeature... features) {
        return super.getPort(RestaurantPort, RestaurantPT.class, features);
    }

}
