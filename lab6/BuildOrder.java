package composite;

public class BuildOrder {

    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;
        Composite customBurger = new Composite( "Five Guys Burger" ) ;
        customBurger.addChild(new Leaf("Bacon", 5.59 ));
        customBurger.addChild(new Leaf("Lettuce", 0.00 ));
        customBurger.addChild(new Leaf("Tomato", 0.00 ));
        customBurger.addChild(new Leaf("G Onion", 0.00 ));
        customBurger.addChild(new Leaf("JALA Grilled", 0.00 ));
        order.addChild( customBurger );
        return order ;
    }

}


