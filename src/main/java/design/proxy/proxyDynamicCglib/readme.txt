1.引入cglib包
cglib 包含了
asm.jar  : 类生成器
ant.jar
ant-launcher.jar

2.目标类实现

3.动态代理：实现一个方法拦截器:MethodInterceptor

cglib继承被代理的类，重写方法，织入通知，动态生成字节码并运行，因为是继承所以final类是没有办法动态代理的
注意：1.使用cglib可以实现动态代理，即使被代理的类没有实现接口，但被代理的类必须不是final类
      2.如果是static修饰的方法，则不会被织入代理服务