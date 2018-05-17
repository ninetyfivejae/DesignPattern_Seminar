package com.example.parkminhyun.java_designpattern_seminar.db.core;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public interface FirebaseQueryTask {
    void queryResult(DatabaseReference databaseReference);
}
