package it.univaq.disim.sose.cald.enjoyreservation.business;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

public class GoogleMaps {
	
	private static Logger LOGGER = LoggerFactory.getLogger(GoogleMaps.class);
	
	public double[] foundCoordinates(String address, String city) throws ApiException, InterruptedException, IOException {
		double[] coordinates = new double[2];
		String search = address + ", " + city;
		
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyCnznCl45JvKqjHRWyMn8iBkanNP6gGbAg").build();
		GeocodingResult[] results;
		results = GeocodingApi.geocode(context, search).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		coordinates[0] = results[0].geometry.viewport.northeast.lat;
		coordinates[1] = results[0].geometry.viewport.northeast.lng;
		
		LOGGER.info("RISULTATO GOOGLE"+gson.toJson(results[0].geometry.viewport.northeast.lat));
		LOGGER.info("RISULTATO GOOGLE"+gson.toJson(results[0].geometry.viewport.northeast.lng));
		return coordinates;
	}
}
