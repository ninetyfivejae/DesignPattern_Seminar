package com.example.parkminhyun.java_designpattern_seminar.db.core;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public interface SingleResponse<T> {
    void onResponse(T result);
}
