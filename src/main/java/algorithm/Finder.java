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
        SearchEngine engine = AlgoSupplier.supply(findCondition);
        return engine.search(groupSortedByAge);
    }

    public List<People> sortGroupByAge() {
        groupOfPeople.sort(Comparator
                .comparing(p -> p.getBirthDate().getTime(), Comparator.naturalOrder()));
        return List.copyOf(groupOfPeople);
    }

}
