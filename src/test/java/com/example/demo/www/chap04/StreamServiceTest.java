package com.example.demo.www.chap04;

import static org.junit.Assert.assertEquals;

import static java.util.Arrays.asList;

import org.junit.Test;

public class StreamServiceTest {
	StreamService s = new StreamService();
	@Test
	public void bookTitle() {
		assertEquals(asList("Java8", "Lambdas", "In", "Action"),s.bookTitle());
	}
	@Test
	public void menu() {
		assertEquals(9, s.menu.size());
	}
	@Test
	public void filterByWeight() {
		assertEquals(asList(new Dish("pork", false, 800, Type.MEAT)), s.filterByWeight(700));
	}
}
