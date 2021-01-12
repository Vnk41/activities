package com.web.activities.controllers;

import com.web.activities.controllers.models.MovieShow;
import org.springframework.data.repository.CrudRepository;

public interface MovieShowRepo extends CrudRepository<MovieShow, Long> {
    MovieShow findByMovie_year(Integer movie_year);
}
