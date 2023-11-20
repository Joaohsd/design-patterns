package org.example;

import org.example.implementations.Observable;
import org.example.implementations.Observer;

public class Main {
    public static void main(String[] args) {
        Observable observable = new Observable();

        String phrase1 = " Hello,     world ! I'm João   Henrique   ! ";

        Observer observer1 = new Observer(1);
        Observer observer2 = new Observer(2);
        Observer observer3 = new Observer(3);

        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);

        observable.processString(phrase1);

        try {
            observable.unregisterObserver(observer2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        String phrase2 = " Hello, world! ";

        observable.processString(phrase2);
    }
}