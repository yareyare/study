package design.factoryPattern.factory;

public class BMW implements Car {

    public BMW() {
        System.out.println("BMW: 2000M" );
    }

    @Override
    public Car produce() {
        return new BMW();
    }
}
