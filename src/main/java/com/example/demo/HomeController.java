package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"ctx","cmm","mgr","tea"})
public class HomeController {
	@Autowired HttpSession session;
	@Autowired HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String index() {
		String ctx = request.getContextPath();
		session.setAttribute("ctx", ctx);
		session.setAttribute("cmm", ctx+"/resources/cmm");
		session.setAttribute("mgr", ctx+"/resources/mgr");
		session.setAttribute("tea", ctx+"/resources/tea");
		logger.info("Welcome home!");
		return "index";
	}
	
	@GetMapping("/move/{dir}/{page}")
    public String move(@PathVariable String dir,@PathVariable String page){
        logger.info("이동한 페이지:"+dir+"/"+page);
        return String.format("%s/%s", dir,page);
    }
    
    @GetMapping("/transfer/{dir}/{sub}/{page}")
    public String transfer(@PathVariable String dir,@PathVariable String sub,@PathVariable String page){
        logger.info("이동한 페이지:"+dir+"/"+sub+"/"+page);
        return String.format("%s/%s/%s", dir,sub,page);
    }
    
    @GetMapping("/home")
    public String home() {
    	logger.info("타일즈 성공");
    	return "public";
    }
}
