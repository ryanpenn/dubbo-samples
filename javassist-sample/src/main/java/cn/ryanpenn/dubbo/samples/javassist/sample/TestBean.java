package cn.ryanpenn.dubbo.samples.javassist.sample;

/**
 * TestBean
 */
public abstract class TestBean {
    public String field;

    public abstract String hello();

    public abstract void setField(String f);

    public String getField() {
        return this.field;
    }
}
