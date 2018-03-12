package com.igor.patterns.strategy.services;

public class TwitterPublisher implements SocialPublisher{
    @Override
    public String share(){
        return "Twitter";
    }
}
