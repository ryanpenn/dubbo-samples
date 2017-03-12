package cn.ryanpenn.dubbo.samples.javassist.sample;

/**
 * JavassistApp
 */
public class JavassistApp {

    public static void main(String[] args) throws Exception {

        TestBean bean = DynamicImplement.beanFactory();
        System.out.println(bean.hello());

        bean.setField("dubbo");
        System.out.println(bean.hello());

        TestAop aop = DynamicImplement.dynamicAop();
        aop.method();
    }
}
