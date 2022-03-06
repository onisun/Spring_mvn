package com.onisun.ta.dao;

/**
 * @author Neo
 * @version 1.0
 */
public interface BookDao {

    void updateBalance(String userName,int price);

    int getPrice(int id);

    void updateStock(int id);
}
