package com.web.activities.controllers;

import com.web.activities.controllers.models.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepo extends CrudRepository<Activity, Long> {

}
