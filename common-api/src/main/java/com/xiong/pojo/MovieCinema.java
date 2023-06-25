package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("movie_cinema")
public class MovieCinema {
    private Integer mcMovieId;

    private Integer mcCinemaId;

    public Integer getMcMovieId() {
        return mcMovieId;
    }

    public void setMcMovieId(Integer mcMovieId) {
        this.mcMovieId = mcMovieId;
    }

    public Integer getMcCinemaId() {
        return mcCinemaId;
    }

    public void setMcCinemaId(Integer mcCinemaId) {
        this.mcCinemaId = mcCinemaId;
    }

    @Override
    public String toString() {
        return "MovieCinema{" +
                "mcMovieId=" + mcMovieId +
                ", mcCinemaId=" + mcCinemaId +
                '}';
    }
}
