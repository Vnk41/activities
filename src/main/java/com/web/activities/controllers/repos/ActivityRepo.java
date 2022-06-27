package com.web.activities.controllers.repos;

import com.web.activities.controllers.models.Activity;
import com.web.activities.controllers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo  extends JpaRepository<Activity, Long> {
    //Activity findById(Long id);
}
