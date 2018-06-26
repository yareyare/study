package design.factoryPattern.abstractFactory.color;

public class Red implements Color {

    public Red() {
        System.out.println("RED");
    }

    @Override
    public void fill() {
        System.out.println("filled  RED ^-^");
    }
}
