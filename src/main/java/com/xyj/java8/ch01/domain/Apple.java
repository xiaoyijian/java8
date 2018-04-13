package com.xyj.java8.ch01.domain;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private int weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
