package com.gabriel.catservice.resource;

import com.gabriel.catservice.model.CatBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/catbreed")
public class CatBreedResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/breeds")
    public List<CatBreed> getCatBreeds() {
        ResponseEntity<CatBreed[]> responseEntity =
                restTemplate.getForEntity("https://api.thecatapi.com/v1/breeds" + "?api_key=" + apiKey, CatBreed[].class);
        CatBreed[] catBreedsArray = responseEntity.getBody();
        return Arrays.asList(catBreedsArray);
    }

    @RequestMapping("/{breedId}")
    public CatBreed getCatBreed(@PathVariable("breedId") String breedId) {
        ResponseEntity<CatBreed[]> responseEntity =
                restTemplate.getForEntity("https://api.thecatapi.com/v1/images/search?api_key=" + apiKey + "&breed_id=" + breedId, CatBreed[].class);
        CatBreed[] catBreedsArray = responseEntity.getBody();
        CatBreed catBreed = catBreedsArray[0];
        return catBreed;
    }

}
