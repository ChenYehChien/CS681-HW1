package edu.umb.cs681.hw01;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent> {
private Map<String, Float> map = new HashMap<String, Float>();
	
	public void changeQuote(String t, float q) {
		//update a map with t and q
		map.put(t, q);
		setChanged();
		notifyObservers(new StockEvent(t, q));
	}
}