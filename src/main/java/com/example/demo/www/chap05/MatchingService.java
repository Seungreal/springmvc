package com.example.demo.www.chap05;

import lombok.Data;

public class MatchingService {

}
@Data
class Trader {
	  private String name,city;
}
@Data
class Transaction {
	  private Trader trader;
	  private int year,value;
}