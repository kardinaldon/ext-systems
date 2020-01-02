package designPattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    /*
    *Memento (Хранитель) - используется для хранения состояния объекта, позже это состояние можно восстановить.
     */
    private String name;
    private int age;
    public Memento(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
class User {
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(String.format("create: name = %s, age = %s", name, age));
    }
    public Memento save(){
        System.out.println(String.format("save: name = %s, age = %s", name, age));
        return new Memento(name, age);
    }
    public void restore(Memento memento){
        name = memento.getName();
        age = memento.getAge();
        System.out.println(String.format("restore: name = %s, age = %s", name, age));
    }
}
class SaveUser {
    private List<Memento> list = new ArrayList<Memento>();
    public void add(Memento memento){
        list.add(memento);
    }
    public Memento get(int ind){
        return list.get(ind);
    }
}

class MementoTest { // Test
    public static void main(String[] args) {
        SaveUser saveUser = new SaveUser();
        User user1 = new User("Peter", 17);
        User user2 = new User("Ian", 19);
        saveUser.add(user1.save());
        user1.restore(saveUser.get(0));
    }
}