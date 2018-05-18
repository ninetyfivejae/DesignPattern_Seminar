package com.example.parkminhyun.practice_seminar.screen.main.observer;

/**
 * 옵저버를 등록, 해제, 알림을 담당하는 인터페이스
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface MemberStatusObservable {
    void addObserver(MemberStatusObserver sentenceHolderObserver);
    void deleteObserver(MemberStatusObserver sentenceHolderObserver);
    void notifyObserver(int mode);
}
