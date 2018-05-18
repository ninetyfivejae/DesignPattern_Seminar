package com.example.parkminhyun.practice_seminar.db.core;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public interface FirebaseRequestTask {
    void executeRequest(DatabaseReference databaseReference);
}
