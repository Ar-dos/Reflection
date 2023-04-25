package edu.school21.app;

import edu.school21.cars.Car;
import edu.school21.users.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Scanner;

public class Program {
    public static void main(String... args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);
        Object object = null;
        User user = new User();
        Car car = new Car();
        System.out.println("Classes:");
        System.out.println("  - " + user.getClass().getSimpleName());
        System.out.println("  - " + car.getClass().getSimpleName());
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        String input = sc.nextLine();
        if (input.equals(user.getClass().getSimpleName()))
            object = user;
        else if (input.equals(car.getClass().getSimpleName()))
            object = car;
        System.out.println("---------------------");
        System.out.println("fields:");
        for (int i = 0; i < object.getClass().getDeclaredFields().length; i++)
            System.out.println("    " + object.getClass().getDeclaredFields()[i].getGenericType().getTypeName() + " " + object.getClass().getDeclaredFields()[i].getName());
        System.out.println("methods:");
        for (int i = 0; i < object.getClass().getDeclaredMethods().length; i++)
            System.out.println("    " + object.getClass().getDeclaredMethods()[i].getName());
        System.out.println("---------------------");
        System.out.println("Let’s create an object.");
        object.getClass().newInstance();
        for (int i = 0; i < object.getClass().getDeclaredFields().length; i++) {
            Field field = object.getClass().getDeclaredFields()[i];
            System.out.println("    " + field.getName() + ":");
            field.setAccessible(true);
            if (field.getGenericType().getTypeName().equals("int"))
                field.set(object,Integer.parseInt(sc.nextLine()));
            else
            field.set(object,sc.nextLine());
        }

        System.out.println("Object updated: " + object.toString());
        System.out.println("---------------------");
        System.out.println("Enter name of the method for call:");
        String str = sc.nextLine();
        String methodName = str.substring(0,str.indexOf("("));
        String typeName = str.substring(str.indexOf("(")+1, str.indexOf(")"));
        Class type = null;
        if (typeName.equals("int"))
            type = int.class;
        else if (typeName.equals("String"))
            type = String.class;
        Method method = object.getClass().getDeclaredMethod(methodName,type);
        if (type != null) {
            System.out.println("Enter " + type.getName() + " value:");
            Object value;
            if (typeName.equals("int"))
                value = method.invoke(object,Integer.parseInt(sc.nextLine()));
            else
            value = method.invoke(object,sc.nextLine());
            System.out.println("Method returned:");
            System.out.println(value.toString());
        }
    }
}