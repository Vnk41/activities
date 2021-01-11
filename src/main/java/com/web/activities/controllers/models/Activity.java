package com.web.activities.controllers.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", length = 100,nullable = true)
    private String title;
    @Column(name = "place", length = 100,nullable = true)
    private String place;
    @Column(name = "address", length = 100,nullable = true)
    private String address;
    @Column(name = "description", length = 1000,nullable = true)
    private String description;
    @Column(name = "date", nullable = true)
    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date;
    @Column(name = "time", nullable = true)
    private Date time;
    @Column(name = "all_tickets", nullable = true)
    private Integer all_tickets;
    @Column(name = "free_tickets", nullable = true)
    private Integer free_tickets;

    public Activity() {
    }

    public Activity(String title, String place, String address, String description, Date date, Date time, Integer all_tickets, Integer free_tickets) {
        this.title = title;
        this.place = place;
        this.address = address;
        this.description = description;
        this.date = date;
        this.time = time;
        this.all_tickets = all_tickets;
        this.free_tickets = free_tickets;
    }

    public Integer getAll_tickets() {
        return all_tickets;
    }

    public void setAll_tickets(Integer all_tickets) {
        this.all_tickets = all_tickets;
    }

    public Integer getFree_tickets() {
        return free_tickets;
    }

    public void setFree_tickets(Integer free_tickets) {
        this.free_tickets = free_tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
