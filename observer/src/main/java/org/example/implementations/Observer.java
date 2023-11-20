package org.example.implementations;

import org.example.interfaces.iObserver;

public class Observer implements iObserver {

    private Integer _id;

    public Observer(Integer id) {
        _id = id;
    }

    public Integer getId() {
        return _id;
    }

    @Override
    public void update(Observable observable) {
        System.out.println("Observer " + _id + " was notified by Observable");
        System.out.println("Number of words: " + observable.getCountWords());
        System.out.println("Number of words with even lenght: " + observable.getCountWordsWithEvenCharacters());
        System.out.println("Number of words with upper at begin: " + observable.getCountWordsWithUpperAtBegin() + "\n");
    }

}
