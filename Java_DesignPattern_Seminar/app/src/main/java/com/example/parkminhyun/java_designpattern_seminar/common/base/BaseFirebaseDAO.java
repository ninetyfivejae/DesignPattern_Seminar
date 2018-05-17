package com.example.parkminhyun.java_designpattern_seminar.common.base;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseQueryTask;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseRequestTask;
import com.example.parkminhyun.java_designpattern_seminar.db.core.FirebaseTransactionTask;
import com.google.firebase.database.DatabaseReference;

/**
 * DAO Class에서 공통적으로 사용하는 Method를 모은 부모 Class
 * Created by ParkMinHyun on 2018-05-17.
 */

public class BaseFirebaseDAO {

    /**
     * query 요청 후, 결과값을 제너릭 형태로 받기
     */
    protected <T> T query(FirebaseQueryTask<T> task) {
        DatabaseReference dataReference = App.getFirebaseDataReference();
        return task.queryResult(dataReference);
    }

    /**
     * DAO Class의 한 Method가 비동기로 돌아가고 있을 때 query Request를 위한 Method
     */
    protected void queryRequest(FirebaseRequestTask task) {
        DatabaseReference dataReference = App.getFirebaseDataReference();
        task.executeRequest(dataReference);
    }

    /**
     * 삽입, 삭제 등 트랜잭션에 대한 Method
     */
    protected void modify(FirebaseTransactionTask task) {
        DatabaseReference dataReference = App.getFirebaseDataReference();
        task.executeTransaction(dataReference);
    }

}
