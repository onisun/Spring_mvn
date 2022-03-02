package com.onisun.service;

import com.onisun.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Neo
 * @version 1.0
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public void getPerson(){
        personDao.getPerson();
    }
}
