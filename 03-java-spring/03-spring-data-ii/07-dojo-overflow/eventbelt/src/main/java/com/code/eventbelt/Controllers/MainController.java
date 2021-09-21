package com.code.eventbelt.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.code.eventbelt.Models.Event;
import com.code.eventbelt.Services.EventService;

@Controller
public class MainController {
	@Autowired
	private EventService eServ;
	
	@GetMapping("")
	public String index(@ModelAttribute("newEvent") Event event) {
		return "event.jsp";
	}
	
	@PostMapping("/create")
	public String createAnEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result) {
		if(result.hasErrors()) {
			return "event.jsp";
		}
		
		eServ.createEvent(event);
		return "redirect:/";
	}
}
