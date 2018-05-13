package com.example.parkminhyun.designpattern_seminar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * Library 초기화 및 context를 받기 위한 Class
 * Created by ParkMinHyun on 2018-05-11.
 */

public class App extends Application {

    private static App instance;

//    private static FirebaseDatabase firebaseDatabase;
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
        initNaverLogin();
        initRealm();
        initFireBase();
    }

    private void initNaverLogin() {
//        LoginHelper.initNaverAuthInstance(instance);
    }

    private void initRealm() {
//        Realm.init(this);
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
//                .name(APP_NAME)
//                .directory(getFilesDir())
//                .build();
//        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initFireBase() {
//        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public static App getInstance() {
        return instance;
    }

    public static Activity getCurrentActivity() {
        return getCurrentActivity();
    }

//    public static Realm getRealmInstance() {
//        return Realm.getDefaultInstance();
//    }

//    public static FirebaseDatabase getFirebaseDatabase() {
//        return firebaseDatabase;
//    }

}
