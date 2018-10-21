
public class CheesePremium extends Cheese {

    public CheesePremium( String d )
    {
        super(d) ;
    }
    
    // 1 cheese free, extra cheese +1.50
    public void setOptions( String[] options )
    {
        this.options = options ;
        this.price += options.length * 1.50 ;
    }
}