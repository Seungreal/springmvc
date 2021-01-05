package com.example.demo.www.chap05;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.Test;

import com.example.demo.zzz.chap04.Dish;

public class MappingServiceTest {
	MappingService ms = new MappingService();
	@Test
	public void dishNamesTest() {
		assertEquals(asList("pork","beef","chicken","french fries","rice","season fruit","pizza","prawns","salmon")
				,ms.dishNames());
	}
	@Test
	public void wordLengthsTest() {
		assertEquals(asList(5,5),ms.wordLengths());
	}
	@Test
	public void myFlatMapTest() {
		assertEquals(asList("H","e","l","o","W","r","d"),ms.myFlatMap());
	}
	@Test
	public void pairsTest() {
		assertEquals(asList(new int[] {1,8},new int[] {2,7},new int[] {3,6},new int[] {4,8},new int[] {5,7}),ms.pairs());
	}
}

