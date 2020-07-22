package algorithm;

public class AlgoSupplier {

    public static SearchEngine supply(FindCondition condition) {
        switch (condition){
            case Closest:
                return new SearchClosest();
            default:
                return new SearchFurthest();
        }
    }
}
