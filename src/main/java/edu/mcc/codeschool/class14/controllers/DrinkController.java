package edu.mcc.codeschool.class14.controllers;

import edu.mcc.codeschool.class14.models.Drink;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

//String in RestController is OPTIONAL
@RestController
@RequestMapping("/api/v1/drinks")
public class DrinkController {

    Logger logger = LoggerFactory.getLogger(DrinkController.class);

    List<Drink> drinks = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok(drinks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable String id){
        Optional<Drink> firstDrink = drinks.stream().filter(drink -> drink.getId().toString().equals(id)).findFirst();
        if(firstDrink.isPresent()){
            return ResponseEntity.ok(firstDrink.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable String id, @Valid @RequestBody Drink request){
        Optional<Drink> firstDrink = drinks.stream().filter(drink -> drink.getId().toString().equals(id)).findFirst();
        if(firstDrink.isPresent()){
            drinks.remove(firstDrink.get());
            drinks.add(request);
            return ResponseEntity.ok(request);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Drink> createDrink(@Valid @RequestBody Drink request){
        request.setId(UUID.randomUUID());
        drinks.add(request);
        return ResponseEntity.ok(request);
    }
}
