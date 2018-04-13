package com.xyj.java8.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.xyj.java8.ch01.domain.Apple;

/**
 * 筛选苹果
 */
public class AppleTest {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        filterApples(inventory, Apple::isGreenApple);//传递了方法，但是写只用一次的方法没有必要
        filterApples(inventory, Apple::isHeavyApple);

        filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));//Lambda
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        filterApples(inventory, (Apple a) -> "brown".equals(a.getColor()) || a.getWeight() > 80);//Lambda的长度过长，应该写成方法，清晰度更重要
    }

    /**
     * 筛选绿色苹果
     * 不灵活
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选重苹果
     * 拷贝代码，冗余
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }



    /**
     * 过滤各种条件的苹果
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
