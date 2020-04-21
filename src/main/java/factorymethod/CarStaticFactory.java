package factorymethod;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法
 * 在工厂方法模式中， Spring不会直接利用反射机制创建bean对象， 而是会利用反射机制先找到Factory类，然后利用Factory再去生成bean对象。
 *所谓静态工厂方式就是指Factory类不本身不需要实例化， 这个Factory类中提供了1个静态方法来生成bean对象
 *
 * 静态方法：无须创建工厂类实例的情况下就可以调用工厂类方法
 * factory-method：用于调用工厂类方法。
 */
public class CarStaticFactory {

    private static Map<Integer, Car> map = new HashMap<Integer,Car>();

    static{
        map.put(1, new Car(1,"Honda",300000));
        map.put(2, new Car(2,"Audi",440000));
        map.put(3, new Car(3,"BMW",540000));
    }

    public static Car getCar(int id){
        return map.get(id);
    }
}
