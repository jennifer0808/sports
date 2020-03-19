package com.jennifer.sportsmeeting;

/**
 * 装饰者模式
 */
public class Test {
    public static void main(String[] args) {
        Food food = new Bread(new Pig(new Food("豪大大")));
        System.out.println(food.make());
    }
}
