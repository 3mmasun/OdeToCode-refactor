package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<People> groupOfPeople;

	public Finder(List<People> p) {
		groupOfPeople = p;
	}

	public Pair Find(FindCondition findCondition) {
		List<Pair> resultPair = new ArrayList<Pair>();

		for (int i = 0; i < groupOfPeople.size() - 1; i++) {
			for (int j = i + 1; j < groupOfPeople.size(); j++) {
				Pair pair = new Pair();
				if (groupOfPeople.get(i).getBirthDate().getTime() < groupOfPeople.get(j).getBirthDate().getTime()) {
					pair.personA = groupOfPeople.get(i);
					pair.personB = groupOfPeople.get(j);
				} else {
					pair.personA = groupOfPeople.get(j);
					pair.personB = groupOfPeople.get(i);
				}
				pair.daysApart = pair.personB.getBirthDate().getTime() - pair.personA.getBirthDate().getTime();
				resultPair.add(pair);
			}
		}

		if (resultPair.size() < 1) {
			return new Pair();
		}

		Pair answer = resultPair.get(0);
		for (Pair result : resultPair) {
			switch (findCondition) {
				case Closest:
					if (result.daysApart < answer.daysApart) {
						answer = result;
					}
					break;

				case Furthest:
					if (result.daysApart > answer.daysApart) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
