package it.univaq.disim.sose.cald.routingrequests.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {
	
	@RequestMapping(method = RequestMethod.POST)
	public void getInformation(@RequestBody String city) {
		
	}

}
