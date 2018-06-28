package design.proxy.proxyDynamicCglib;

import org.apache.log4j.Logger;

import java.util.Random;

public class Math {

    private Logger LOG = Logger.getLogger(Math.class.getName());

    public int add(int a, int b) {
        lazy();
        int c = a + b;
        return c;
    }

    public int sub(int a, int b) {
        lazy();
        int c = a - b;
        return c;
    }

    public int mult(int a, int b) {
        lazy();
        int c = a * b;
        return c;
    }

    public int div(int a, int b) {
        lazy();
        int c = a / b;
        return c;
    }

    private  void lazy() {
        int second = new Random().nextInt(500);
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            LOG.error("Thread sleep Exception ", e);
        }
    }
}
