package com.SamTseb.REST.service;

import com.SamTseb.REST.model.FilmEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmEntityServiceImpl implements FilmEntityService {

    /** The entities storage */
    private static Map<String, FilmEntity> ENTITY_REPOSITORY_MAP = new HashMap<>();

    @Override
    public boolean create(String id, FilmEntity filmEntity) {
        if ((id != null) && !ENTITY_REPOSITORY_MAP.containsKey(id)) {
            filmEntity.setId(id);
            ENTITY_REPOSITORY_MAP.put(id, filmEntity);
            return true;
        } else
            return false;
    }

    @Override
    public FilmEntity read(String id) {
        return ENTITY_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<FilmEntity> readAll() {
        return new ArrayList<>(ENTITY_REPOSITORY_MAP.values());
    }

    @Override
    public boolean update(String id) {
        if (ENTITY_REPOSITORY_MAP.containsKey(id)) {
            FilmEntity filmEntity = read(id);
            filmEntity.setIsLiked(!filmEntity.getIsLiked());
            ENTITY_REPOSITORY_MAP.put(id, filmEntity);
            return true;
        }
        else
            return false;
    }

    @Override
    public FilmEntity delete(String id) {
        FilmEntity deleted = ENTITY_REPOSITORY_MAP.get(id);
        if (deleted != null)
            ENTITY_REPOSITORY_MAP.remove(id);
        return deleted;
    }

    @Override
    public boolean dump() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("dump.json"), ENTITY_REPOSITORY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean load() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, FilmEntity>> typeRef = new TypeReference<HashMap<String, FilmEntity>>() {
        };
        try {
            ENTITY_REPOSITORY_MAP = mapper.readValue(new File("./dump.json"), typeRef);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
