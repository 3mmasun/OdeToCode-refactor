package algorithm;

import java.util.List;

public class SearchFurthest implements SearchEngine {

    @Override
    public Pair search(List<People> groupSortedByAge) {
        return new Pair(groupSortedByAge.get(0), groupSortedByAge.get(groupSortedByAge.size()-1));
    }
}
