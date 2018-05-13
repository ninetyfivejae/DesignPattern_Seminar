package com.example.parkminhyun.java_designpattern_seminar.common.vo;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MemberVO {

    int number;
    String name;
    String phoneNum;

    public MemberVO(int number, String name, String phoneNum) {
        this.number = number;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
