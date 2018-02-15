package it.univaq.disim.sose.cald.enjoyreservation.business;

import java.io.IOException;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

/**
 * GoogleMaps class that allows us to receive the building coordinates through Google APIs
 */
public class GoogleMaps {
		
	public double[] foundCoordinates(String address, String city) throws ApiException, InterruptedException, IOException {
		double[] coordinates = new double[2];
		String search = address + ", " + city;
		
		/*
		 * Sets the API Key to use for authorizing requests
		 */
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCnznCl45JvKqjHRWyMn8iBkanNP6gGbAg").build();
		
		/*
		 * API call for converting addresses into geographic coordinates
		 */
		GeocodingResult[] results = GeocodingApi.geocode(context, search).await();
		
		/*
		 * Latitude and longitude are set
		 */
		coordinates[0] = results[0].geometry.viewport.northeast.lat;
		coordinates[1] = results[0].geometry.viewport.northeast.lng;
		
		return coordinates;
	}
}
