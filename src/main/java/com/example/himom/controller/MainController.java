package com.example.himom.controller;


import com.example.himom.model.Account;
import com.example.himom.service.AccountService;
import com.example.himom.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final AccountService accountService = new AccountServiceImpl();

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/listAccount")
    public ModelAndView helloServlet() {
        ModelAndView modelAndView = new ModelAndView("account/list");

        List<Account> allAccount =  accountService.findAllAccounts();
        modelAndView.addObject("allAccount", allAccount);

        return modelAndView;
    }



}