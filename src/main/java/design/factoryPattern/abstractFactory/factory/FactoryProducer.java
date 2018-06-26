package design.factoryPattern.abstractFactory.factory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("car")) {
            return new FactoryCar();
        } else if (choice.equalsIgnoreCase("color")) {
            return new FactoryColor();
        }
        return null;
    }
}
