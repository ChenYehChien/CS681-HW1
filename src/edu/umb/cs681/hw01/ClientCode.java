package edu.umb.cs681.hw01;

public class ClientCode {
	public static void main(String[] args) {
		
		StockQuoteObservable observableS = new StockQuoteObservable();
		//Lambda Expression()
		observableS.addObserver((Observable<StockEvent> o, StockEvent obj) -> {
			StockEvent stockEvent = (StockEvent)obj;
			System.out.print(" Linechart :" +
							 " Ticker = " + stockEvent.getTicker() + " ; " + 
							 " Quote = "  + stockEvent.getQuote());
		});
		//observableS.addObserver();
		observableS.changeQuote("First Stock", 4000L); //arbitrary String and quote value
		//observableS.notifyObservers(obj);
		System.out.println();
		//-----------------------------------------------------------------------------------
		
		DJIAQuoteObservable observableD = new DJIAQuoteObservable();
		/*Lambda Expression()*/
		observableD.addObserver((Observable<DJIAEvent> o, DJIAEvent obj) -> {
			DJIAEvent djiaEvent = (DJIAEvent)obj;
			System.out.print(" Linechart :" +
							 " djia = " + djiaEvent.getDjia());
		});
		//observableD.addObserver();
		observableD.changeQuote(4000L); //arbitrary quote value
		//observableD.notifyObservers(obj);
	}
	
	//Questions:
	//1. Do we need to addObserver twice in the client code? or it's just an example?
	//2. notifyObservers is already triggered by the changeQuote, is it necessary to call it explicitly?
	//3. What do the lambda expression i specified really means?
	//   (Maybe we have to instantiate an event object as an input of lambda expression) 
}