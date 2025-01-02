package com.example.himom.controller;

import com.example.himom.model.Account;
import com.example.himom.service.AccountService;
import com.example.himom.service.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService = new AccountServiceImpl();


    @GetMapping("/listAccount")
    public ModelAndView allAccountsByAdmin() {
        ModelAndView modelAndView = new ModelAndView("account/listAccount");
        List<Account> allAccount = accountService.findAllAccounts();
        modelAndView.addObject("allAccount", allAccount);
        return modelAndView;
    }


    @GetMapping("/errorPage")
    public ModelAndView showErrorPage() {
        return new ModelAndView("errorPage");
    }


    @GetMapping("/registerAccountForm")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "account/registerAccountForm";
    }

    @PostMapping("/registerAccountAction")
    public String registerAccountAction(@ModelAttribute Account account, Model model) {
        // Validate and save account
        accountService.createNewAccount(account);
        return "redirect:/listAccount";
    }


    @GetMapping("/updateAccountForm/{accountId}")
    public String showUpdateAccountForm(@PathVariable("accountId") String accountId, Model model) {
        Account account = accountService.getAccountByAccountId(accountId);
        if (account == null) {
            return "redirect:/errorPage";
        }
        model.addAttribute("account", account);
        return "account/updateAccountForm";
    }

    @PostMapping("/updateAccountAction")
    public String updateAccountAction(@ModelAttribute Account account, @RequestParam(required = false) String newPassword) {
        Account existingAccount = accountService.getAccountByAccountId(account.getAccountId());
        if (existingAccount != null) {
            account.setAccountPassword(newPassword != null && !newPassword.isEmpty() 
                ? newPassword 
                : existingAccount.getAccountPassword());
            accountService.updateAccount(account);
        }
        return "redirect:/listAccount";
    }

    @GetMapping("/detailsAccountForm/{accountId}")
    public String showDetailsAccountForm(@PathVariable("accountId") String accountId, Model model) {
        Account account = accountService.getAccountByAccountId(accountId);
        if (account == null) {
            return "redirect:/errorPage";
        }
        model.addAttribute("account", account);
        return "account/detailsAccountForm";
    }


    @GetMapping("/deleteAccountForm/{accountId}")
    public String showDeleteAccountForm(@PathVariable("accountId") String accountId, Model model) {
        Account account = accountService.getAccountByAccountId(accountId);
        if (account == null) {
            return "redirect:/errorPage";
        }
        model.addAttribute("account", account);
        return "account/deleteAccountForm";
    }


    @PostMapping("/deleteAccountAction")
    public String deleteAccountAction(@RequestParam String accountId) {
        accountService.deleteAccountById(accountId);
        return "redirect:/listAccount";
    }


    @GetMapping("/retakeAccountByEmailForm")
    public String showRetakeAccountByEmailForm(Model model) {
        model.addAttribute("account", new Account());
        return "account/retakeAccountByEmailForm";
    }


    @PostMapping("/retakeAccountByEmailFormAction")
    public String retakeAccountByEmailFormAction(@ModelAttribute("account") Account account, Model model) {
        System.out.println("Checking email in retakeAccountByEmailFormAction: " + account.getAccountEmail());
        boolean isRightEmail = accountService.checkRightEmailToRetakeAccount(account.getAccountEmail());
        System.out.println("isRightEmail: " + isRightEmail);

        if (isRightEmail) {
            return "redirect:/changePasswordForm?email=" + account.getAccountEmail();
        } else {
            model.addAttribute("errorMessage", "No account found with the provided email.");
            return "account/retakeAccountByEmailForm";
        }
    }



    @GetMapping("/changePasswordForm")
    public String showChangePasswordForm(@RequestParam("email") String accountEmail, Model model) {
        Account account = accountService.getAccountByAccountEmail(accountEmail);
        if (account != null) {
            model.addAttribute("email", accountEmail);
            return "account/changePasswordForm";
        }
        return "redirect:/listAccount";
    }

    @PostMapping("/changePasswordAction")
    public String changePasswordAction(@RequestParam String email, @RequestParam String newPassword) {
        Account account = accountService.getAccountByAccountEmail(email);
        if (account != null) {
            account.setAccountPassword(newPassword);
            accountService.updateAccount(account);
        }
        return "redirect:/listAccount";
    }

    @PostMapping("/updateAccountPasswordAction")
    public String updateAccountPasswordAction(@RequestParam("accountEmail") String accountEmail,
                                              @RequestParam("newPassword") String newPassword) {
        Account account = accountService.getAccountByAccountEmail(accountEmail);
        if (account != null) {
            account.setAccountPassword(newPassword);
            accountService.updateAccount(account);
            return "redirect:/listAccount";
        }
        return "redirect:/retakeAccountByEmailForm";
    }

}
