package algorithm;

import java.util.Comparator;
import java.util.List;

public class Finder {
    private final List<People> groupOfPeople;

    public Finder(List<People> p) {
        groupOfPeople = p;
    }

    public Pair find(FindCondition findCondition) {
        if (groupOfPeople.size() < 2) return new Pair();

        List<People> groupSortedByAge = sortGroupByAge();
        switch (findCondition) {
            case Closest:
                return findClosestPair(groupSortedByAge);
            case Furthest:
                return findFurthestPair(groupSortedByAge);
            default:
                return new Pair();
        }
    }

    private Pair findFurthestPair(List<People> groupSortedByAge) {
        return new Pair(groupSortedByAge.get(0), groupSortedByAge.get(groupSortedByAge.size()-1));
    }

    private Pair findClosestPair(List<People> groupSortedByAge) {
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

    public List<People> sortGroupByAge() {
        groupOfPeople.sort(Comparator
                .comparing(p -> p.getBirthDate().getTime(), Comparator.naturalOrder()));
        return List.copyOf(groupOfPeople);
    }

}
