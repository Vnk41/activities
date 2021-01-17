package com.web.activities.controllers.models;

import javax.persistence.*;

@Entity
@Table (name = "tickets")
public class TicketActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_id")
    private Activity activity;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public TicketActivity(){

    }

    public TicketActivity(Activity activity, User user) {
        this.activity = activity;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
