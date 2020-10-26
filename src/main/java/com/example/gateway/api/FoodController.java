package com.example.gateway.api;

import com.example.gateway.dto.Food;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/food")
@NoArgsConstructor
public final class FoodController {
    private final String url = "http://10.108.133.183:8081/food";
    
    @PostMapping
    public Food createFood(@RequestBody Food Food) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Food> result =
                restTemplate.postForEntity(url, Food, Food.class);
        return result.getBody();
    }

    @GetMapping
    public List<Food> getAllFood() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Food>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Food getById(@PathVariable(value = "id") UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Food> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
}