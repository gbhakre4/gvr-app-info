package com.gilbarco.service;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;

import com.gilbarco.model.CurrentHitsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GVRAppInfoServiceTest {
	private GVRAppInfoService service = new GVRAppInfoService();
	private Gson gson = new GsonBuilder().create();
	
	@Test
	public void getCurrentHitsTest() {
		CurrentHitsResponse response = gson.fromJson(service.getCurrentHits(),CurrentHitsResponse.class);
		DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmX").withZone(ZoneOffset.UTC).parse(response.getTimestamp());
		Assert.assertTrue(response.getCalls() == 1);
	}
	
	@Test
	public void getCurrentHitsAfterMultipleHitsTest() {
		service.getCurrentHits();
		CurrentHitsResponse response = gson.fromJson(service.getCurrentHits(),CurrentHitsResponse.class);
		Assert.assertTrue(response.getCalls() > 1);
	}
}
