package thinking.array;

import java.util.Vector;

/**
 * 类型擦除
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/18 17:48
 */
public class CatsAndDogs {
    public static void main(String[] args) {
        Vector cats = new Vector();
        for (int i = 0; i < 7; i++) {
            cats.addElement(new Cat(i));
//            cats.addElement(new Dog(i));
        }
        for (int i = 0; i < 7; i++) {
            ((Cat) cats.elementAt(i)).print();
        }
    }
}

class Cat {
    private int catNum;

    Cat(int i) {
        catNum = i;
    }

    void print() {
        System.out.println("Cat #" + catNum);
    }
}

class Dog {
    private int dogNum;

    Dog(int i) {
        dogNum = i;
    }

    void print() {
        System.out.println("Dog #" + dogNum);
    }
}
