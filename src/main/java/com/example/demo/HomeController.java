package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
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
    
}
