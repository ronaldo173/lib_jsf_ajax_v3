package ua.ronaldo173.library.web.validators;

/**
 * Created by Developer on 19.04.2016.
 */
public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            System.out.println(i+1);
            System.out.println(i);
            System.out.println("\n");
        }
    }
}

class A {
    public A() {
        print();
    }

    final void print() {
        System.out.println("A");
    }
}

class B extends A {
    void print1() {
        System.out.println("B");
    }
}