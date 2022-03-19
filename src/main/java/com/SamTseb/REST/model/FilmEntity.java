package com.SamTseb.REST.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/** The class for storage movies */
@Data
@AllArgsConstructor
public class FilmEntity {
    private String id;
    private String name;
    private String description;
    private String year;
    private String producer;
    private String image;
    private Boolean isLiked;

    /**
     * The copy constructor
     * @param obj The entity for copy
     */
    /*public FilmEntity(FilmEntity obj) {
        this.id = obj.id;
        this.name = obj.name;
        this.description = obj.description;
        this.year = obj.year;
        this.director = obj.director;
        this.linkToPoster = obj.linkToPoster;
    }*/

    /**
     * The empty constructor for serialization and deserialization
     */
    public FilmEntity() {
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmEntity)) return false;
        FilmEntity filmEntity = (FilmEntity) o;
        return getId() == filmEntity.getId() && getName().equals(filmEntity.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }*/
}
