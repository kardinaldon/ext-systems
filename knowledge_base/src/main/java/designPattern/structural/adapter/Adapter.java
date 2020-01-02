package designPattern.structural.adapter;

public class Adapter {
    /*Adapter (Адаптер) - это конвертер между двумя несовместимыми объектами. Используя паттерн адаптера, мы можем объединить два несовместимых интерфейса.
    *Используя паттерн, мы можем объединить два несовместимых объекта. Конвертер между двумя несовместимыми объектами.
     */
}
class PBank {
    private int balance;
    public PBank() { balance = 100; }
    public void getBalance() {
        System.out.println("PBank balance = " + balance);
    }
}
class ABank {
    private int balance;
    public ABank() { balance = 200; }
    public void getBalance() {
        System.out.println("ABank balance = " + balance);
    }
}
class PBankAdapter extends PBank {
    private ABank abank;
    public PBankAdapter(ABank abank) {
        this.abank = abank;
    }
    public void getBalance() {
        abank.getBalance();
    }
}

class AdapterTest {//тест
    public static void main(String[] args) {
        PBank pbank = new PBank();
        pbank.getBalance();
        PBankAdapter abank = new PBankAdapter(new ABank());
        abank.getBalance();
    }
}
