package com.example;

import com.example.Models.Database.Lesson;
import com.example.Models.Database.LessonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> list() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson read(@PathVariable Long id) {
        return this.repository.findOne(id);
    }

    @PatchMapping("/{id}")
    public Lesson update(@PathVariable Long id, @RequestBody Lesson lesson) {
        Lesson found = this.repository.findOne(id);
        found=lesson;
        return this.repository.save(found);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.repository.delete(id);
    }

}