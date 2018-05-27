package com.xyj.java8.ch02;

import java.util.ArrayList;
import java.util.List;

import com.xyj.java8.ch01.domain.Apple;

public class AppleTest {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        filterApples(inventory, new AppleGreenColorPredicate());//筛选绿色苹果
        prettyPrintApple(inventory, new AppleFancyFormatter());//打印苹果
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        Thread t = new Thread(() -> System.out.println("hello world"));

    }

    /**
     * 筛选绿苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();//累积苹果的列表
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {//仅选出绿苹果
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 把颜色作为参数
     *
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();//累积苹果的列表
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选重量大于XX的苹果
     *
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();//累积苹果的列表
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();//累积苹果的列表
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter f) {
        for (Apple apple : inventory) {
            String output = f.accept(apple);
            System.out.println(output);
        }
    }

}
