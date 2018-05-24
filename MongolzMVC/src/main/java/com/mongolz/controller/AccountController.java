package com.mongolz.controller;

import com.mongolz.domain.User;
import com.mongolz.service.AccountService;
import com.mongolz.service.UserCredentialsService;
import com.mongolz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    UserCredentialsService credentialsService;


    @RequestMapping({"", "/all"})
    public String list(Model model) {

        if(credentialsService.LoggedIn()){

            User user = credentialsService.getUser();
            System.out.println("Id:"+user.getId()); //End user object orj irne

            model.addAttribute("accounts", accountService.findByUser(user.getId()));
            return "accounts";
        } else {
            return "redirect:/login";
        }


    }

}
