package com.example.demo.www.chap05;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.example.demo.zzz.chap04.Dish;

public class MappingService {
	public static final List<Dish> menu = Arrays.asList(
		      new Dish("pork", false, 800, Dish.Type.MEAT),
		      new Dish("beef", false, 700, Dish.Type.MEAT),
		      new Dish("chicken", false, 400, Dish.Type.MEAT),
		      new Dish("french fries", true, 530, Dish.Type.OTHER),
		      new Dish("rice", true, 350, Dish.Type.OTHER),
		      new Dish("season fruit", true, 120, Dish.Type.OTHER),
		      new Dish("pizza", true, 550, Dish.Type.OTHER),
		      new Dish("prawns", false, 400, Dish.Type.FISH),
		      new Dish("salmon", false, 450, Dish.Type.FISH)
	);
	public List<String> dishNames(){
		return menu.stream()
				.map(Dish::getName)
				.collect(toList());
	}
	public List<Integer> wordLengths(){
		return Arrays.asList("Hello", "World")
				.stream()
		        .map(String::length)
		        .collect(toList());
	}
	public List<String> myFlatMap(){
		return Arrays.asList("Hello", "World")
				.stream()
		        .flatMap((String line) -> Arrays.stream(line.split("")))
		        .distinct()
		        .collect(toList());
	}
	public List<int[]> pairs(){
		return Arrays.asList(1,2,3,4,5)
				.stream()
		        .flatMap((Integer i) -> Arrays.asList(6,7,8).stream()
			            .map((Integer j) -> new int[]{i, j})
			    )
			    .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
			    .collect(toList());
	}
}
