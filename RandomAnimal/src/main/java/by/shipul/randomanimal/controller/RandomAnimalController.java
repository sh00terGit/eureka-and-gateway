package by.shipul.randomanimal.controller;

import by.shipul.randomanimal.dao.AnimalDao;
import by.shipul.randomanimal.model.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomAnimalController {

    private final AnimalDao animalDao;

    public RandomAnimalController(AnimalDao animalDao){
        this.animalDao=animalDao;
    }

    @GetMapping("/random")
    public Animal randomAnimal(){
        Animal animal=animalDao.random();
        System.out.println(animal);
        return animal;
    }
}
