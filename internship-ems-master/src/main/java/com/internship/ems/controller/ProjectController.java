package com.internship.ems.controller;


import com.internship.ems.model.Project;
import com.internship.ems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping(value = "/project")
    public List<Project> getAllProject(){
        return service.getAll();
    }

    @GetMapping("/project/{id}")
    public Project getProjectById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping(value = "/saveProject")
    public String saveProject(@RequestBody Project project){
        service.saveProject(project);
        return "Saved!!!";
    }

    @PutMapping(value = "/updateProject/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody Project projectInfo){
        return service.updateProject(id, projectInfo);
    }

    @DeleteMapping(value = "/deleteProject/{id}")
    public String deleteProject(@PathVariable int id){
        return service.deleteProject(id);
    }
}
