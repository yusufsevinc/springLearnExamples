package com.yusufSevinc.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/message")
public class MessageController {

    @GetMapping
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Merhaba");
    }
}
