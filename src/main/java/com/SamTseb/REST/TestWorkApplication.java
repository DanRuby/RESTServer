package com.SamTseb.REST;

import com.SamTseb.REST.service.FilmEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestWorkApplication {
    private static FilmEntityService filmEntityService;

    @Autowired
    public TestWorkApplication(FilmEntityService filmEntityService) {
        this.filmEntityService = filmEntityService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestWorkApplication.class, args);
        filmEntityService.load();
    }

}
