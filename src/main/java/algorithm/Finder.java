package algorithm;

import java.util.Collections;
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
        Pair closest = compareEachPair(groupSortedByAge);

        switch (findCondition) {
            case Closest:
                return closest;
            case Furthest:
                Pair pair = new Pair();
                pair.personB = groupSortedByAge.get(0);
                pair.personA = groupSortedByAge.get(groupSortedByAge.size()-1);
                pair.durationApart = groupSortedByAge.get(groupSortedByAge.size()-1).getBirthDate().getTime() - groupSortedByAge.get(0).getBirthDate().getTime();
                return pair;
            default:
                return new Pair();
        }
    }

    private Pair compareEachPair(List<People> groupSortedByAge) {
        long minDuration = Long.MAX_VALUE;
        Pair pair = new Pair();

        for (int i = 0; i < groupSortedByAge.size() - 1; i++) {
            People withEarlierBirthday = groupSortedByAge.get(i);
            People withLaterBirthday = groupSortedByAge.get(i + 1);
            long durationApart = Math.abs(withLaterBirthday.getBirthDate().getTime() - withEarlierBirthday.getBirthDate().getTime());
            if (durationApart < minDuration) {
                minDuration = durationApart;
                pair.personB = withEarlierBirthday;
                pair.personA = withLaterBirthday;
                pair.durationApart = durationApart;
            }
        }
        return pair;
    }

    public List<People> sortGroupByAge() {
        if (groupOfPeople.size() == 0) return Collections.emptyList();
        groupOfPeople.sort(Comparator
                .comparing(p -> p.getBirthDate().getTime(), Comparator.naturalOrder()));
        return List.copyOf(groupOfPeople);
    }

}
