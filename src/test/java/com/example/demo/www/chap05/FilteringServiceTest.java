package com.example.demo.www.chap05;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.Test;

public class FilteringServiceTest {
	FilteringService fs = new FilteringService();
	
	@Test
	public void filterByVegetarianTEST(){
		assertEquals(asList(), fs.filterByVegetarian());
	}

	public void filterByElementTest(){
		assertEquals(asList(), fs.filterByVegetarian());
	}

	public void filterByCaloriesTest(){
		assertEquals(asList(), fs.filterByVegetarian());
	}

	public void myTakeWhileTest(){
		assertEquals(asList(), fs.filterByVegetarian());
	}

	public void myDropWhileTest(){
		assertEquals(asList(), fs.filterByVegetarian());
	}

	public void mySkipTest(){
		assertEquals(asList(), fs.filterByVegetarian());
	}

}
