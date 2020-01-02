package designPattern.behavioral.mediator;

public class Mediator {
    /*
    *Mediator (Посредник) - предоставляет класс посредника, который обрабатывает все коммуникации между различными классами.
     */
    public static void sendMessage(User user, String msg){
        System.out.println(user.getName() + ": " + msg);
    }
}
class User {
    private String name;
    public User(String name){
        this.name  = name;
    }
    public String getName() {
        return name;
    }
    public void sendMessage(String msg){
        Mediator.sendMessage(this, msg);
    }
}

class MediatorTest {//тест
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        user1.sendMessage("message1");
        user2.sendMessage("message2");
    }
}
