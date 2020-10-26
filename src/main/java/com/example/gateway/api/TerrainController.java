package com.example.gateway.api;

import com.example.gateway.dto.Terrain;
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
@RequestMapping("/terrain")
@NoArgsConstructor
public final class TerrainController {

    private final String url = "http://10.107.230.201:8084/terrain";

    @PostMapping
    public Terrain createTerrain(@RequestBody Terrain Terrain) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Terrain> result =
                restTemplate.postForEntity(url, Terrain, Terrain.class);
        return result.getBody();
    }

    @GetMapping
    public List<Terrain> getAllTerrain() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Terrain>> result =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }

    @GetMapping("{id}")
    public Terrain getById(@PathVariable(value = "id") UUID id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Terrain> result =
                restTemplate.exchange(url + "/" + id.toString(),
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return result.getBody();
    }
}