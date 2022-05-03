package com.switchfully.sharkmen.division.api.dto;

import javax.validation.constraints.NotBlank;

public class CreateDivisionDto {
    @NotBlank(message = "name is blank or null")
    private final String name;
    @NotBlank(message = "originalName is blank or null")
    private final String originalName;
    @NotBlank(message = "director is blank or null")
    private final String director;

    public CreateDivisionDto(String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }
}
