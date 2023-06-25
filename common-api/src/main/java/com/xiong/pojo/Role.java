package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("role")
public class Role {
    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    @TableField("r_name")
    private String rName;

    public Role() {
    }

    public Role(Integer rId, String rName) {
        this.rId = rId;
        this.rName = rName;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                '}';
    }
}
