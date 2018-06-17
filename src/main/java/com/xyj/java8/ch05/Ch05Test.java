package com.xyj.java8.ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.xyj.java8.ch04.Dish;

public class Ch05Test {
    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(100, "d1", true));
        dishes.add(new Dish(200, "d2", false));
        dishes.add(new Dish(300, "d3", true));
        dishes.add(new Dish(400, "d4", false));
        System.out.println(getVegetarianDishes(dishes));

    }

    /**
     * 用谓词筛选 filter Predicate
     * @param menu
     * @return
     */
    private static List<Dish> getVegetarianDishes(List<Dish> menu) {
        return menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
    }

    /**
     * distinct hashcode, equals
     * @param numbers
     */
    private void getEvenNums(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i %2==0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * limit
     * @param menu
     * @return
     */
    private List<Dish> get3HighCaloriesDishes(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * skip
     * @param menu
     * @return
     */
    private List<Dish> getSkip2HighCaloriesDishes(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }

    /**
     * 获取菜肴的名称
     * map Function
     * @param menu
     * @return
     */
    private List<String> getMenuNames(List<Dish> menu) {
        return menu.stream().map(Dish::getName).collect(Collectors.toList());
    }

    /**
     * 获取菜肴名称的长度
     * @param menu
     * @return
     */
    private List<Integer> getMenuNameLengths(List<Dish> menu) {
        return menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
    }


}
