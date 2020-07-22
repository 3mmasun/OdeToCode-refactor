package algorithm;
public class Pair {
	private People personA;
	private People personB;
	private long durationApart;

	public Pair() {}

	public Pair(People personA, People personB) {
		this.personA = personA;
		this.personB = personB;
		this.durationApart = Math.abs(this.personA.getBirthDate().getTime() - this.personB.getBirthDate().getTime());
	}

	public People getPersonA() {
		return personA;
	}

	public People getPersonB() {
		return personB;
	}

	public long getDurationApart() {
		return durationApart;
	}
}
