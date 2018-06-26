package design.factoryPattern.abstractFactory.factory;

import design.factoryPattern.abstractFactory.car.BMW;
import design.factoryPattern.abstractFactory.car.BUICK;
import design.factoryPattern.abstractFactory.car.BenZ;
import design.factoryPattern.abstractFactory.car.Car;
import design.factoryPattern.abstractFactory.color.Color;

public class FactoryCar extends AbstractFactory{

    @Override
    public Color getColor(String color){
        return null;
    }

    @Override
    public Car product(String carType){
        if(carType == null){
            return null;
        }
        if(carType.equalsIgnoreCase("BenZ")){
            return new BenZ();
        } else if(carType.equalsIgnoreCase("BMW")){
            return new BMW();
        } else {
            return new BUICK();
        }
    }

}
