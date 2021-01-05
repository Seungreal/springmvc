package com.example.demo.www.chap02;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AnonymTest {
	public static void main(String... args) {
		//classic
		Person p = new Person();
		System.out.println(p.returnName("길동"));

		//modern(anonymous)
		System.out.println(new IPerson() {
			
			@Override
			public String returnName(String name) {
				return name;
			}
		}.returnName("순신"));
		
		
		
		//(method reference)
		new Log() {
			
			@Override
			public void print(String msg) {
				Consumer<String> c = System.out::println; 
				c.accept(msg);
			}
		}.print("순신");
		
		IPerson ip = (String name)->{return name;};
		
		Consumer<String> c = System.out::println;
		c.accept("순신");
		BiFunction<Integer, Integer, Integer> f = (Integer a,Integer b)->{return a+b;};
		c.accept(f.apply(10, 4).toString());
	}
}
class Person{
	String name;
	String returnName(String name){return name;}
}
interface IPerson{public String returnName(String name);}
interface Log{void print(String msg);}