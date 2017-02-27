package kr.ac.subway.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.subway.model.Subway;
import kr.ac.subway.service.SubwayService;

@Controller
public class SubwayController {

	private SubwayService service;
	public static boolean flag=false;
	
	@Autowired
	public void setSubwayService(SubwayService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/login")
	public String DoLogin(Model model)
	{
		return "login";
	}
	
	@RequestMapping("/subway")
	public String Gosubway(Model model)
	{
		if(flag==true)
		{
			return "subway";
		}
		else
			return "falseAccess";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String DoTemperate(HttpServletRequest request, HttpServletResponse response, Model model) //throws ServletException, IOException 
	{
		String temperature = request.getParameter("field1").toString();
		String humidity = request.getParameter("field2").toString();
		Date dateup = new Date();
		String date = dateup.toString();
		
		System.out.println("현재 온도 : "+temperature);
		System.out.println("현재 습도 : "+humidity);
		System.out.println("현재 시간 : "+date);
		
		Subway subway = new Subway(date, temperature, humidity);
		service.insert(subway);
		
		List<Subway> subwayInfo = service.getCurrent();
		model.addAttribute("subwayInfo", subwayInfo);
		//request.setAttribute("subwayInfo" , subwayInfo);
		return "subwayInfo";
		//String page="/WEB-INF/views/subwayInfo.jsp";
		//RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		//dispatcher.forward(request, response);
	}

}
