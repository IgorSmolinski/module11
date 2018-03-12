package com.igor.patterns.strategy.model;

import com.igor.patterns.strategy.services.SnapchatPublisher;

public class YGeneration extends User {
    public YGeneration(String name){
        super(name);
        this.socialPublisher=new SnapchatPublisher();
    }
}
