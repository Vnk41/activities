package com.web.activities.controllers.models;


import javax.persistence.*;

@Entity
@Table(name = "ticketmovieshow")
public class TicketMovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "movieshowId", nullable = false)
    private Long movieshowId;

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

    public Long getMovieshowId() {
        return movieshowId;
    }

    public void setMovieshowId(Long movieshowId) {
        this.movieshowId = movieshowId;
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

    public void setCol(Integer col) {
        this.col = col;
    }

    public TicketMovieShow(Long movieshowId, User user, Integer row, Integer col) {
        this.movieshowId = movieshowId;
        this.user = user;
        this.row = row;
        this.col = col;
    }

    public TicketMovieShow(){

    }
}
