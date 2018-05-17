package com.example.parkminhyun.java_designpattern_seminar.common.base;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseQueryTask;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseTransactionTask;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public class BaseFirebaseDAO {

    protected <T> T query(FirebaseQueryTask<T> task){
        DatabaseReference memberDataReference = App.getFirebaseDatabase().getReference();
        T result = null;
        try {
            result = task.queryResult(memberDataReference);
        }catch (Exception e){

        }
        return result;
    }

    protected void modify(FirebaseTransactionTask task){
        DatabaseReference memberDataReference = App.getFirebaseDatabase().getReference();
        task.executeTransaction(memberDataReference);
    }

}
