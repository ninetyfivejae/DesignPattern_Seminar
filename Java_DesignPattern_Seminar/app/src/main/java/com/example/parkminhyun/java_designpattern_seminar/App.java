package com.example.parkminhyun.java_designpattern_seminar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Library 초기화 및 context를 받기 위한 Class
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
        initNaverLogin();
    }

    private void initFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
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

    public static App getInstance() {
        return instance;
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity activity){
        currentActivity = activity;
    }

    public static FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public static void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) App.getInstance().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
