package cn.ryanpenn.dubbo.samples.javassist.sample;

/**
 * TestAop
 */
public class TestAop {

    public void method() {
        try {
            System.out.println("doSomething");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
