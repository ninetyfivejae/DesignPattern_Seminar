package com.example.parkminhyun.practice_seminar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Library 초기화 및 공통된 App 정보를 받기 위한 Class
 * Created by ParkMinHyun on 2018-05-11.
 */

public class App extends Application {

    private static App instance;

    private static Activity currentActivity;
    private static FirebaseDatabase firebaseDatabase;
    private static final String APP_NAME = "DesignPattern_Seminar";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initLibraries();
    }

    private void initLibraries() {
        initRealm();
        initFireBase();
    }

    private void initFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    private void initRealm() {
//        Realm.init(this);
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
//                .name(APP_NAME)
//                .directory(getFilesDir())
//                .build();
//        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static App getInstance() {
        return instance;
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }

    public static DatabaseReference getFirebaseDataReference() {
        return firebaseDatabase.getReference();
    }

}
