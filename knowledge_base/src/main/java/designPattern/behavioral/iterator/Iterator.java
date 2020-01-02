package designPattern.behavioral.iterator;

interface Iterator {
    /*
    *Iterator (Итератор) - последовательно осуществляет доступ к элементам объекта коллекции, не зная его основного представления.
     */
    boolean hasNext();
    Object next();
}
class Numbers {
    public int num[] = {1 , 2, 3};
    public Iterator getIterator() {
        return new NumbersIterator();
    }
    private class NumbersIterator implements Iterator {
        int ind;
        public boolean hasNext() {
            if(ind < num.length) return true;
            return false;
        }
        public Object next() {
            if(this.hasNext()) return num[ind++];
            return null;
        }
    }
}

class IteratorTest {//тест
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        Iterator iterator = numbers.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
