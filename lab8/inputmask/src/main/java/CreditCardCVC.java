import java.util.ArrayList;

/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardCVC implements IDisplayComponent, IKeyEventHandler,IKeyPadSubject
{
	private ArrayList<IKeyPadObserver> observers ;
	private IKeyEventHandler nextHandler ;
	private String cvc = "" ;

	public CreditCardCVC() {
		observers= new ArrayList<IKeyPadObserver>(); 
	}
	
    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( cvc.equals("") )
			return "[123]" + "  " ;
		else
			return "[" + cvc + "]" + "  " ;
	}	

	public void key(String ch, int cnt) {
		if ( cnt >= 21 ) {
			if ( cnt >= 21 && cnt <= 24 ) {  //add one more 24 to handle 456-x the x is the last input: 23-->24
				if(ch.toLowerCase().equals("x"))  {
					cnt-=2;
					if (cvc.length()>0) { 
						cvc=cvc.substring(0, cvc.length()-1);
						notifyObservers(cnt,"");
					}else notifyObservers(cnt,"x");  //hnote: -1 means no change, but need to notify pre display component
				} else if (cnt==24) notifyObservers(23,"");  //special handle, cnt no more than 23.
				else cvc += ch ;
			} 
			else if ( nextHandler != null )
				nextHandler.key(ch, cnt) ;
		}
		
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

}