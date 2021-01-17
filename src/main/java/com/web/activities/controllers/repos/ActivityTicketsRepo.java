package com.web.activities.controllers.repos;

import com.web.activities.controllers.models.TicketActivity;
import com.web.activities.controllers.models.TicketMovieShow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTicketsRepo extends CrudRepository<TicketActivity, Long> {
    Iterable<TicketActivity> findByUserId(Long id);
}
