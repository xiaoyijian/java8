package com.xyj.java8.ch02;

import com.xyj.java8.ch01.domain.Apple;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";

        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
