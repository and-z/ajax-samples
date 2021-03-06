package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class NoAjaxThymeController {
	
	@RequestMapping(value="/userNoAjaxThyme",method=RequestMethod.GET)
	public String showFormNoAjax(Model model){
		model.addAttribute("user", new User());
		return "pages/01-userForm";
	}
	
	@RequestMapping(value="/userNoAjaxThyme",method=RequestMethod.POST)
	public String processFormNoAjax(Model model, @Valid User user, BindingResult result ){
		if(result.hasErrors()) {
			return "pages/01-userForm";
		} 
		else {
			return "success";
		}
	}
	
}
