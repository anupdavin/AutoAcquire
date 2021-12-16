package com.code.mvcapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvcapp.model.AutoAcquire;
import com.code.mvcapp.service.AutoAcquireService;
import com.code.mvcapp.service.validation;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	AutoAcquireService autoAcquireService;

	//Logger
	public static Logger log = Logger.getLogger(AppController.class.getName());

	//BasicConfigurator.configure();
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model) {
		ModelAndView mv = new ModelAndView();
		List<AutoAcquire> list = autoAcquireService.listAllAutoAcquire();
		model.addAttribute("allautoacquire", list);
		mv.setViewName("allList");
		return mv;
	}
	@RequestMapping(value = { "/accept/{id}" }, method = RequestMethod.GET)
	public String editAccept(@PathVariable Long id, ModelMap model) {
		AutoAcquire autoacquire = autoAcquireService.getAutoAcquire(id);
		model.addAttribute("autoacquire", autoacquire);
		model.addAttribute("edit", true);
		return "acceptmsisdn";
	}
	@RequestMapping(value = { "/acceptvalidation/{id}" }, method = RequestMethod.GET)
	public ModelAndView updatestatus(@PathVariable Long id, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		validation v=new validation();
		AutoAcquire autoacquire = autoAcquireService.getAutoAcquire(id);
		autoacquire.setStatus("ACCEPTED");
		String result=v.validateParameters(autoacquire);
		model.addAttribute("autoacquire", autoacquire);
		if(result.equalsIgnoreCase("SUCCESS")) {
		autoAcquireService.updateAutoAcquire(id,autoacquire);
		model.addAttribute("result", "Accepted");

		if (autoacquire.getGender().equalsIgnoreCase("M")) {
			log.info("Hello Sir your number "+id+ " is activatived");
		} else if (autoacquire.getGender().equalsIgnoreCase("F")) {
			log.info("Hello Madam your number "+id+" is activatived");
		}
		
		List<AutoAcquire> list = autoAcquireService.listAllAutoAcquire();
		model.addAttribute("allautoacquire", list);
		mv.setViewName("allList");
		}else {
		model.addAttribute("result", result);
		mv.setViewName("acceptmsisdn");
		}
		//log.info("result"+result);

		return mv;
	}
	@RequestMapping(value = { "/reject/{id}" }, method = RequestMethod.GET)
	public ModelAndView updaterejectstatus(@PathVariable Long id, ModelMap model) {
		ModelAndView mv = new ModelAndView();
		AutoAcquire autoacquire = autoAcquireService.getAutoAcquire(id);
		autoacquire.setStatus("REJECTED");
		model.addAttribute("autoacquire", autoacquire);
		autoAcquireService.updateAutoAcquire(id,autoacquire);
		model.addAttribute("result", "Rejected");
		if (autoacquire.getGender().equalsIgnoreCase("M")) {
			log.info("Hello Sir your number "+id+ " is Rejected");
		} else if (autoacquire.getGender().equalsIgnoreCase("F")) {
			log.info("Hello Madam your number "+id+" is Rejected");
		}
		
		List<AutoAcquire> list = autoAcquireService.listAllAutoAcquire();
		model.addAttribute("allautoacquire", list);
		mv.setViewName("allList");
		return mv;
	}
	
	
}
