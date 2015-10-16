package com.guitar.db.repository;

/**
 * Created by Scott on 10/15/15.
 */
public class ModelJpaRepositoryImpl implements ModelJpaRepositoryCustom {

    @Override
    public void aCustomMethod() {
        System.out.println("ModelJpaRepositoryImpl: I'm a custom method!");
    }
}
