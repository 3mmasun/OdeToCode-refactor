package algorithm;

import java.util.Date;

public class People implements Comparable<People> {
	private String name;
	private Date birthDate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int compareTo(People p) {
		return (int) (this.birthDate.getTime() - p.getBirthDate().getTime());
	}
}

