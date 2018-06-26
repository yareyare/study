package design.factoryPattern.abstractFactory.factory;

import design.factoryPattern.abstractFactory.car.Car;
import design.factoryPattern.abstractFactory.color.Color;
import design.factoryPattern.abstractFactory.color.Green;
import design.factoryPattern.abstractFactory.color.Red;

public class FactoryColor extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("red")) {
            return new Red();
        } else if (color.equalsIgnoreCase("green")) {
            return new Green();
        } else {
            return new Red();
        }
    }

    @Override
    public Car product(String carType) {
        return null;
    }

}
