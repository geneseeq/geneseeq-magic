package com.geneseeq.common.utils;

import org.springframework.scheduling.annotation.Async;

import java.util.Random;

public class test {

    public static boolean isTrueExpressNo(String str) {
        String regex = "^[a-z0-9A-Z_-]+$";
        return str.matches(regex);
    }

    public static void main(String[] args) throws Exception {

        String img = "sdfs";

        if (img != null && !img.equals("")) {
            System.out.println("123");
        }


    }

}
