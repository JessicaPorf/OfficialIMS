package com.qa.ims.persistence.dao;

import java.util.List;
/**
 * Create, Read, Update and Delete controller.
 * Takes in inputs for each action to be sent to a service class
 */
/**	I have implemented CRUD into all of my controllers.
 */

public interface Dao<T> {

    List<T> readAll();
     
    T create(T t);
     
    T update(T t);
     
    void delete(long id);
}
	