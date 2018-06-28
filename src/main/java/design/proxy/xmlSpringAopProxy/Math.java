package design.proxy.xmlSpringAopProxy;

import org.apache.log4j.Logger;

import java.util.Random;

public class Math implements IMath {

    private Logger LOG = Logger.getLogger(Math.class.getName());

    @Override
    public int add(int a, int b) {
        lazy();
        int c = a + b;
        return c;
    }

    @Override
    public int sub(int a, int b) {
        lazy();
        int c = a - b;
        return c;
    }

    @Override
    public int mult(int a, int b) {
        lazy();
        int c = a * b;
        return c;
    }

    @Override
    public int div(int a, int b) throws Exception{
        if (b==0){
            throw new Exception("divide zero");
        }
        lazy();
        int c = a / b;
        return c;
    }

    private void lazy() {
        int second = new Random().nextInt(500);
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            LOG.error("Thread sleep Exception ", e);
        }
    }
}
