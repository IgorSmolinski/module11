package com.igor.patterns.strategy.model;

import com.igor.patterns.strategy.services.TwitterPublisher;

public class ZGeneration extends User{
    public ZGeneration(String name){
        super(name);
        this.socialPublisher=new TwitterPublisher();
    }
}
