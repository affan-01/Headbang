package com.affan.music_engine.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.affan.music_engine.repository.PersonRepository;
import com.affan.music_engine.entity.Person;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository repository;

    @PostMapping
    public Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping
    public Iterable<Person> getAll() {
        return repository.findAll();
    }
}