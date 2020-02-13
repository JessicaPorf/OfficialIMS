package com.qa.ims.controller;

import java.util.List;

/**
 * Create, Read, Update and Delete controller.
 * Takes in inputs for each action to be sent to a service class
 */
/**	I have implemented CRUD into all of my controllers.
 */
public interface CrudController<T> {
    
    List<T> readAll();
     
    T create();
     
    T update();
     
    void delete();

}
