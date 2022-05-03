package com.switchfully.sharkmen.division.api.dto;

public class DivisionDto {
    private final Long id;
    private final String name;
    private final String originalName;
    private final String director;

    public DivisionDto(Long id, String name, String originalName, String director) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public Long getId() {
        return id;
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
