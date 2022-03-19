package com.SamTseb.REST.controller;

import com.SamTseb.REST.model.FilmEntity;
import com.SamTseb.REST.service.FilmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmEntityController {
    private final FilmEntityService filmEntityService;

    @Autowired
    public FilmEntityController(FilmEntityService filmEntityService) {
        this.filmEntityService = filmEntityService;
    }

    @GetMapping(value = "/films/{id}")
    public ResponseEntity<FilmEntity> readByID(@PathVariable String id) {
        final FilmEntity data = filmEntityService.read(id);
        return data != null
                ? new ResponseEntity<>(data, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/films")
    public ResponseEntity<List<FilmEntity>> readAll() {
        final List<FilmEntity> data = filmEntityService.readAll();
        return data != null
                ? new ResponseEntity<>(data, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/films/{id}")
    public ResponseEntity<FilmEntity> create(@PathVariable String id, @RequestBody FilmEntity filmEntity) {
        final boolean created;
        created = filmEntityService.create(id, filmEntity);
        return created ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping(value = "/films/{id}")
    public ResponseEntity<?> update(@PathVariable String id) {
        final boolean updated;
        updated = filmEntityService.update(id);

        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping(value = "/films/{id}")
    public ResponseEntity<FilmEntity> delete(@PathVariable String id) {
        final FilmEntity deleted = filmEntityService.delete(id);

        if (deleted != null)
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/dump")
    public ResponseEntity<?> dump() {
        return filmEntityService.dump() ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/load")
    public ResponseEntity<?> load() {
        return filmEntityService.load() ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
