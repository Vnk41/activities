package com.web.activities.controllers.models;


import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "ticketmovieshow")
public class TicketMovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movieshow_id")
    private MovieShow movieshow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "row", nullable = false)
    private Integer row;
    @Column(name = "col", nullable = false)
    private Integer col;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public MovieShow getMovieshow() {
        return movieshow;
    }

    public void setMovieshow(MovieShow movieshow) {
        this.movieshow = movieshow;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public TicketMovieShow(MovieShow movieshow, User user, Integer row, Integer col) {
        this.movieshow = movieshow;
        this.user = user;
        this.row = row;
        this.col = col;
    }

    public TicketMovieShow(){

    }
}
