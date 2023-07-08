package com.example;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.reactivex.Flowable;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Singleton
public class CustomAuthProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthProvider.class);

    @Property(name = "security.token.basic-auth")
    Map<String,String> basicAuthConfig;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {

        if ((authenticationRequest.getIdentity().equals(basicAuthConfig.get("username"))
                && authenticationRequest.getSecret().equals(basicAuthConfig.get("password")))) {
            return Flowable.just(AuthenticationResponse.success((String) authenticationRequest.getIdentity()));
        }
        LOGGER.error("error in login{} and {}",basicAuthConfig.get("username"),basicAuthConfig.get("password"));
        return Flowable.just(new AuthenticationFailed());
    }
}
