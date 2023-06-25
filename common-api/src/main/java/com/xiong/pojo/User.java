package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("user")
public class User {
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    @TableField("u_username")
    private String uUsername;

    @TableField("u_password")
    private String uPassword;

    @TableField("u_phone")
    private String uPhone;

    @TableField("u_date")
    private Date uDate;

    @TableField("u_role_id")
    private Integer uRoleId;

    @TableField(exist = false)
    private Role role;

    public User() {
    }

    public User(Integer uId, String uUsername, String uPassword, String uPhone, Date uDate, Integer uRoleId) {
        this.uId = uId;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uDate = uDate;
        this.uRoleId = uRoleId;
    }

    public User(Integer uId, String uUsername, String uPassword, String uPhone, Date uDate, Integer uRoleId, Role role) {
        this.uId = uId;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uDate = uDate;
        this.uRoleId = uRoleId;
        this.role = role;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUUsername() {
        return uUsername;
    }

    public void setUUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUPhone() {
        return uPhone;
    }

    public void setUPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public Date getUDate() {
        return uDate;
    }

    public void setUDate(Date uDate) {
        this.uDate = uDate;
    }

    public Integer getURoleId() {
        return uRoleId;
    }

    public void setURoleId(Integer uRoleId) {
        this.uRoleId = uRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uDate=" + uDate +
                ", uRoleId=" + uRoleId +
                ", role=" + role +
                '}';
    }
}
