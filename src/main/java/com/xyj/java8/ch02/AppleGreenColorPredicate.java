package com.xyj.java8.ch02;

import com.xyj.java8.ch01.domain.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
