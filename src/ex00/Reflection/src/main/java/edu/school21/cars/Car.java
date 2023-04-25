package edu.school21.cars;

import edu.school21.users.User;

import java.util.StringJoiner;

public class Car {

    private String model;
    private int price;
    private int speed;

    public Car() {
        this.model = "Default model name";
        this.price = 0;
        this.speed = 0;
    }

    public Car(String model, int price, int speed) {
        this.model = model;
        this.price = price;
        this.speed = speed;
    }

    public int raisePrice(int value) {
        this.price += value;
        return price;
    }

    public int speedUp(int value) {
        this.speed += value;
        return speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
