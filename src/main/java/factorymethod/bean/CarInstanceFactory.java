package factorymethod.bean;

import factorymethod.Car;

import java.util.HashMap;
import java.util.Map;


/**
 * 实例工厂方法
 * 所谓实例工厂方式也很容易看懂， 就是里面的getBean 方法不是静态的， 也就是代表要先实例1个工厂对象， 才能依靠这个工厂对象去获得bean 对象。
 * factory-bean：用于实例化工厂类
 *
 */
public class CarInstanceFactory {
    private Map<Integer, Car> map = new HashMap<Integer,Car>();

    public void setMap(Map<Integer, Car> map) {
        this.map = map;
    }

    public CarInstanceFactory(){
    }

    public Car getCar(int id){
        return map.get(id);
    }
}
