package strategy_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

    public static void main( String[] args)
    {
        DataSet dataset = new DataSet() ; 

        List<SortingStrategy> sortingStrategies = new ArrayList<SortingStrategy>();
        sortingStrategies.add((a)-> { new BubbleSort().sort(a);});
        sortingStrategies.add((a)-> { new MergeSort().sort(a);});
        sortingStrategies.add((a)-> { new QuickSort().sort(a);});
        sortingStrategies.forEach(  (s) -> {dataset.changeStrategy(s); dataset.doSort(); dataset.display(); dataset.resetData(); } );
    }
 
}
 
