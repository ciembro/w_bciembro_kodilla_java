package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import com.kodilla.patterns.strategy.social.users.Millenials;
import com.kodilla.patterns.strategy.social.users.User;
import com.kodilla.patterns.strategy.social.users.YGeneration;
import com.kodilla.patterns.strategy.social.users.ZGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    User millenials = new Millenials("Millenials");
    User yGeneration = new YGeneration("YGeneration");
    User zGeneration = new ZGeneration("ZGeneration");

    @Test
    void testDefaultSharingStrategies(){
        //given
        //when
        String millenialsPublisher = millenials.sharePost();
        String yGenerationPublisher = yGeneration.sharePost();
        String zGenerationPublisher = zGeneration.sharePost();

        //then
        assertEquals("Share on Facebook", millenialsPublisher);
        assertEquals("Share on Twitter", yGenerationPublisher);
        assertEquals("Share on Snapchat", zGenerationPublisher);
    }

    @Test
    void testIndividualSharingStrategy(){
        //given
        millenials.setSocialPublisher(new SnapchatPublisher());
        yGeneration.setSocialPublisher(new FacebookPublisher());
        zGeneration.setSocialPublisher(new TwitterPublisher());

        //when
        String millenialsPublisher = millenials.sharePost();
        String yGenerationPublisher = yGeneration.sharePost();
        String zGenerationPublisher = zGeneration.sharePost();

        //then
        assertEquals("Share on Snapchat", millenialsPublisher);
        assertEquals("Share on Facebook", yGenerationPublisher);
        assertEquals("Share on Twitter", zGenerationPublisher);
    }
}
