package it.univaq.disim.sose.cald.enjoyreservation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-14T17:25:04.829+01:00
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
    @WebResult(name = "accountSessionResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public AccountSessionResponse accountSession(
        @WebParam(partName = "parameters", name = "accountSessionRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        AccountSessionRequest parameters
    ) throws AccountSessionFault_Exception;

    @WebMethod
    @WebResult(name = "restaurantOwnerResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public RestaurantOwnerResponse checkRestaurantOwner(
        @WebParam(partName = "parameters", name = "restaurantOwnerRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        RestaurantOwnerRequest parameters
    ) throws RestaurantOwnerFault_Exception;

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
    @WebResult(name = "accountLoginResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public AccountLoginResponse userLogin(
        @WebParam(partName = "parameters", name = "accountLoginRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        AccountLoginRequest parameters
    ) throws AccountLoginFault_Exception;

    @WebMethod
    @WebResult(name = "getAllInfoResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public GetAllInfoResponse getAllInfo(
        @WebParam(partName = "parameters", name = "getAllInfoRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        GetAllInfoRequest parameters
    ) throws GetAllInfoFault_Exception;

    @WebMethod
    @WebResult(name = "getSingleCinemaInfoResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public GetSingleCinemaInfoResponse getSingleCinemaInfo(
        @WebParam(partName = "parameters", name = "getSingleCinemaInfoRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        GetSingleCinemaInfoRequest parameters
    ) throws GetCinemaInfoFault_Exception;

    @WebMethod
    @WebResult(name = "cinemaOwnerResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public CinemaOwnerResponse checkCinemaOwner(
        @WebParam(partName = "parameters", name = "cinemaOwnerRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        CinemaOwnerRequest parameters
    ) throws CinemaOwnerFault_Exception;

    @WebMethod
    @WebResult(name = "deleteRestaurantResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public DeleteRestaurantResponse restaurantDelete(
        @WebParam(partName = "parameters", name = "deleteRestaurantRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        DeleteRestaurantRequest parameters
    ) throws DeleteRestaurantFault_Exception;

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
    @WebResult(name = "accountLogoutResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public AccountLogoutResponse userLogout(
        @WebParam(partName = "parameters", name = "accountLogoutRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        AccountLogoutRequest parameters
    ) throws AccountLogoutFault_Exception;

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
    @WebResult(name = "accountSignupResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public AccountSignupResponse userSignup(
        @WebParam(partName = "parameters", name = "accountSignupRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        AccountSignupRequest parameters
    ) throws AccountSignupFault_Exception;

    @WebMethod
    @WebResult(name = "deleteCinemaResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public DeleteCinemaResponse cinemaDelete(
        @WebParam(partName = "parameters", name = "deleteCinemaRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        DeleteCinemaRequest parameters
    ) throws DeleteCinemaFault_Exception;

    @WebMethod
    @WebResult(name = "getSingleRestaurantInfoResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public GetSingleRestaurantInfoResponse getSingleRestaurantInfo(
        @WebParam(partName = "parameters", name = "getSingleRestaurantInfoRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        GetSingleRestaurantInfoRequest parameters
    ) throws GetRestaurantInfoFault_Exception;

    @WebMethod
    @WebResult(name = "insertCinemaResponse", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation", partName = "parameters")
    public InsertCinemaResponse insertCinema(
        @WebParam(partName = "parameters", name = "insertCinemaRequest", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
        InsertCinemaRequest parameters
    ) throws InsertCinemaFault_Exception;
}
