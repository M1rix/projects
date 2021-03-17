package com.example.accounts.controller;

import com.example.accounts.domain.Account;
import com.example.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String greeting(Map<String,Object> model) {
                return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String,Object> model) {
        Iterable<Account> users = accountRepository.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String username,@RequestParam String password, Map<String,Object> model){
        Account user = new Account(username, password);
        accountRepository.save(user);

        Iterable<Account> users = accountRepository.findAll();

        model.put("users", users);

        return "main";
    }
}
