import java.util.Arrays;

public class ToppingsPremium extends Toppings {

	   public ToppingsPremium( String d )
	    {
	        super(d) ;
	    }
	   
	    //  +1.5 per
	    public void setOptions( String[] options )
	    {
	        this.options = options ;
	        if(Arrays.asList(options).contains("Marinated Tomatoes")) {
	        	this.price +=3;
	        	this.price +=(options.length-1) * 1;
	        }
	        else this.price +=options.length * 1;
	    }
}