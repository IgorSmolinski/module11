package com.igor.patterns.strategy.services;

public class FacebookPublisher implements SocialPublisher{
    @Override
    public String share(){
        return "Facebook";
    }
}
