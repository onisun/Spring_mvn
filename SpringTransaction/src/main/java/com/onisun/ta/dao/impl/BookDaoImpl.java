package com.onisun.ta.dao.impl;

import com.onisun.ta.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Neo
 * @version 1.0
 */
@Service
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 减去某个用户的余额
     *
     * @param userName
     * @param price
     */
    public void updateBalance(String userName, int price) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql,price,userName);
    }

    /**
     * 根据图书id获取书的价格
     * @param id
     * @return
     */
    public int getPrice(int id) {
        String sql = "select price from book where id = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,id);
    }

    /**
     * 减库存，减去某本书的库存
     * @param id
     */
    public void updateStock(int id) {
        String sql = "update book_stock set stock=stock-1 where id=?";
        jdbcTemplate.update(sql,id);
    }
}
