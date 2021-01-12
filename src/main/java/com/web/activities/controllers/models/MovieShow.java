package com.web.activities.controllers.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movieshow")
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "movie_russian_title", nullable = true)
    private String movie_russian_title;
    @Column(name = "movie_english_title", nullable = true)
    private String movie_english_title;
    @Column(name = "movie_director", nullable = true)
    private String movie_director;
    @Column(name = "movie_actors", nullable = true)
    private String movie_actors;
    @Column(name = "movie_year", nullable = true)
    private Integer movie_year;
    @Column(name = "datetime", nullable = true)
    private String datetime;
    @Column(name = "running_time", nullable = true)
    private Integer running_time;
    @Column(name = "description", length = 1000, nullable = true)
    private String description;

    public MovieShow() {
    }

    public MovieShow(String movie_russian_title, String movie_english_title, String movie_director, String movie_actors, Integer movie_year, String datetime, Integer running_time, String description) {
        this.movie_russian_title = movie_russian_title;
        this.movie_english_title = movie_english_title;
        this.movie_director = movie_director;
        this.movie_actors = movie_actors;
        this.movie_year = movie_year;
        this.datetime = datetime;
        this.running_time = running_time;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovie_russian_title() {
        return movie_russian_title;
    }

    public void setMovie_russian_title(String movie_russian_title) {
        this.movie_russian_title = movie_russian_title;
    }

    public String getMovie_english_title() {
        return movie_english_title;
    }

    public void setMovie_english_title(String movie_english_title) {
        this.movie_english_title = movie_english_title;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_actors() {
        return movie_actors;
    }

    public void setMovie_actors(String movie_actors) {
        this.movie_actors = movie_actors;
    }

    public Integer getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(Integer movie_year) {
        this.movie_year = movie_year;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getRunning_time() {
        return running_time;
    }

    public void setRunning_time(Integer running_time) {
        this.running_time = running_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

