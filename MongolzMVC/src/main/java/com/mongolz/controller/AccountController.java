package com.mongolz.controller;

import javax.validation.Valid;

import com.mongolz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
 
 	@RequestMapping({"","/all"})
	public String list(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "accounts";
	}
	
}
