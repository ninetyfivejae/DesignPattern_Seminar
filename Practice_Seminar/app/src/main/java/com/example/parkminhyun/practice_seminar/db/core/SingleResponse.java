package com.example.parkminhyun.practice_seminar.db.core;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public interface SingleResponse<T> {
    void onResponse(T result);
}
