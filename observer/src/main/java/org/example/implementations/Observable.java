package org.example.implementations;

import org.example.interfaces.iObservable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Observable implements iObservable {

    private List<Observer> _observerList;

    private List<String> _splittedString;

    public Observable() {
        _splittedString = new ArrayList<>();
        _observerList = new ArrayList<>();
    }

    List<Observer> getObserverList(){
        return _observerList;
    }

    @Override
    public void registerObserver(Observer observer) {
        _observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws NoSuchElementException{
        // Remove observer
        if(_observerList.contains(observer))
            _observerList.remove(observer);
        else throw new NoSuchElementException("Element with id " + observer.getId() + " not found");
    }

    @Override
    public void notifyOne(Observer observer) {
        observer.update(this);
    }

    @Override
    public void notifyEveryOne() {
        _observerList.forEach( observer -> {
            observer.update(this);
        });
    }

    public void processString(String string){
        // Add new elements to the list
        _splittedString = List.of(string.trim().split("[^\\p{L}]+"));
        // Notify all observers registered in the list
        notifyEveryOne();
    }

    public Integer getCountWords(){
        return _splittedString.size();
    }

    public Integer getCountWordsWithEvenCharacters(){
        Integer counter = 0;
        for (String e: _splittedString) {
            if(e.length() % 2 == 1)
                counter++;
        }
        return counter;
    }

    public Integer getCountWordsWithUpperAtBegin(){
        Integer counter = 0;
        for (String e: _splittedString) {
            if(Character.isUpperCase(e.charAt(0)))
                counter++;
        }
        return counter;
    }
}
