package com.example.main;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.jackson.databind.JacksonDatabindMapper;
import io.micronaut.json.JsonMapper;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

@Controller("/mytest/")
@Secured("isAuthenticated()")
public class testController {

    @Get
    public HttpResponse getDemo(Principal principal)
    {
        System.out.println(principal.getName());
        return HttpResponse.accepted();
    }
}
