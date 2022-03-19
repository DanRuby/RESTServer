package com.SamTseb.REST.service;

import com.SamTseb.REST.model.FilmEntity;

import java.util.List;

/** The interface for work with entities in the storage. */
public interface FilmEntityService {

    /**
     * Create a new entity
     * @param id The id for data
     * @return true - creating is success, false - it isn't success
     */
    boolean create(String id, FilmEntity filmEntity);

    /**
     * Return an entity by the id
     *
     * @param id The id of an entity
     * @return The entity
     */
    FilmEntity read(String id);

    /**
     * Return all entities from storage
     * @return All entities
     */
    List<FilmEntity> readAll();

    /**
     * Update an entity by the id using the entity instance from a request body
     *
     * @param id An id in the database
     * @return true - the entity was update, false - wasn't update
     */
    boolean update(String id);

    /**
     * Delete an entity by the id
     *
     * @param id An entity id
     * @return true - the entity was delete, false - wasn't delete
     */
    FilmEntity delete(String id);

    /**
     * The function for save the state of the storage. The save file is "dump.json"
     * @return true - if saving is success, false - if it isn't.
     */
    boolean dump();

    /**
     * The function for load the state of storage. The save file is "dump.json"
     * @return true - if loading is success, false - if it isn't.
     */
    boolean load();
}
