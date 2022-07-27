package com.mgk.designmode.observe;

public interface  Subject {
     void registerObserve(Observer observer);
     void removeObserve(Observer observer);
     void notifyObserve();
}
