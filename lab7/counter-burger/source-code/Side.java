import java.util.Arrays;

public class Side extends LeafDecorator {

    protected String[] options ;
    
    
    public Side( String d )
    {
        super(d) ;
    }
    
    // 1 cheese free, extra cheese +1.00
    public void setOptions( String[] options )
    {
        this.options = options ;
        if(Arrays.asList(options).contains("No Side")) this.price=0.0;
        else this.price += 3.00 ;
    }
    
    public String getDescription() 
    {
        String desc = "   " ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }        
        return desc ;
    }

}