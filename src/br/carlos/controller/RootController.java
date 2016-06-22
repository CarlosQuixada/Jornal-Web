package br.carlos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	@RequestMapping("/")
	public String home(){
		return"home";
	}
	
	@RequestMapping("/home")
	public String home2(){
		return"home";
	}
}
