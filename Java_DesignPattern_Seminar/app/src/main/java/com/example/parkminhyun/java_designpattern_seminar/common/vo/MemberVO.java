package com.example.parkminhyun.java_designpattern_seminar.common.vo;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MemberVO {

    int index;
    String name;
    String phoneNum;

    public MemberVO() {}

    public MemberVO(int index, String name, String phoneNum) {
        this.index = index;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
