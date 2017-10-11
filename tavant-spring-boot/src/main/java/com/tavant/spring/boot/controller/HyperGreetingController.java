package com.tavant.spring.boot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.model.HyperGreeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HyperGreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/hypergreeting")
    public HttpEntity<HyperGreeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

    	HyperGreeting greeting = new HyperGreeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(HyperGreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<HyperGreeting>(greeting, HttpStatus.OK);
    }
}
