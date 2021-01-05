package com.example.demo.cmm.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component
public class Util {
    public static void print(String t){
        Consumer<String> c = System.out::println;
        c.accept(t);
    }
    public static Integer integer(String t){
        Function<String,Integer> f= Integer::valueOf;
        return f.apply(t);
    }
    public static String string(Object t){
        Function<Object,String> f = String::valueOf;
        return f.apply(t);
    }
    public static boolean equals(String t1,String t2){
        BiPredicate<String,String> f = String::equals;
        return f.test(t1,t2);
    }
    public static int random(int begin,int end){
        BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+1;
        return f.apply(begin, end);
        // Supplier<Double> f = Math::random;
        // return (int)(f.get()*(end-begin))+1;
    }
    public static int[] arr(int size){
        //int[] arr = new int[size];
        Function<Integer,int[]> f = int[]::new;
        return f.apply(size);
    }
    public static List<Object> arrayList(){
        Supplier<List<Object>> s = ArrayList::new;
        return s.get();
    }
    public static String time(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
    public static File mkdir(String t,String u){
        BiFunction<String,String,File> f = File::new;
        return f.apply(t, u);
    }
    public static File mkfile(File t,String u){
        BiFunction<File,String,File> f = File::new;
        return f.apply(t, u);
    }
}