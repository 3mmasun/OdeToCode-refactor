package test;
import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.Pair;
import algorithm.FindCondition;
import algorithm.Finder;
import algorithm.People;

public class FinderTests {

	People sue = new People();
	People greg = new People();
	People sarah = new People();
	People mike = new People();

	@Before
	public void setup() {
		sue.setName("Sue");
		sue.setBirthDate(new Date(50, Calendar.JANUARY, 1));
		greg.setName("Greg");
		greg.setBirthDate(new Date(52, Calendar.JUNE, 1));
		sarah.setName("Sarah");
		sarah.setBirthDate(new Date(82, Calendar.JANUARY, 1));
		mike.setName("Mike");
		mike.setBirthDate(new Date(79, Calendar.JANUARY, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<People> list = new ArrayList<People>();
		Finder finder = new Finder(list);

		Pair result = finder.find(FindCondition.Closest);
		assertEquals(null, result.youngerPerson);
		assertEquals(null, result.olderPerson);
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<People> list = new ArrayList<People>();
		list.add(sue);

		Finder finder = new Finder(list);

		Pair result = finder.find(FindCondition.Closest);

		assertEquals(null, result.youngerPerson);
		assertEquals(null, result.olderPerson);
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<People> list = new ArrayList<People>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Pair result = finder.find(FindCondition.Closest);

		assertEquals(sue, result.youngerPerson);
		assertEquals(greg, result.olderPerson);
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<People> list = new ArrayList<People>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Pair result = finder.find(FindCondition.Furthest);

		assertEquals(greg, result.youngerPerson);
		assertEquals(mike, result.olderPerson);
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<People> list = new ArrayList<People>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Pair result = finder.find(FindCondition.Furthest);

		assertEquals(sue, result.youngerPerson);
		assertEquals(sarah, result.olderPerson);
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<People> list = new ArrayList<People>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Pair result = finder.find(FindCondition.Closest);

		assertEquals(sue, result.youngerPerson);
		assertEquals(greg, result.olderPerson);
	}

	@Test
	public void Return_EmptyList_For_EmptyList () {
		List<People> people = new ArrayList<People>();
		Finder finder = new Finder(people);

		List<People> peopleByAge = finder.sortGroupByAge();
		assertEquals(Collections.emptyList(), peopleByAge);
	};

	@Test
	public void Return_SingleList_For_One_People () {
		List<People> people = new ArrayList<People>();
		people.add(sue);
		Finder finder = new Finder(people);

		List<People> peopleByAge = finder.sortGroupByAge();
		assertEquals(1, peopleByAge.size());
		assertEquals(sue, peopleByAge.get(0));
	};

	@Test
	public void Return_List_Sorted_By_Age_Ascending_For_Two_People () {
		List<People> people = new ArrayList<People>();
		people.add(sue);
		people.add(greg);
		Finder finder = new Finder(people);

		List<People> peopleByAge = finder.sortGroupByAge();
		assertEquals(2, peopleByAge.size());
		assertEquals(greg, peopleByAge.get(0));
		assertEquals(sue, peopleByAge.get(1));
	};

}
