package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User olaf = new Millenials("Olaf Z");
        User bambi34 = new YGeneration("Basia M34");
        User gosia = new ZGeneration("Małgorzata Mak");

        //When
        String olafSharePost = olaf.sharePost();
        System.out.println("Olaf posted on: " + olafSharePost);
        String bambi34SharePost = bambi34.sharePost();
        System.out.println("Bambi34 posted on: " + bambi34SharePost);
        String gosiaSharePost = gosia.sharePost();
        System.out.println("Gosia posted on: " + gosiaSharePost);

        //Then
        Assert.assertEquals("[FACEBOOK]", olafSharePost);
        Assert.assertEquals("[SNAPCHAT]", bambi34SharePost);
        Assert.assertEquals("[TWITTER]", gosiaSharePost);
    }
    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User bambi34 = new YGeneration("Basia M34");

        //When
        String bambi34SharePost = bambi34.sharePost();
        System.out.println("Bambi34 should posted on: " + bambi34SharePost);
        bambi34.setSocialArea(new FacebookPublisher());
        bambi34SharePost = bambi34.sharePost();
        System.out.println("Bambi34 now should posted on: " + bambi34SharePost);

        //Then
        Assert.assertEquals("[FACEBOOK]", bambi34SharePost);
    }


}
