package kr.ac.subway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.subway.service.SubwayService;

@Controller
public class SubwayController {

//	private SubwayService service;
//	
//	@Autowired
//	public void setSubwayService(SubwayService service)
//	{
//		this.service = service;
//	}
	
	@RequestMapping("/login")
	public String DoLogin(Model model)
	{
		return "login";
	}
	
	@RequestMapping("/subway")
	public String Gosubway(Model model)
	{
		return "subway";
	}
}
