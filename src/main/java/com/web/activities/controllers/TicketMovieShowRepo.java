package com.web.activities.controllers;

import com.web.activities.controllers.models.TicketMovieShow;
import org.springframework.data.repository.CrudRepository;

public interface TicketMovieShowRepo  extends CrudRepository<TicketMovieShow, Long> {
}
