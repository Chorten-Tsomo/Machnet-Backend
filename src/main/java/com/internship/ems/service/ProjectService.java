package com.internship.ems.service;


import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dto.ProjectDto;
import com.internship.ems.mapper.ProjectMapper;
import com.internship.ems.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private ProjectMapper mapper;

    public ProjectDto saveProject(ProjectDto projectDto){
        Project projectModel = mapper.DtoToModel(projectDto);
        return  mapper.modelToDto( projectRepo.save(projectModel) );
    }

    public List<ProjectDto> getAll(){
        return mapper.modelsToDtos( (List<Project>) projectRepo.findAll() );

    }

    public ProjectDto getById(int id){
        Project projectWithSearchedId = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return  mapper.modelToDto( projectRepo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }
    public ProjectDto updateProject(int id, ProjectDto newProjectDto){
        Project newProjectModel=mapper.DtoToModel( newProjectDto );

        Project project = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        project.setProjectName(newProjectModel.getProjectName());
        project.setDescription(newProjectModel.getDescription());
        projectRepo.save(project);

        return mapper.modelToDto( project );
    }
    public String deleteProject(int id){
        projectRepo.deleteById(id);
        return "Project deleted!!!" + id;
    }
}
