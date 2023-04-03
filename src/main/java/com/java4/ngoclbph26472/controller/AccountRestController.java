package com.java4.ngoclbph26472.controller;

import com.java4.ngoclbph26472.dto.AccountDTO;
import com.java4.ngoclbph26472.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountRestController {

    @Autowired
    AccountService service;

    @GetMapping()
    public ResponseEntity<List<AccountDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
