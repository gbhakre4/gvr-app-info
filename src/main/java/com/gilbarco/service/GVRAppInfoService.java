package com.gilbarco.service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gilbarco.model.CurrentHitsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *  @author Gaurav Bhakre
 *  This service gives information about application.
 */
@Controller
@RequestMapping("/app-info-service")
public class GVRAppInfoService {
	private static final AtomicInteger counter = new AtomicInteger();
	private static Logger LOGGER = Logger.getLogger(GVRAppInfoService.class.getName());
	
	/**
	 * This method checks number of calls made until now.
	 * @return String - Json string of number of calls made with current timestamp
	 */
	@RequestMapping(value = "/get-current-hits" , method = RequestMethod.GET )
	public @ResponseBody String getCurrentHits() {
		LOGGER.info("get current hits started");
		CurrentHitsResponse response = new CurrentHitsResponse();
		String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmX")
				.withZone(ZoneOffset.UTC).format(Instant.now());
		response.setTimestamp(timestamp);
		response.setCalls(counter.incrementAndGet());
		Gson gson = new GsonBuilder().create();
		LOGGER.info("get current hits ended");
		return gson.toJson(response);
	}
}