package com.igor.patterns.strategy.services;

public class SnapchatPublisher implements SocialPublisher{
    @Override
    public String share(){
        return "Snapchat";
    }
}
