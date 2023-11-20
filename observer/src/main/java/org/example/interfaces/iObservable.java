package org.example.interfaces;

import org.example.implementations.Observer;

public interface iObservable {

    // Register methods
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);

    // Notify methods
    void notifyOne(Observer observer);
    void notifyEveryOne();

}
