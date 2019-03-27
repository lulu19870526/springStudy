package com.proxy.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;


/**
 * Javassit提供了运行时操作Java字节码的方法，其效率低于asm。
 * javassist主要是提供了代码级别的修改(也有bytecode级别)，相比与asm的字节码级别的修改，
 * 学习成本低，开发效率高。因此，在实际应用中javassist是一个非常不错的选择
 */
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

    /**
     *  ClassPool
     *      ClassPool是CtClass对象的容器，每一个CtClass对象都必须从ClassPool中获取。
     *       ClassPool自身可以形成层级结构，其工作机制与java的类加载器类似，只有当父节点找不到类文件时，才会调用子节点的get()方法。通过设置   ClassPath.childFirstLookup 属性可以调整其工作流程。
     *     需要注意的是ClassPool会在内存中维护所有被它创建过的CtClass，当CtClass数量过多时，会占用大量的内存，API中给出的解决方案是周期性的调用compress方法   或 重新创建ClassPool 或   有意识的调用CtClass的detach()方法以释放内存。
     *    需要关注的方法：
     *       1. getDefault   : 返回默认的ClassPool，单例模式！一般通过该方法创建我们的ClassPool。
     *      2. appendClassPath, insertClassPath    : 将一个ClassPath加到类搜索路径的末尾位置 或   插入到起始位置。通常通过该方法写入额外的类搜索路径，以解决多个类加载器环境中找不到类的尴尬。
     *      3. toClass : 将修改后的CtClass加载至当前线程的上下文类加载器中，CtClass的toClass方法是通过调用本方法实现。需要注意的是一旦调用该方法，则无法继续修改已经被加载的class。
     *     4. get , getCtClass : 根据类路径名获取该类的CtClass对象，用于后续的编辑。
     *
     *
     *
     *    ClassPath
     *      ClassPath是一个接口，代表类的搜索路径，含有具体的搜索实现。当通过其它途径无法获取要编辑的类时，可以尝试定制一个自己的ClassPath。API提供的实现中值得关注的有：
     *       1. ByteArrayClassPath : 将类以字节码的形式加入到该path中，ClassPool 可以从该path中生成所需的CtClass。
     *       2.  ClassClassPath : 通过某个class生成的path，通过该class的classloader来尝试加载指定的类文件。
     *       3.  LoaderClassPath : 通过某个classloader生成path，并通过该classloader搜索加载指定的类文件。需要注意的是该类加载器以弱引用的方式存在于path中，当不存在强引用时，随时可能会被清理。
     *
     *
     *
     * CtClass
     *     javassist为每个需要编辑的class都创建了一个CtClass对象，通过对CtClass对象的操作来实现对class的编辑工作。
     *     该类方法较多，此处列出需要重点关注的方法：
     *     1.freeze : 冻结一个类，使其不可修改。
     *     2. isFrozen :   判断一个类是否已被冻结。
     *    3.  prune   : 删除类不必要的属性，以减少内存占用。调用该方法后，许多方法无法将无法正常使用，慎用。
     *    4.defrost : 解冻一个类，使其可以被修改。如果事先知道一个类会被defrost， 则禁止调用 prune 方法。
     *    5. detach : 将该class从ClassPool中删除。
     *    6. writeFile : 根据CtClass生成 .class 文件。
     *   7.toClass : 通过类加载器加载该CtClass。
     *
     *
     *
     * CtMethod
     *    CtMthod代表类中的某个方法，可以通过CtClass提供的API获取或者CtNewMethod新建，通过CtMethod对象可以实现对方法的修改。          需要注意的是写入方法体的代码无法访问在其它地方定义的成员变量，一些比较重要的方法：
     *    1.      insertBefore   : 在方法的起始位置插入代码。
     *    2.      insterAfter : 在方法的所有 return 语句前插入代码以确保语句能够被执行，除非遇到exception。
     *   3.      insertAt : 在指定的位置插入代码。
     *   4.      setBody : 将方法的内容设置为要写入的代码，当方法被 abstract修饰时，该修饰符被移除。
     *   5.      make : 创建一个新的方法。
     *
     *
     *
     * CtNewMethod     提供各种静态方法来操作CtMethod，不进行详细描述，有兴趣可以看下API。
     */
}
