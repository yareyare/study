package design.factoryPattern.factory;

public class Factory {

    Car bayCar(String type) {
        if (type.equalsIgnoreCase("BMW")) {
            return new BenZ();
        } else if (type.equalsIgnoreCase("BMW")) {
            return new BMW();
        } else {
            return new BUICK();
        }
    }
}
