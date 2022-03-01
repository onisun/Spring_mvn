package com.onisun.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author Neo
 * @version 1.0
 */
public class SpringTest02 {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_db.xml");
        DruidDataSource dataSource = context.getBean("dataSource",DruidDataSource.class);
        System.out.println("dataSource ===="+ dataSource);
        System.out.println(dataSource.getConnection());
    }
}
