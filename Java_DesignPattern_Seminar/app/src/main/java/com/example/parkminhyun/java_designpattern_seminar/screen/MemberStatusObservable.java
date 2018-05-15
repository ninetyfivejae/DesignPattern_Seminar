package com.example.parkminhyun.java_designpattern_seminar.screen;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface MemberStatusObservable {
    void addObserver(MemberStatusObserver sentenceHolderObserver);
    void deleteObserver(MemberStatusObserver sentenceHolderObserver);
    void notifyObserver(int mode);
}
