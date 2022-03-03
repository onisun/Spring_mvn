package com.onisun.service;

/**
 * @author Neo
 * @version 1.0
 */
public interface Calc {
    Integer add(Integer i,Integer j) throws NoSuchMethodException;

    Integer sub(Integer i,Integer j) throws NoSuchMethodException;

    Integer mult(Integer i,Integer j) throws NoSuchMethodException;

    Integer div(Integer i,Integer j) throws NoSuchMethodException;
}
