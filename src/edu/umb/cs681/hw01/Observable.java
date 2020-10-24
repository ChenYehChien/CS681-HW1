package edu.umb.cs681.hw01;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable<T> {
	private List<Observer<T>> observers;
	private boolean change = false; //new added
	
	public Observable () {
		observers = new LinkedList<Observer<T>>(); 
	}
	//LE
	//it is not the same as some observer already in the set
	public void addObserver(Observer<T> o) {
		if (observers.contains(o))
			return;
		observers.add(o);
	}
	//LE
	//Deletes an observer from the set of observers of this object
	public void deleteObserver(Observer<T> o) {
		observers.remove(o);
	}
	protected void setChanged() {
		change = true;
	};
	protected void clearChanged() {
		change = false;
	};
	public boolean hasChanged() {
		//true if and only if the setChanged method has been called 
		//more recently than the clearChanged method on this object; 
		//false otherwise.
		if (change)
			return true;
		return false;
	}
	public void notifyObservers(T obj) {
		if (hasChanged()) {
			for (Observer<T> o: observers) {
				o.update(this, obj);
			}
			clearChanged();
		}
	}
	
}