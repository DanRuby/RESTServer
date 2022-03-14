package com.example;

import java.util.List;

public interface FilmService {
	public boolean createFilm(FilmEntity filmEntity);

	public boolean updateFilm(String id);

	public boolean deleteFilm(String id);

	public FilmEntity getFilm(String id);

	public List<FilmEntity> getAllFilms();

	boolean dump();

	boolean load();
}
