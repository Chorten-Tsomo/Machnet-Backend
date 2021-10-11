package com.internship.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ProjectId;
    @NotNull(message = "No must not be null")
    private String name;
    private String description;
}
