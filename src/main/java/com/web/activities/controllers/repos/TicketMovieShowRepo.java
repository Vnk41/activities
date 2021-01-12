package com.web.activities.controllers.repos;

import com.web.activities.controllers.models.TicketMovieShow;
import com.web.activities.controllers.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TicketMovieShowRepo  extends CrudRepository<TicketMovieShow, Long> {
    Iterable<TicketMovieShow> findByUserId(Long id);
    //TicketMovieShow findDistinctByUserId(Long id);
}
