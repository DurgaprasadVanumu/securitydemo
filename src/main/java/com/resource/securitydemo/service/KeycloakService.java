package com.resource.securitydemo.service;

import com.resource.securitydemo.models.LoginRequest;
import com.resource.securitydemo.models.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KeycloakService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${keycloak.host}")
    private String keycloakHost;
    @Value("${keycloak.login_api}")
    private String keycloakLoginApi;
    @Value("${keycloak.client_id}")
    private String keycloakClientId;
    @Value("${keycloak.client_secret}")
    private String keycloakClientSecret;

    public LoginResponse authenticateUser(LoginRequest loginRequest){
        String url = keycloakHost+keycloakLoginApi;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", keycloakClientId);
        formData.add("client_secret", keycloakClientSecret);
        formData.add("grant_type", "password");
        formData.add("username", loginRequest.getUsername());
        formData.add("password", loginRequest.getPassword());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);
        ResponseEntity<LoginResponse> response = restTemplate.postForEntity(url, request, LoginResponse.class);
        return response.getBody();
    }
}
