package com.example.demo.entity;

import java.io.Serializable;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/6 13:46
 * @Description: 用户实体
 */
public class ComputerUser extends BaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *主键
     * */
    private Long id;
    /**
     *用户名称
     * */
    private String userName;
    /**
     *密码
     * */
    private String password;
    /**
     * 性别，1-男，2-女
     * */
    private Integer gender;
    /**
     *用户类型
     * */
    private Integer userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ComputerUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", userType=" + userType +
                '}';
    }
}
