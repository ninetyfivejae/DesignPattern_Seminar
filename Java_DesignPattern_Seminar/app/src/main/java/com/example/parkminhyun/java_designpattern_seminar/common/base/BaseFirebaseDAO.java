package com.example.parkminhyun.java_designpattern_seminar.common.base;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseQueryTask;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseTransactionTask;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public class BaseFirebaseDAO {

    protected void query(FirebaseQueryTask task){
        DatabaseReference memberDataReference = App.getFirebaseDatabase().getReference();
        task.queryResult(memberDataReference);
    }

    protected void modify(FirebaseTransactionTask task){
        DatabaseReference memberDataReference = App.getFirebaseDatabase().getReference();
        task.executeTransaction(memberDataReference);
    }

}
