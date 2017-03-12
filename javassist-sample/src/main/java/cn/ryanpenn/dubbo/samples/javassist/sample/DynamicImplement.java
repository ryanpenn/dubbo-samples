package cn.ryanpenn.dubbo.samples.javassist.sample;

import javassist.*;

/**
 * DynamicImplement
 */
public class DynamicImplement {

    public static TestBean beanFactory() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        CtClass pt = pool.makeClass("asdf", pool.get("cn.ryanpenn.dubbo.samples.javassist.sample.TestBean"));
        CtMethod method1 = new CtMethod(pool.get("java.lang.String"), "hello", null, pt);
        method1.setBody("{return \"Hello,\" + this.field;}");
        pt.addMethod(method1);

        CtConstructor cc = new CtConstructor(null, pt);
        cc.setBody("this.field=\"javassist\";");
        pt.addConstructor(cc);

        CtMethod method2 = new CtMethod(CtClass.voidType, "setField",
                new CtClass[]{pool.get("java.lang.String")}, pt);
        method2.setBody("{this.field=$1;}");
        pt.addMethod(method2);

        Class<?> c = pt.toClass();
        return (TestBean) c.newInstance();
    }

    public static TestAop dynamicAop() throws Exception {

        // 用于取得字节码类，必须在当前的classpath中，使用全称
        CtClass ctClass = ClassPool.getDefault().get("cn.ryanpenn.dubbo.samples.javassist.sample.TestAop");

        // 需要修改的方法名称
        String mname = "method";
        CtMethod mold = ctClass.getDeclaredMethod(mname);
        // 修改原有的方法名称
        String nname = mname + "$impl";
        mold.setName(nname);

        // 创建新的方法，复制原来的方法
        CtMethod mnew = CtNewMethod.copy(mold, mname, ctClass, null);
        // 主要的注入代码
        StringBuffer body = new StringBuffer();
        body.append("{long start = System.currentTimeMillis();\n");
        // 调用原有代码，类似于method();($$)表示所有的参数
        body.append(nname + "($$);\n");
        body.append("System.out.println(\"Call to method " + mname
                + " took \" +\n (System.currentTimeMillis()-start) + "
                + "\" ms.\");\n");
        body.append("}");
        // 替换新方法
        mnew.setBody(body.toString());
        // 增加新方法
        ctClass.addMethod(mnew);

        // 类已经更改，注意不能使用TestAop aop = new TestAop();
        // 因为在同一个classloader中，不允许装载同一个类两次
        return (TestAop) ctClass.toClass().newInstance();
    }
}
