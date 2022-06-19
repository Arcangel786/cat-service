package com.gabriel.catservice.resource;

import com.gabriel.catservice.model.Image;
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
@RequestMapping("/images")
public class ImageResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/search")
    public List<Image> getImages() {
        ResponseEntity<Image[]> responseEntity =
                restTemplate.getForEntity("https://api.thecatapi.com/v1/images/search" + "?api_key=" + apiKey, Image[].class);
        Image[] imageArray = responseEntity.getBody();
        return Arrays.asList(imageArray);
    }

    @RequestMapping("/{imageId}")
    public Image getCatBreed(@PathVariable("imageId") String imageId) {
        Image image =
                restTemplate.getForObject("https://api.thecatapi.com/v1/images/search" + imageId + "?api_key=" + apiKey, Image.class);

        return image;
    }
}
