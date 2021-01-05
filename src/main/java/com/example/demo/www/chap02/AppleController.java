package com.example.demo.www.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import static java.util.Comparator.comparing;

import static com.example.demo.cmm.util.Util.*;

import lombok.Data;

@Data class Apple{
	private int weight; private Color color;
	public Apple(int weight,Color color){
		this.weight=weight;this.color=color;
	}
}
enum Color{RED,GREEN}
//@FunctionalInterface interface Predicate<T>{public boolean test(T t);}

class AppleWeightPredicate implements Predicate<Apple>{

	@Override
	public boolean test(Apple apple) {
	  return apple.getWeight() > 150;
	}

}

class AppleColorPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
      return apple.getColor() == Color.GREEN;
    }

}

class AppleRedAndHeavyPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
      return apple.getColor() == Color.RED && apple.getWeight() > 150;
    }

}
  
class AppleFilter{
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
	    List<Apple> result = new ArrayList<>();
	    for (Apple apple : inventory) {
	      if (apple.getColor() == Color.GREEN) {
	        result.add(apple);
	      }
	    }
	    return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
	    List<Apple> result = new ArrayList<>();
	    for (Apple apple : inventory) {
	      if (apple.getColor() == color) {
	        result.add(apple);
	      }
	    }
	    return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
	    List<Apple> result = new ArrayList<>();
	    for (Apple apple : inventory) {
	      if (apple.getWeight() > weight) {
	        result.add(apple);
	      }
	    }
	    return result;
	}

	public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
	    List<Apple> result = new ArrayList<>();
	    for (Apple apple : inventory) {
	      if (p.test(apple)) {
	        result.add(apple);
	      }
	    }
	    return result;
	}
}
@FunctionalInterface interface FilterApples{public List<Apple> apply(List<Apple> ls,Predicate<Apple> pre);}

class AppleService {
	List<Apple> filterApples(List<Apple> ls, Predicate<Apple> p){
		List<Apple> r = new ArrayList<>();
		for(Apple a: ls) {
			if(p.test(a)) {
				r.add(a);
			}
		}
		return r;
	}
	 public List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
		    List<Apple> result = new ArrayList<>();
		    for (Apple apple : inventory) {
		      if (apple.getColor() == color) {
		        result.add(apple);
		      }
		    }
		    return result;
		  }

	 public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
	    List<Apple> result = new ArrayList<>();
	    for (Apple apple : inventory) {
	      if (apple.getWeight() > weight) {
	        result.add(apple);
	      }
	    }
	    return result;
	 }
	boolean isHeavyApple(Apple a) {return a.getWeight()>150;}
	boolean isGreenApple(Apple a) {return Color.GREEN.equals(a.getColor());}
}
public class AppleController{
	public static void main(String... args) {
		AppleService as = new AppleService();
		List<Apple> ls = Arrays.asList(new Apple(80, Color.GREEN),new Apple(155, Color.GREEN),new Apple(120, Color.RED));
		print("녹색사과");
		for(Apple a:as.filterApples(ls, as::isGreenApple)) print(a.toString());
		print("빨간사과 필터링 결과 ... 단, 색깔은 외부주입");
		for(Apple a : as.filterApplesByColor(ls, Color.RED)) print(a.toString());
		print("150그램이상 사과 필터링 결과");
		for(Apple a : as.filterApples(ls, as::isHeavyApple)) print(a.toString());
		print("120그램이상 사과 필터링 결과 ... 단, 무게는 외부주입");
		for(Apple a : as.filterApplesByWeight(ls, 120)) print(a.toString());
		
		print(">>> 정렬 >>>");
		// 익명함수
		Comparator<Apple> c = new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return Integer.valueOf(o1.getWeight()).compareTo(Integer.valueOf(o2.getWeight()));
			}
		};
		// 람다
		// 오름차순 정렬
		ls.sort((Apple o1, Apple o2) 
				-> integer(string(o1.getWeight()))
						.compareTo(integer(string(o2.getWeight()))));
		// 위 코드를 더 간략화 시킴. 단 import static java.util.Comparator.comparing; 주의 !!
		// Comparator<Apple> app = Comparator.comparing((Apple a)-> a.getWeight());
		ls.sort(comparing(Apple::getWeight));
		for(Apple a : ls) print(a.toString());	
		// 내림차순 정렬
		ls.sort((Apple o1, Apple o2) 
				-> integer(string(o1.getWeight()))
						.compareTo(integer(string(o2.getWeight()))));
		// 위 코드를 더 간략화 시킴. 단 import static java.util.Comparator.comparing; 주의 !!
		ls.sort(comparing(Apple::getWeight).reversed());
		for(Apple a : ls) print(a.toString());	
		// 내림차순 정렬. 같은 무게 객체 존재
		ls.sort(comparing(Apple::getWeight)
				.reversed()
				.thenComparing(Apple::getColor));
		for(Apple a : ls) print(a.toString());	
		
	}
}
