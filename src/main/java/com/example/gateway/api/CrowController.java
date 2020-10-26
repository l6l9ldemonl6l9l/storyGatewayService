package com.example.gateway.api;

import com.example.gateway.dto.Crow;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/crow")
@NoArgsConstructor
public final class CrowController {

    private final String url = "http://10.100.60.224:8082/crow";

    @PostMapping
    public Crow createCrow(@RequestBody Crow crow) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Crow> result =
                restTemplate.postForEntity(url, crow, Crow.class);
        return result.getBody();
    }

    @GetMapping
    public List<Crow> getAllCrow() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Crow>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Crow getById(@PathVariable(value = "id") UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Crow> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
}