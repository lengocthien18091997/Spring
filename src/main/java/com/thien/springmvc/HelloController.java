package com.thien.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thien.model.Person;

@Controller
@RequestMapping("/admin")
public class HelloController {
	
	@Autowired
	@Qualifier("person2")
	private Person person;
	
	@RequestMapping(value= {"/hello", "/say/hello"}, method=RequestMethod.GET)
	public String sayHello(ModelMap map) {
//		map.addAttribute("msg", "Thien");
		map.addAttribute("person", person);
		return "hello";
	}
	
	@RequestMapping(value= {"/say/hello2"}, method=RequestMethod.GET)
	public ModelAndView sayHello(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		request.setAttribute("person", person);
		return new ModelAndView("hello");
		
	}
}
