package it.univaq.disim.sose.cald.enjoyreservation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-01T22:10:54.028+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", name = "enjoyReservationPT")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EnjoyReservationPT {

    @WebMethod
    @WebResult(name = "getRestaurantInfoResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public GetRestaurantInfoResponse getRestaurantInfo(
        @WebParam(partName = "parameters", name = "getRestaurantInfoRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        GetRestaurantInfoRequest parameters
    ) throws GetRestaurantInfoFault_Exception;

    @WebMethod
    @WebResult(name = "updateRestaurantResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public UpdateRestaurantResponse updateRestaurant(
        @WebParam(partName = "parameters", name = "updateRestaurantRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        UpdateRestaurantRequest parameters
    ) throws UpdateRestaurantFault_Exception;

    @WebMethod
    @WebResult(name = "updateCinemaResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public UpdateCinemaResponse updateCinema(
        @WebParam(partName = "parameters", name = "updateCinemaRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        UpdateCinemaRequest parameters
    ) throws UpdateCinemaFault_Exception;

    @WebMethod
    @WebResult(name = "insertRestaurantResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public InsertRestaurantResponse insertRestaurant(
        @WebParam(partName = "parameters", name = "insertRestaurantRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        InsertRestaurantRequest parameters
    ) throws InsertRestaurantFault_Exception;

    @WebMethod
    @WebResult(name = "bookingCinemaResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public BookingCinemaResponse cinemaBooking(
        @WebParam(partName = "parameters", name = "bookingCinemaRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        BookingCinemaRequest parameters
    ) throws BookingCinemaFault_Exception;

    @WebMethod
    @WebResult(name = "bookingRestaurantResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public BookingRestaurantResponse restaurantBooking(
        @WebParam(partName = "parameters", name = "bookingRestaurantRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        BookingRestaurantRequest parameters
    ) throws BookingRestaurantFault_Exception;

    @WebMethod
    @WebResult(name = "getCinemaInfoResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public GetCinemaInfoResponse getCinemaInfo(
        @WebParam(partName = "parameters", name = "getCinemaInfoRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        GetCinemaInfoRequest parameters
    ) throws GetCinemaInfoFault_Exception;

    @WebMethod
    @WebResult(name = "insertCinemaResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public InsertCinemaResponse insertCinema(
        @WebParam(partName = "parameters", name = "insertCinemaRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        InsertCinemaRequest parameters
    ) throws InsertCinemaFault_Exception;
}
