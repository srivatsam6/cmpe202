import java.util.ArrayList;


/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardExp implements IDisplayComponent, IKeyEventHandler,IKeyPadSubject,IKeyPadObserver
{
	private ArrayList<IKeyPadObserver> observers ;
	private IKeyEventHandler nextHandler ;
	private String date = "" ;

	public CreditCardExp() {
		observers= new ArrayList<IKeyPadObserver>(); 
	}
	
    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( date.equals("") )
			return "[MM/YY]" + "  " ;
		else {
			String toDisplay=date;
			if(date.length()>=3) toDisplay=date.substring(0, 2)+"/"+date.substring(2);
			return "[" + toDisplay + "]" + "  " ;
		}
	}	

	public void key(String ch, int cnt) {
		if ( cnt >= 17 && cnt <= 20  ){
			if(ch.toLowerCase().equals("x")) {
				cnt-=2;
				if (date.length()>0) { 
					date=date.substring(0, date.length()-1);
					notifyObservers(cnt,"");
				}else notifyObservers(cnt,"x");   //hnote: -1 means no change, but need to notify pre display component
			}
			else date += ch ;
		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}
	
	 /**
     * Attach a Key Pad Observer
     * @param obj Observer
     */
    public void attach( IKeyPadObserver obj ) 
    {
        observers.add( obj ) ;
    }

    /**
     * Remove Key Pad Observer
     * @param obj Observer
     */
    public void removeObserver( IKeyPadObserver obj )
    {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }

    /**
     * Notify all Observers of Update Event
     */
    public void notifyObservers(int numKeys, String key )
    {
        for (int i=0; i<observers.size(); i++)
        {
            IKeyPadObserver observer = observers.get(i) ;
            observer.keyEventUpdate( numKeys, key ) ;
        }
    }

	@Override
	public void keyEventUpdate(int numKeys, String key) {
		if(key.toLowerCase().equals("x")) date=date.substring(0, date.length()-1);
		
	} 


}