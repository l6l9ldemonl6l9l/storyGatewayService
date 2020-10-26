package com.example.gateway.api;

import com.example.gateway.dto.Fox;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fox")
@NoArgsConstructor
public final class FoxController {

    private final String url = "http://10.99.19.178:8085/fox";

    @PostMapping
    public Fox createFox(@RequestBody Fox Fox) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Fox> result =
                restTemplate.postForEntity(url, Fox, Fox.class);
        return result.getBody();
    }

    @GetMapping
    public List<Fox> getAllFox() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Fox>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Fox getById(@PathVariable(value = "id") UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Fox> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
}