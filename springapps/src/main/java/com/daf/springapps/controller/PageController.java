package com.daf.springapps.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daf.springapps.dto.Contact;

@Controller
public class PageController {

	
	@RequestMapping(value = {"/", "/home", "/index","/contact"}, method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
		model.addAttribute("contact", new Contact()); 
		return mav;
	}
	
	@RequestMapping(value = "/contactme", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("contact")Contact contact, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
       
        model.addAttribute("fname", contact.getFname());
        model.addAttribute("lname",contact.getLname());
        model.addAttribute("email", contact.getEmail());
        model.addAttribute("phone", contact.getPhone());
        model.addAttribute("message",contact.getMessage());
       
        return "ContactView";
    }
	
}
