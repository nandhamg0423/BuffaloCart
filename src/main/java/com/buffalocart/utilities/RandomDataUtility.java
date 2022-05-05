package com.buffalocart.utilities;

import org.testng.annotations.Test;

import java.util.Random;

public class RandomDataUtility {
    @Test
    public String random() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email = "testmail" + randomInt + "@gmail.com";
        System.out.println(email);
        return email;
    }

    @Test
    public String randomId() {
        Random rand = new Random();
        int randomId=rand.nextInt(10000);
        String id="1" +randomId +"8";
        return id;
    }
}