package com.onisun.ta.service.impl;

import com.onisun.ta.dao.BookDao;
import com.onisun.ta.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Neo
 * @version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     * @param userName
     * @param bookId
     */
   @Transactional( )
    public void CheckOut(String userName, int bookId) {
        //减库存
        bookDao.updateStock(bookId);
        //获取书的价格
        int price = bookDao.getPrice(bookId);
        int i = 1/0;
        //从用户余额中减去书的价格
        bookDao.updateBalance(userName,price);

    }


        /**
         * 测试超时事务
         * @param userName
         * @param bookId
         */
   /*     @Transactional(timeout = 3,readOnly = true)
        public void CheckOut(String userName, int bookId) {
            //减库存
            bookDao.updateStock(bookId);
            //获取书的价格
            int price = bookDao.getPrice(bookId);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //从用户余额中减去书的价格
            bookDao.updateBalance(userName,price);
        }*/
}
