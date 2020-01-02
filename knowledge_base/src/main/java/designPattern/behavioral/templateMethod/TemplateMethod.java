package designPattern.behavioral.templateMethod;

public class TemplateMethod {
    /*Template Method (Шаблонный метод) - определяющий основу алгоритма и позволяющий наследникам переопределять некоторые шаги алгоритма, не изменяя его структуру в целом.
    *
     */
}
abstract class Car {
    abstract void startEngine();
    abstract void stopEngine();

    public final void start(){
        startEngine();
        stopEngine();
    }
}
class OneCar extends Car {
    public void startEngine() {
        System.out.println("Start engine.");
    }
    public void stopEngine() {
        System.out.println("Stop engine.");
    }
}
class TwoCar extends Car {
    public void startEngine() {
        System.out.println("Start engine.");
    }
    public void stopEngine() {
        System.out.println("Stop engine.");
    }
}

class TemplateTest {//тест
    public static void main(String[] args) {
        Car car1 = new OneCar();
        car1.start();
        System.out.println();
        Car car2 = new TwoCar();
        car2.start();
    }
}
