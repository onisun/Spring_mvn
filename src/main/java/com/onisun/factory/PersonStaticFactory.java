package com.onisun.factory;

import com.onisun.entity.Person;

/**
 * @author Neo
 * @version 1.0
 */
public class PersonStaticFactory {
    public static Person getPerson(String name){
        Person person = new Person();
        person.setId(1);
        person.setName(name);
        person.setAge(18);
        return person;
    }
}
