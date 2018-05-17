/*
 * SingleTask.java 2017. 07. 02
 *
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.example.parkminhyun.java_designpattern_seminar.db.core;

/**
 * @author wonsuk.lim@navercorp.com
 */

public interface SingleTask<T> {

    T execute();

}
