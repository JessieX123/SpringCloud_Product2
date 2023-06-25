package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("ticket")
public class Ticket {
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    @TableField("t_movie")
    private Integer tMovie;

    @TableField("t_cinema")
    private Integer tCinema;

    @TableField("t_date")
    private Date tDate;

    @TableField("t_user")
    private Integer tUser;

    @TableField(exist = false)
    private Movie movie;

    @TableField(exist = false)
    private Cinema cinema;

    @TableField(exist = false)
    private User user;

    public Ticket() {

    }

    public Ticket(Integer tId, Integer tMovie, Integer tCinema, Date tDate, Integer tUser) {
        this.tId = tId;
        this.tMovie = tMovie;
        this.tCinema = tCinema;
        this.tDate = tDate;
        this.tUser = tUser;
    }

    public Ticket(Integer tId, Integer tMovie, Integer tCinema, Date tDate, Integer tUser, Movie movie, Cinema cinema, User user) {
        this.tId = tId;
        this.tMovie = tMovie;
        this.tCinema = tCinema;
        this.tDate = tDate;
        this.tUser = tUser;
        this.movie = movie;
        this.cinema = cinema;
        this.user = user;
    }

    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }

    public Integer getTMovie() {
        return tMovie;
    }

    public void setTMovie(Integer tMovie) {
        this.tMovie = tMovie;
    }

    public Integer getTCinema() {
        return tCinema;
    }

    public void setTCinema(Integer tCinema) {
        this.tCinema = tCinema;
    }

    public Date getTDate() {
        return tDate;
    }

    public void setTDate(Date tDate) {
        this.tDate = tDate;
    }

    public Integer getTUser() {
        return tUser;
    }

    public void setTUser(Integer tUser) {
        this.tUser = tUser;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tId=" + tId +
                ", tMovie=" + tMovie +
                ", tCinema=" + tCinema +
                ", tDate=" + tDate +
                ", tUser=" + tUser +
                ", movie=" + movie +
                ", cinema=" + cinema +
                ", user=" + user +
                '}';
    }
}
