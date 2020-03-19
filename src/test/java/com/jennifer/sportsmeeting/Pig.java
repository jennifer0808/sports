package com.jennifer.sportsmeeting;

public class Pig extends Food {
    private Food basic_food;

    public Pig (Food basic_food){
        this.basic_food = basic_food;
    }
    public String make(){
        return basic_food.make()+"猪排";
    }
}
