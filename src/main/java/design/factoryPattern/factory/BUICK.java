package design.factoryPattern.factory;

public class BUICK implements Car {

    public BUICK() {
        System.out.println("BUICK: 2000M" );
    }

    @Override
    public Car produce() {
        return new BUICK();
    }
}
