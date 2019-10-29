package com.smokies.smokies.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smokies.smokies.Event;
import com.smokies.smokies.Events;

@RestController
public class SmokiesController {
	static int i = 0;
	static Events events = new Events();

	@RequestMapping("/")
	public String index() {
		return "[]";
	}

	String response = "{\r\n" + "	\"event\": [{\r\n" + "			\"title\": \"an event\",\r\n"
			+ "			\"id\": \"1\",\r\n" + "			\"description\": \"something really cool\"\r\n" + "		},\r\n"
			+ "		{\r\n" + "			\"title\": \"another event\",\r\n" + "			\"id\": \"2\",\r\n"
			+ "			\"description\": \"something even cooler\"\r\n" + "		}\r\n" + "	]\r\n" + "}";

	@RequestMapping(value = "/event", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Events event(@RequestBody Event event) {
		System.out.println(event);
		Event evnt[] = events.getEvent();

		int len = 1;
		if (evnt != null)
			if (evnt.length > 0)
				len = evnt.length;

		Event newEvent[] = new Event[len + 1];
		newEvent = evnt;
		newEvent[newEvent.length] = event;
		events.setEvent(newEvent);
		return events;
	}
}