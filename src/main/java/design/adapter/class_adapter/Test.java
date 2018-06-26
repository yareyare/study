package design.adapter.class_adapter;

public class Test {
    public static void main(String[] args) {
        System.out.println("===============类适配器==============");
        Mobile mobile = new Mobile();
        mobile.charging(new VoltageAdapter());
    }
}
