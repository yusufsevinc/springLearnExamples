package com.intership.shortenerurl.controller;

import com.intership.shortenerurl.entity.Redirect;
import com.intership.shortenerurl.request.RedirectCreationRequest;
import com.intership.shortenerurl.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
public class RedirectController {

    @Autowired
    private RedirectService redirectService;


    @GetMapping("/{alias}")
    public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException {
        Redirect redirect = redirectService.getRedirect(alias);
        URI uri = new URI(redirect.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreationRequest redirectCreationRequest) {
        return ResponseEntity.ok(redirectService.createRedirect(redirectCreationRequest));
    }
}