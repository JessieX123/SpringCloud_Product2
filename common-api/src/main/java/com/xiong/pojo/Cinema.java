package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.List;

@TableName("cinema")
public class Cinema {
    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    @TableField("c_name")
    private String cName;

    @TableField("c_phone")
    private String cPhone;

    @TableField("c_address")
    private String cAddress;

    @TableField("c_date")
    private Date cDate;

    @TableField(exist = false)
    private List<Movie> movieList;

    public Cinema() {

    }

    public Cinema(Integer cId, String cName, String cPhone, String cAddress, Date cDate) {
        this.cId = cId;
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cDate = cDate;
    }

    public Cinema(Integer cId, String cName, String cPhone, String cAddress, Date cDate, List<Movie> movieList) {
        this.cId = cId;
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cDate = cDate;
        this.movieList = movieList;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public Date getCDate() {
        return cDate;
    }

    public void setCDate(Date cDate) {
        this.cDate = cDate;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cDate=" + cDate +
                ", movieList=" + movieList +
                '}';
    }
}
