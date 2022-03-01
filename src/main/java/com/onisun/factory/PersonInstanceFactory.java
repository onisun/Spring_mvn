package com.onisun.factory;

import com.onisun.entity.Person;

/**
 * @author Neo
 * @version 1.0
 */
public class PersonInstanceFactory {
    public  Person getPerson(String name){
        Person person = new Person();
        person.setId(2);
        person.setName(name);
        person.setAge(28);
        return person;
    }
}
