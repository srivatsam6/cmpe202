/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

/**
 *  Main App Class for Displaying Screen.
 */
public class App implements IKeyPadObserver{

    private Screen screen;
    private CreditCardNum num;
    private CreditCardExp exp;
    private CreditCardCVC cvc;
    private int count;

    public App() {

        screen = new Screen();
        num = new CreditCardNum();
        exp = new CreditCardExp();
        cvc = new CreditCardCVC();

        screen.addSubComponent(num);
        screen.addSubComponent(exp);
        screen.addSubComponent(cvc);

        //implement observer pattern
        ((IKeyPadSubject)num).attach((IKeyPadObserver)this);
        ((IKeyPadSubject)exp).attach((IKeyPadObserver)this);
        ((IKeyPadSubject)cvc).attach((IKeyPadObserver)this);
        
        //to handle X key
        ((IKeyPadSubject)exp).attach((IKeyPadObserver)num);
        ((IKeyPadSubject)cvc).attach((IKeyPadObserver)exp);
        
        count = 0;

    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    public void key(String ch) {
    	if(ch.length()==1 && (ch.toLowerCase().equals("x") || (ch.charAt(0)>=48 && ch.charAt(0)<=57) )) {
	        count++;
	        screen.key(ch, count);
	        //System.out.printf("\ncount:%s; key:%s\n",count,ch);
    	}
    }

	@Override
	public void keyEventUpdate(int numKeys, String key) {
		if(numKeys>=0) count=numKeys;
		//System.out.printf("\ncount:%s; key:%s\n",numKeys,key);
		// TODO Auto-generated method stub
	}

}

