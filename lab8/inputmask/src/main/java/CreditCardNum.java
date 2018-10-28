import java.util.ArrayList;

/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements IDisplayComponent, IKeyEventHandler,IKeyPadSubject,IKeyPadObserver
{
	private ArrayList<IKeyPadObserver> observers ;
	private IKeyEventHandler nextHandler ;
	private String number = "" ;

	public CreditCardNum() {
		observers= new ArrayList<IKeyPadObserver>(); 
	}
	
    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( number.equals("") )
			return "[4444 4444 4444 4444]" + "  " ;
		else {
			String toDisplay=number;
			if(number.length()>12) toDisplay=number.substring(0, 4)+" "+number.substring(4, 8)+" "+number.substring(8,12)+" "+number.substring(12);
			else if(number.length()>8) toDisplay=number.substring(0, 4)+" "+number.substring(4, 8)+" "+number.substring(8);
			else if(number.length()>4) toDisplay=number.substring(0, 4)+" "+number.substring(4);

			return "[" + toDisplay + "]" + "  " ;
		}
	}	

	public void key(String ch, int cnt) {
		if ( cnt <= 16 ) {
			if(ch.toLowerCase().equals("x")) {
				cnt-=2;
				if (number.length()>0) { 
					number=number.substring(0, number.length()-1);
					notifyObservers(cnt,"");
				} else notifyObservers(0,"");
			}
			else number += ch ;
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
		if(key.toLowerCase().equals("x")) number=number.substring(0, number.length()-1);
		// TODO Auto-generated method stub
		
	} 

}