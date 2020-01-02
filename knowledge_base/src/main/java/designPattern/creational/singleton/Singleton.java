package designPattern.creational.singleton;

class Singleton {
    /*Singleton (Одиночка) - ограничивает создание одного экземпляра класса, обеспечивает доступ к его единственному объекту.
    *Ограничивает создание одного экземпляра класса, обеспечивает доступ к его единственному объекту.
    * Конструктор класса приватный. Метод getInstance() создает только один экземпляр класса.
    */

    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void setUp() {
        System.out.println("setUp");
    }
}

class SingletonTest {
    public static void main(String[] args){
        Singleton singelton = Singleton.getInstance();
        singelton.setUp();
    }
}
