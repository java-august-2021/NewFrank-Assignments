package com.code.eventbelt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.eventbelt.Models.Event;
import com.code.eventbelt.Repository.EventRepo;

@Service
public class EventService {
	@Autowired
	private EventRepo evReop;
	
	public Event createEvent(Event event) {
		return evReop.save(event);
	}
}
