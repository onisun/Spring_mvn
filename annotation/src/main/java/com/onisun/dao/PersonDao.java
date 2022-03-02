package com.onisun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Neo
 * @version 1.0
 */
@Repository
public class PersonDao {

    @Autowired
    public PersonDao() {
    }

    public void getPerson(){
        System.out.println("PersonDao 的getPerson()方法被调用...");
    }
}
