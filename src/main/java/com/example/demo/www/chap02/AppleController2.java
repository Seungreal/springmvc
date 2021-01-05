package com.example.demo.www.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

import static com.example.demo.cmm.util.Util.*;

import lombok.Data;


public class AppleController2{
	public static void main(String... args) {
		List<Apple> ls = Arrays.asList(
				new Apple(80, Color.GREEN),
				new Apple(155, Color.GREEN),
				new Apple(120, Color.RED),
				new Apple(90, Color.RED),
				new Apple(110, Color.GREEN));
		List<String> ls2 = Arrays.asList(
				"a","b","c","d","e");
		
		ls.stream()
			.map(Apple::toString)
			.limit(3)
			.forEach(System.out::println);
	}
}
