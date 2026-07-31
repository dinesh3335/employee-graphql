package com.dinesh.graphql.employeegraphql.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @QueryMapping
    public String hello() {

        return "Welcome to GraphQL";

    }

}
