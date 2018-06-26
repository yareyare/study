package design.factoryPattern.factory;

public class BenZ implements Car{

    public BenZ() {
        System.out.println("BenZ: 1800M" );
    }

    @Override
    public Car produce() {
        return new BenZ() ;
    }
}
