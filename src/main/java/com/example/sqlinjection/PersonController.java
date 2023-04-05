package com.example.sqlinjection;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonDAO personDAO;

    @GetMapping("/{name}")
    public String getPeople(@PathVariable String name) {
        return personDAO.findByName(name).toString();
    }

}
