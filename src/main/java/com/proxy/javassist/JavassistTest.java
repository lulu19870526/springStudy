package com.proxy.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

public class JavassistTest {

    public static void main(String[] args){
        try {
            ClassPool classPool = ClassPool.getDefault();
            classPool.appendClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
            CtClass ctClass = classPool.getCtClass("com.proxy.javassist.Old");
            CtMethod ctMethod = ctClass.getDeclaredMethod("sayHello");
            // 修改原方法
            ctMethod.setBody("{System.out.println(\"beijing welcome you\");}");

            // 加载和执行生成的类
            Class<?> clazz = ctClass.toClass();
            Object obj = clazz.newInstance();
            clazz.getMethod("sayHello").invoke(obj);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
