import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

	App app ;
	
	public CreditCardTest() {
		
	}
	   

	    @Before
	    public void setUp()
	    {
	        app = new App() ;  
	    }

	    @Test
	    public void CreditCardTest1()
	    {
	        String[] lines ;
	        lines = app.display().split("\n"); 
	        assertEquals("[4444 4444 4444 4444]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("1");
	    	app.key("2");
	        lines = app.display().split("\n"); 
	        assertEquals("[12]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("2");
	    	app.key("3");
	    	app.key("4");
	    	app.key("5");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("6");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 56]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("7");
	    	app.key("8");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("9");
	    	app.key("0");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 90]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("1");
	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 90]  [MM/YY]  [123]", lines[7].trim());
	    	app.key("1");
	    	app.key("2");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012]  [MM/YY]  [123]", lines[7].trim());
	        
	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 901]  [MM/YY]  [123]", lines[7].trim());

	    	app.key("2");
	    	app.key("1");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1]  [MM/YY]  [123]", lines[7].trim());

	    	app.key("2");
	    	app.key("2");
	    	app.key("1");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [MM/YY]  [123]", lines[7].trim());

	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 122]  [MM/YY]  [123]", lines[7].trim());

	    	app.key("1");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [MM/YY]  [123]", lines[7].trim());

	    	app.key("1");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [1]  [123]", lines[7].trim());

	    	app.key("2");
	    	app.key("2");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/2]  [123]", lines[7].trim());

	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12]  [123]", lines[7].trim());

	    	app.key("2");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/2]  [123]", lines[7].trim());

	    	app.key("2");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [123]", lines[7].trim());

	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/2]  [123]", lines[7].trim());

	    	app.key("2");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [123]", lines[7].trim());

	        //cvc
	    	app.key("4");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [4]", lines[7].trim());
	    	app.key("5");
	    	app.key("6");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [456]", lines[7].trim());
	        
	    	app.key("6");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [456]", lines[7].trim());

	        
	        app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [45]", lines[7].trim());
	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [4]", lines[7].trim());
	    	app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [12/22]  [123]", lines[7].trim());
	        
	        //drop MM/YY
	        for(int i=0;i<4;i++) app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[1234 5678 9012 1221]  [MM/YY]  [123]", lines[7].trim());
	        
	        //drop card number
	        for(int i=0;i<16;i++) app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[4444 4444 4444 4444]  [MM/YY]  [123]", lines[7].trim());
	        
	        
	        //continue drop, do nothing
	        for(int i=0;i<16;i++) app.key("x");
	        lines = app.display().split("\n"); 
	        assertEquals("[4444 4444 4444 4444]  [MM/YY]  [123]", lines[7].trim());
	        
	        
	    }

}
