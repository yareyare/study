package design.adapter.class_adapter;

/**
 * 介绍：Adapter类：完成220V-5V的转变
 * 通过继承src类，实现 dst 类接口，完成src->dst的适配。
 */
public class VoltageAdapter extends Voltage220 implements Voltage5 {

    @Override
    public int output5V() {
        int voltage220v = output220V();
        int voltage5v = voltage220v / 44; // 在适配器中适配电压
        return voltage5v;
    }
}
