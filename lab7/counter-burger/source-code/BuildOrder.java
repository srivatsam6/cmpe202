  

public class BuildOrder {

    public static Component getOrder()
    {
    	String[][] allOptions= {{ "Orgainic Bison", "1/2lb.", "On A Bun" }, { "Yellow American", "Spicy Jalaperio Jack" },
    			 { "Danish Blue Cheese" },{ "Dill Pickle Chips", "Black Olives", "Spicy Pickles" },{ "Marinated Tomatoes" },
    			 { "Ciabatta(Vegan)" },{ "Shoestring Fries" }, { "Thai Peanut Sauce","Mayonnaise" },
    			 
    			 { "Hormone & Antibiotic Free Beef", "1/3lb.", "On A Bun" }, { "Greek Feta", "Smoked Gouda" },
        			 { "Fresh Mozzarella" },{ "Crushed Peanuts"},{ "Marinated Tomatoes","Sunny Side Up Egg" },
        			 { "Gluten-Free Bun" },{ "Shoestring Fries" }, { "Habanero Salsa" }
    			};
        Composite order = new Composite( "Order" ) ;

        for (int bi=0;bi<2;bi++) {
	        CustomBurger customBurger = new CustomBurger( "Build Your Own Burger" ) ;
	        // base price for 1/3 lb
	        Burger b = new Burger( "Burger Options" ) ;
	        String[] bo = allOptions[0+bi*8] ;
	        b.setOptions( bo ) ;
	        // 1 cheese free, extra cheese +1.00
	        Cheese c = new Cheese( "Cheese Options" ) ;
	        String[] co = allOptions[1+bi*8] ;
	        c.setOptions( co ) ;
	        c.wrapDecorator( b ) ;
	        
	        //2. Premium Cheese
	        CheesePremium pc = new CheesePremium( "Premium Cheese Options" ) ;
	        String[] pco = allOptions[2+bi*8] ;
	        pc.setOptions( pco ) ;
	        pc.wrapDecorator( c ) ;
	        
	        // 4 toppings free
	        Toppings t = new Toppings( "Toppings Options" ) ;
	        String[] to = allOptions[3+bi*8] ;
	        t.setOptions( to ) ;
	        t.wrapDecorator( pc ) ;
	        
	        // premium topping 
	        ToppingsPremium pt = new ToppingsPremium( "Premium Toppings Options" ) ;
	        String[] pto = allOptions[4+bi*8] ;
	        pt.setOptions( pto ) ;
	        pt.wrapDecorator( t ) ;
	
	        //  side 
	        Bun bun = new Bun( "Bun Options" ) ;
	        String[] buno = allOptions[5+bi*8];
	        bun.setOptions( buno ) ;
	        bun.wrapDecorator( pt ) ;
	        
	        
	        //  side 
	        Side side = new Side( "Side Options" ) ;
	        String[] sideo = allOptions[6+bi*8] ;
	        side.setOptions( sideo ) ;
	        side.wrapDecorator( bun ) ;
	        
	        // 3 sauce free, 
	        Sauce s = new Sauce( "Sauce Options" ) ;
	        String[] so = allOptions[7+bi*8] ;
	        s.setOptions( so ) ;
	        s.wrapDecorator(side ) ;
	        
	        // Setup Custom Burger Ingredients
	        customBurger.setDecorator( s ) ;
	        customBurger.addChild( b ) ;
	        customBurger.addChild( c ) ;
	        customBurger.addChild( pc ) ;
	        customBurger.addChild( s ) ;
	        customBurger.addChild( t ) ;
	        customBurger.addChild( pt ) ;
	        customBurger.addChild( side ) ;
	        
	        // Add Custom Burger to the ORder
	        order.addChild( customBurger );
        }
        
        
        return order ;
    }

}


/*

Counter Burger Menu:
https://thecounterburger.emn8.com/?store=Times%20Square

*/