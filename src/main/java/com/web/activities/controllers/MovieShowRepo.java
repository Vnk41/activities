package com.web.activities.controllers;

import com.web.activities.controllers.models.MovieShow;
import org.springframework.data.repository.CrudRepository;

public interface MovieShowRepo extends CrudRepository<MovieShow, Long> {
    //MovieShow findByUser_Id(Long id);
}
