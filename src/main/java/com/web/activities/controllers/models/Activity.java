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
    @Column(name = "title", length = 100,nullable = false)
    private String title;
    @Column(name = "place", length = 100,nullable = false)
    private String place;
    @Column(name = "address", length = 100,nullable = false)
    private String address;
    @Column(name = "description", length = 1000,nullable = false)
    private String description;

    @Column(name = "datetime", nullable = false)
    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    private String datetime;


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    public Activity() {
    }

    public Activity(String title, String place, String address, String description, String datetime) {
        this.title = title;
        this.place = place;
        this.address = address;
        this.description = description;
        this.datetime = datetime;
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


}
