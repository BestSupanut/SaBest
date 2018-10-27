package com.cpe.wongnai.controller;


import com.cpe.wongnai.repository.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cpe.wongnai.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.jar.JarException;
import java.util.stream.Collectors;
import org.springframework.boot.json.JsonParseException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Menucontroller {
    @Autowired
    private InfoMenurepository InfoMenurepository;
    @Autowired
    private Ingredientrepository Ingredientrepository;
    @Autowired
    private Storyrepository Storyrepository;
    @Autowired
    private Nutritionrepository Nutritionrepository;

    @PostMapping("/menu/create/{stext}/{text}/{protein}/{carbohydrate}/{vitamin}/{fruit}/{fat}")
    public InfoMenu createMenu(@PathVariable String stext,@PathVariable String text,
    @PathVariable String protein,@PathVariable String carbohydrate,
    @PathVariable String vitamin,@PathVariable String fruit,
    @PathVariable String fat,@RequestBody String dataMenu
    )throws JsonParseException,IOException
        {
            final String decoded = URLDecoder.decode(dataMenu, "UTF-8");
        dataMenu = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataMenu);
        JsonNode jsoncal = actualObj.get("cal");

           
        Nutrition nutrition = new Nutrition();   
            nutrition.setProtein(protein);
            nutrition.setCarbohydrate(carbohydrate);
            nutrition.setVitamin(vitamin);
            nutrition.setFruit(fruit);
            nutrition.setFat(fat);
            Nutritionrepository.save(nutrition);

        Story story = new Story();
            story.setStext(stext);
            Storyrepository.save(story);

        InfoMenu infomenu = new InfoMenu();
            infomenu.setCal(jsoncal.asDouble());
            
            infomenu.setStext(Storyrepository.findByStext(stext));
            infomenu.setText(Ingredientrepository.findByText(text));
            infomenu.setNutrition(Nutritionrepository.findByProtein(protein));
            infomenu.setNutrition(Nutritionrepository.findByCarbohydrate(carbohydrate));
            infomenu.setNutrition(Nutritionrepository.findByVitamin(vitamin));
            infomenu.setNutrition(Nutritionrepository.findByFruit(fruit));
            infomenu.setNutrition(Nutritionrepository.findByFat(fat));
            
            return InfoMenurepository.save(infomenu);
    }

    @GetMapping("/menu")
    public List<InfoMenu> showAllMenu() {
        return InfoMenurepository.findAll().stream().collect(Collectors.toList());
        }
    
   @GetMapping("/menu/{Mid}")
    public InfoMenu ShowMenu(@PathVariable Long Mid) {
        Optional<InfoMenu> menu = InfoMenurepository.findById(Mid);
        return menu.get();
    }
    @GetMapping("/story")
    public List<Story> showAllStory() {
        return Storyrepository.findAll().stream().collect(Collectors.toList());
        }

    @GetMapping("/story/{Sid}")
        public Story ShowStoryId(@PathVariable Long Sid) {
            Optional<Story> story = Storyrepository.findById(Sid);
            return story.get();
        }
    @GetMapping("/ingredient")
    public List<Ingredient> ShowIngredient() {
            return Ingredientrepository.findAll().stream().collect(Collectors.toList());
        }
    @GetMapping("/nutrition")
        public List<Nutrition> showNutrition() {
                return Nutritionrepository.findAll().stream().collect(Collectors.toList());
            }
    }
  