package com.lcb.test.demo.databinding;

/**
 * Created by baocheng.liu on 2017/11/23.
 */

public class UserModel {

    private String userName;

    private int age;

    public UserModel(String userName,int age){
        this.userName = userName;
        this.age = age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
