package com.xyj.java8.ch03;

import java.util.Comparator;

import com.xyj.java8.ch01.domain.Apple;

public class ComparatorTest {

    public static void main(String[] args) {

    }

    /**
     *  使用匿名内部类
     * @return
     */
    public Comparator<Apple> getAppleWeightComparator() {
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());

            }
        };
        return  byWeight;
    }

    /**
     * lamada
     * @return
     */
    public Comparator<Apple> getAppleWeightComparatorByLamada() {
        Comparator<Apple> byWeight = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
        return  byWeight;
    }

}
