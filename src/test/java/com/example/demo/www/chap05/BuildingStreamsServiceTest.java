package com.example.demo.www.chap05;

import static org.junit.Assert.*;
import static java.util.Arrays.asList;

import org.junit.Test;

public class BuildingStreamsServiceTest {
	BuildingStreamsService bs = new BuildingStreamsService();
	@Test
	public void testMyOf() {
		assertEquals(asList("JAVA 8", "LAMBDAS", "IN", "ACTION"), bs.myOf());
	}

	@Test
	public void testMySum() {
		assertEquals(41, bs.mySum());
	}

	@Test
	public void testMyIterator() {
		assertEquals(asList(0,2,4,6,8,10,12,14,16,18), bs.myIterator());
	}

	@Test
	public void testMyFibonacci() {
		//assertEquals(asList(), bs.myOf());
	}

	@Test
	public void testMyFibonacci2() {
		//assertEquals(asList(), bs.myOf());
	}

}
