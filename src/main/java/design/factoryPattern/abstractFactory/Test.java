package design.factoryPattern.abstractFactory;

import design.factoryPattern.abstractFactory.car.Car;
import design.factoryPattern.abstractFactory.color.Color;
import design.factoryPattern.abstractFactory.factory.AbstractFactory;
import design.factoryPattern.abstractFactory.factory.FactoryProducer;

public class Test {

    public static void main(String[] args) {
        AbstractFactory carFactory = FactoryProducer.getFactory("car");
        Car benz = carFactory.product("benz");


        AbstractFactory color = FactoryProducer.getFactory("color");
        Color redColor = color.getColor("red");
        redColor.fill();
    }
}
