package com.cpe.wongnai;
import java.util.stream.Stream;
import com.cpe.wongnai.entity.*;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.cpe.wongnai.repository.*;

@SpringBootApplication
public class WongnaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WongnaiApplication.class, args);
	}

	@Bean
    ApplicationRunner init(Ingredientrepository ingredientrepository,
    InfoMenurepository infomenurepository,Nutritionrepository nutritionrepository,Storyrepository storyrepository) {
        return args -> {

            
             //set ingredient
             Stream.of("แครอท,ไข่ต้ม,หัวหอม,กะหล่ำ","หมูสับ,ใบกะเพรา,ข้าว,ไข่ดาว").forEach(ingredient_of_food-> {
                Ingredient ingredient= new Ingredient();
                ingredient.setText(ingredient_of_food);
                ingredientrepository.save(ingredient);

            });
           
            //set story
            Stream.of("เมื่อพูดถึง สลัด  เรามักนึกถึงเมนูผักเพื่อสุขภาพ หลายคนเลือกทาน สลัด เพื่อควบคุมน้ำหนักและระบบขับถ่ายที่ดีและมีใครทราบไหมค่ะว่าคำว่า “สลัด”มีที่มาที่ไปอย่างไรวันนี้เรามีบอกค่ะ คำว่า”สลัด” Salads มาจากภาษาฝรั่งเศส คือคำว่า Salada ซึ่งมีความหมายตรงกับภาษาละติน Salad ที่แปลว่า Salty หรือแปลว่ารสเค็มนั้นเอง ดังนั้นจึงเขียนได้อีกชื่อหนึ่งว่า Salted Herbs หรือ Herbasalta ซึ่งแปลว่า ผักที่ปรุงด้วยน้ำสลัดอันมีส่วนผสมของเกลือ กว่าจะได้เป็นว่า”สลัด”สั้นๆนี้หลากหลายที่มาเลยนะคะ เรามาดูประโยชน์ของการกินสลัดกันดีกว่าค่ะว่าจะมากมายหลากหลายเหมือนที่มาไหมนะ"
             ).forEach(story_of_food-> {
                Story story =new Story();
                story.setStext(story_of_food);
                storyrepository.save(story);
 
             });

            //set Ingredient
            Nutrition nutrition = new Nutrition();
            nutrition.setCarbohydrate("10%");
            nutrition.setFat("0%");
            nutrition.setFruit("30%");
            nutrition.setProtein("20%");
            nutrition.setVitamin("40%");
            nutritionrepository.save(nutrition);

            //set menu
            Stream.of("salad").forEach(menuname -> {
                InfoMenu infomenu = new InfoMenu();
                infomenu.setMname(menuname);
                infomenu.setPicurl("https://hips.hearstapps.com/hmg-prod/images/avocado-salad-1524672116.png");
                infomenu.setStext(storyrepository.getOne(1L));
                infomenu.setCal(80.5);
                infomenu.setText(ingredientrepository.getOne(1L));
                infomenu.setNutrition(nutritionrepository.getOne(1L));
                
                infomenurepository.save(infomenu);

            });
        };
    };
}


