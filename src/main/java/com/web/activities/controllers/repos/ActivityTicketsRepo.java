package com.web.activities.controllers.repos;

import com.web.activities.controllers.models.TicketActivity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityTicketsRepo extends CrudRepository<TicketActivity, Long> {
}
