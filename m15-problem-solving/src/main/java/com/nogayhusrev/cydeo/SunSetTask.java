package com.nogayhusrev.cydeo;


import java.util.ArrayList;
import java.util.Stack;

public class SunSetTask {

    public static void main(String[] args) {

        int[] buildings = {1, 1, 3, 4, 3, 1, 3, 2};
        //sunSet(buildings,"East".toUpperCase()).forEach(System.out::print);
        sunSet(buildings, "west".toUpperCase()).forEach(System.out::print);


    }

    public static ArrayList<Integer> sunSet(int[] buildings, String direction) {

        Stack<Integer> stack = new Stack<>();

        if (direction.equalsIgnoreCase("EAST")) {
            for (int i = 0; i < buildings.length; i++) {
                while (!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]) {
                    stack.pop();
                }
                stack.push(i);
            }
        } else if (direction.equalsIgnoreCase("WEST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]) {
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return new ArrayList<>(stack);

    }


}
