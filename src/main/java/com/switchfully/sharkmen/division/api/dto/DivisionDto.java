package com.switchfully.sharkmen.division.api.dto;

public class DivisionDto {
    private final String name;
    private final String originalName;
    private final String director;

    public DivisionDto(String name, String originalName, String director) {
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
