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

import com.gilbarco.model.JsonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/app-info-service")
public class AppInfoService {
	//private static int count=1;
	private static final AtomicInteger counter = new AtomicInteger();
	private static Logger LOGGER = Logger.getLogger(AppInfoService.class.getName());
	
	@RequestMapping(value = "/get-app-info" , method = RequestMethod.GET )
	public @ResponseBody String getAppInfo() {
		LOGGER.info("get app-info started");
		JsonResponse response = new JsonResponse();
		String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmX")
				.withZone(ZoneOffset.UTC).format(Instant.now());
		response.setTimestamp(timestamp);
		response.setCalls(counter.incrementAndGet());
		Gson gson = new GsonBuilder().create();
		LOGGER.info("get app-info ended");
		return gson.toJson(response);
	}
}