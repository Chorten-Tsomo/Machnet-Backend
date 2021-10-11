package com.internship.ems.controller;


import com.internship.ems.dto.ProjectDto;
import com.internship.ems.model.Project;
import com.internship.ems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService service;

    @GetMapping(value = "/project")
    public List<ProjectDto> getAllProject(){
        return service.getAll();
    }

    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@RequestBody int id){
        return service.getById(id);
    }

    @PostMapping(value = "/saveProject")
    public ProjectDto saveProject( @Valid @RequestBody ProjectDto projectDto){
        return service.saveProject(projectDto);

    }

    @PutMapping(value = "/updateProject/{id}")
    public ProjectDto updateProject(@PathVariable int id, @RequestBody ProjectDto projectInfoDto){
        return service.updateProject(id, projectInfoDto);
    }

    @DeleteMapping(value = "/deleteProject/{id}")
    public String deleteProject(@PathVariable int id){
        return service.deleteProject(id);
    }
}
