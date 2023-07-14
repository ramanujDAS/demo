package com.example.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.jackson.databind.JacksonDatabindMapper;
import io.micronaut.json.JsonMapper;
import io.micronaut.json.tree.JsonObject;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller("/mytest/")
@Secured("isAuthenticated()")
public class testController {

    @Inject
    ObjectMapper objectMapper;

    @Post
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public HttpResponse getDemo(Principal principal, @Body String encodedForm) throws UnsupportedEncodingException, JsonProcessingException {
        Map<String, String> formData = new HashMap<>();
        System.out.println(encodedForm);
        String[] pairs = encodedForm.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            String key = URLDecoder.decode(keyValue[0], "UTF-8");
            String value = URLDecoder.decode(keyValue[1], "UTF-8");
            formData.put(key, value);
        }
        System.out.println(formData);
       String data= objectMapper.writeValueAsString(formData);
        System.out.println(data);
        return HttpResponse.accepted();
    }
}
