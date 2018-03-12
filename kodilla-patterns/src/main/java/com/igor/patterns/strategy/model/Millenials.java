package com.igor.patterns.strategy.model;

import com.igor.patterns.strategy.services.FacebookPublisher;

public class Millenials extends User {
    public Millenials(String name){
        super(name);
        this.socialPublisher= new FacebookPublisher();
    }
}
