package com.learning.springboot.bean;



import javafx.scene.input.DataFormat;

import java.sql.Timestamp;
import java.util.Date;

public class UserBean{

    private String id;

    private String name;

    private String phone;

    private String userPassword;

    private Timestamp  creattime;

    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", creattime=" + creattime +
                '}';
    }

}
