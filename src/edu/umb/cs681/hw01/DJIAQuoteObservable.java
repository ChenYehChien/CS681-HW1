package edu.umb.cs681.hw01;

public class DJIAQuoteObservable extends Observable<DJIAEvent> {
	private float quote;
	
	public void changeQuote(float q) {
		quote = q;
		setChanged();
		notifyObservers(new DJIAEvent(quote)); 
	}
	
}