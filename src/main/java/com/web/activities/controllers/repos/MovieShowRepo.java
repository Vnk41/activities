package com.web.activities.controllers.repos;

import com.web.activities.controllers.models.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowRepo extends JpaRepository<MovieShow, Long> {
    //MovieShow findByUserId(Long id);
}
