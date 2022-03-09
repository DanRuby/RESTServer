package com.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class FilmServiceImpl implements FilmService {

	private static Map<String, FilmEntity> ENTITY_REPOSITORY_MAP = new HashMap<>();

	@Override
	public boolean createFilm(FilmEntity filmEntity) {
		System.out.println("I'm alive!");
		if ((filmEntity.getId() != null) && !ENTITY_REPOSITORY_MAP.containsKey(filmEntity.getId())) {
			System.out.println(filmEntity);
			ENTITY_REPOSITORY_MAP.put(filmEntity.getId(), filmEntity);
			return true;
		} else
			return false;
	}

	@Override
	public boolean updateFilm(String id) {
		if (ENTITY_REPOSITORY_MAP.containsKey(id)) {
			FilmEntity filmEntity = getFilm(id);
			filmEntity.setIsLiked(!filmEntity.getIsLiked());
			ENTITY_REPOSITORY_MAP.put(id, filmEntity);
			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteFilm(String id) {
		FilmEntity deleted = ENTITY_REPOSITORY_MAP.get(id);
		if (deleted != null) {
			ENTITY_REPOSITORY_MAP.remove(id);
			return true;
		} else
			return false;
	}

	@Override
	public FilmEntity getFilm(String id) {
		return ENTITY_REPOSITORY_MAP.get(id);
	}

	@Override
	public List<FilmEntity> getAllFilms() {
		return new ArrayList<>(ENTITY_REPOSITORY_MAP.values());
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
