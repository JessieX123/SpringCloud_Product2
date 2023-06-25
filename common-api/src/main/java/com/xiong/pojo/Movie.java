package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.List;

@TableName("movie")
public class Movie {
    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer mId;

    @TableField("m_name")
    private String mName;

    @TableField("m_date")
    private Date mDate;

    @TableField("m_country")
    private String mCountry;

    @TableField(exist = false)
    private List<Cinema> cinemaList;

    public Movie() {

    }

    public Movie(Integer mId, String mName, Date mDate, String country) {
        this.mId = mId;
        this.mName = mName;
        this.mDate = mDate;
        this.mCountry = country;
    }

    public Movie(Integer mId, String mName, Date mDate, String mCountry, List<Cinema> cinemaList) {
        this.mId = mId;
        this.mName = mName;
        this.mDate = mDate;
        this.mCountry = mCountry;
        this.cinemaList = cinemaList;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public Date getMDate() {
        return mDate;
    }

    public void setMDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getMCountry() {
        return mCountry;
    }

    public void setMCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDate=" + mDate +
                ", mCountry='" + mCountry + '\'' +
                ", cinemaList=" + cinemaList +
                '}';
    }
}
