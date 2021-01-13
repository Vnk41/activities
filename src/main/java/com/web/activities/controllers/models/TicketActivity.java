package com.web.activities.controllers.models;

import javax.persistence.*;

@Entity
@Table (name = "tickets")
public class TicketActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "activityId", nullable = true)
    private Long activityId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public TicketActivity(Long activityId, User user) {
        this.activityId = activityId;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}
