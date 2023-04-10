package com.andrii.productrestservice.controller;

import com.andrii.productrestservice.model.Group;
import com.andrii.productrestservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    private final GroupRepository repository;

    @Autowired
    public GroupController(GroupRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/groups")
    public List<Group> test() {
        return repository.findAll();
    }
}
