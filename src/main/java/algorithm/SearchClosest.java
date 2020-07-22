package algorithm;

import java.util.List;

public class SearchClosest implements SearchEngine {

    @Override
    public Pair search(List<People> groupSortedByAge) {
        long minDuration = Long.MAX_VALUE;
        Pair closest = new Pair();

        for (int i = 0; i < groupSortedByAge.size() - 1; i++) {
            Pair pair = new Pair(groupSortedByAge.get(i), groupSortedByAge.get(i+1));
            if (pair.getDurationApart() < minDuration) {
                minDuration = pair.getDurationApart();
                closest = pair;
            }
        }
        return closest;
    }
}
