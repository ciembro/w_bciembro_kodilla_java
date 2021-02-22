package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.publishers.SocialPublisher;

public class User {

    protected final String username;
    protected SocialPublisher socialPublisher;

    public User(String username) {

        this.username = username;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {

        this.socialPublisher = socialPublisher;
    }

    public String sharePost(){

        return socialPublisher.share();
    }
}
