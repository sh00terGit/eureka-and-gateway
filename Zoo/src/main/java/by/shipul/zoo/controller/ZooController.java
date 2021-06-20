package by.shipul.zoo.controller;

import by.shipul.zoo.RandomAnimalClient;
import by.shipul.zoo.model.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ZooController {

    private final RandomAnimalClient randomAnimalClient;

    @GetMapping("/animals/any")
    ResponseEntity<Animal> seeAnyAnimal(){
        return randomAnimalClient.random();
    }
}
