package com.example.gateway.api;

import com.example.gateway.dto.Deity;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deity")
@NoArgsConstructor
public final class DeityController {
    private final String url = "http://10.99.144.4:8083/deity";

    @PostMapping
    public Deity createDeity(@RequestBody Deity Deity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Deity> result =
                restTemplate.postForEntity(url, Deity, Deity.class);
        return result.getBody();
    }

    @GetMapping
    public List<Deity> getAllDeity() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Deity>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Deity getById(@PathVariable(value = "id") UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Deity> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
}