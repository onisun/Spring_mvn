package com.onisun.controller;

import com.onisun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class PersonController {
    //通过属性注入
    @Resource
    private PersonService personService;

    public void getPerson(){
        personService.getPerson();
    }
    //通过构造器注入
/*
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
*/

    //通过setter方法注入
/*
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
*/


    /*   public PersonController() {
        System.out.println("创建了PersonController对象");
    }*/


}
