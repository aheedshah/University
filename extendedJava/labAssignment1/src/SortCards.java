import java.util.Comparator;
/**
 * This class compares two cards o2 and o2 and returns
 * integer values as described in the method implemented.*/
public class SortCards implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        //• Where o1 has a higher value property than o2 return 1.
        //• Where o1 has a lower value property than o2 return -1;
        //• Where the value property of both o1 and o2 is the same return 0.
        if(o1.getNumericValue() > o2.getNumericValue()){
            return 1;
        } else if(o1.getNumericValue()<o2.getNumericValue()){
            return -1;
        } else if(o1.getNumericValue() == o2.getNumericValue()){
            return 0;
        }
        return -2;
    }
}
