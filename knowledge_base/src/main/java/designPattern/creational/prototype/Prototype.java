package designPattern.creational.prototype;

public class Prototype {

    /*Prototype (Прототип) - помогает создать дублированный объект с лучшей производительностью, вместо нового, создается возвращаемый клон существующего объекта.
    *Помогает создать дублированный объект с лучшей производительностью, вместо нового создается возвращаемый клон существующего объекта. Клонирует существующий объект.
     */
}
interface Copyable {
    Copyable copy();
}
class ComplicatedObject implements Copyable {
    private Type type;
    public enum Type {
        ONE, TWO
    }
    public ComplicatedObject copy() {
        ComplicatedObject complicatedobject = new ComplicatedObject();
        return complicatedobject;
    }
    public void setType(Type type) {
        this.type = type;
    }
}

class PrototypeTest {//тест
    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone = prototype.copy();
        clone.setType(ComplicatedObject.Type.ONE);
    }
}
