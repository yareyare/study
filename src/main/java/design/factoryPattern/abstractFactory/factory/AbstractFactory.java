package design.factoryPattern.abstractFactory.factory;

import design.factoryPattern.abstractFactory.car.Car;
import design.factoryPattern.abstractFactory.color.Color;

public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Car product(String carType);

}
