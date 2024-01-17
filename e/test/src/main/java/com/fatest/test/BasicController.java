package com.fatest.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/")
@RestController
public class BasicController {

    @GetMapping("login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("logs in?", HttpStatus.OK);
    }
    @GetMapping("success")
    public ResponseEntity<String> success(){
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
