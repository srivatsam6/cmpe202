package chain_of_responsibility_lambda;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Client {

    public void runTest()
    {
        
        ArrayList<String> requests=new ArrayList<String>();
        requests.add("R2");
        requests.add("R3");
        requests.add("R1");
        requests.add("RX");

        // Predicate functions
        Predicate<String> h1Tester =  (a) -> a.equalsIgnoreCase("R1");		
        Predicate<String> h2Tester  = (a) -> a.equalsIgnoreCase("R2");
        Predicate<String> h3Tester  = (a) -> a.equalsIgnoreCase("R3");

   	
        Handler h1 = new ConcreteHandler1(h1Tester) ;
        Handler h2 = new ConcreteHandler2(h2Tester) ;
        Handler h3 = new ConcreteHandler3(h3Tester) ;
      	
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

     
        requests.stream().forEach(p -> {System.out.println( "Sending "+p+"..."); h1.handleRequest(p);});

    }
 
    
    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }
    

}
