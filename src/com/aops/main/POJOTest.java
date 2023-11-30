package com.aops.main;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class POJOTest {
    private POJO pojo = new POJO(50, "B", Color.GREEN);

    public POJOTest() {
        displayAllMethods();
        displayAllFields();
    }

    public void displayAllMethods() {
        System.out.println("Should display non-private methods.");
        System.out.println("This is currently failing when attempting to grab the parameters with reflection.");
        for (Method method : pojo.getClass().getDeclaredMethods()) {
            System.out.println(method.getName() + "()");

            Parameter[] parameters = method.getParameters();
            // Failing to grab parameters with reflection.
            // for (int i = 0; i < parameters.length; i++) {
            //     Parameter parameter = parameters[i];
            //     System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName());
            //     if (i < parameters.length - 1) {
            //         System.out.print(", ");
            //     }
            // }

            // System.out.println(")");

        }
    }

    public void displayAllFields() {
        System.out.println("Should display non-private fields (string)");
        for (Field field : pojo.getClass().getFields()) {
            System.out.println(field.getName());
        }
    }
}
