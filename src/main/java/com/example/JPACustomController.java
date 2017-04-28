package com.example;

import com.example.Models.Database.JPACustomRepository;

import com.example.Models.Database.Lesson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class JPACustomController {
    private final JPACustomRepository repository;

    public JPACustomController(JPACustomRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/find/{title}")
    public List<Lesson> getByTitle(@PathVariable String title) {
        return this.repository.findByTitle(title);
    }

//    @GetMapping("/between")
//    public List<Lesson> getByRange(@RequestParam("year1") Long year1, @RequestParam("year2") Long year2){
//        System.out.println(year1+" "+year2);
//        return this.repository.findByYearBetween(year1,year2);
//    }

    @GetMapping("/between")
    public List<Lesson> getByRangeNative(@RequestParam("year1") Long year1, @RequestParam("year2") Long year2){
        System.out.println(year1+" "+year2);
        return this.repository.findByYearBetween(year1,year2);
    }
}