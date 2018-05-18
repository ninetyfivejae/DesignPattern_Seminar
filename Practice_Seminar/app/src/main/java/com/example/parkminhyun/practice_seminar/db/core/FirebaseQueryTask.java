package com.example.parkminhyun.practice_seminar.db.core;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public interface FirebaseQueryTask<T> {
    T queryResult(DatabaseReference databaseReference);
}
