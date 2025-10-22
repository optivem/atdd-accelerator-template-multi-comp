package com.optivem.atddaccelerator.template.backend.controllers;

import com.optivem.atddaccelerator.template.backend.models.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoController {

    @Value("${todos.api.host}")
    private String todosApiHost;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable int id) {
        String url = todosApiHost + "/todos/" + id;
        return restTemplate.getForObject(url, Todo.class);
    }
}