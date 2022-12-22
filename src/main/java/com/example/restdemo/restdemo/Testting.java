package com.example.restdemo.restdemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Testting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,4,6,8,7,9,99,100};
		int s=Arrays.stream(a).boxed().sorted().skip(1).findFirst().get();
		System.out.print(s);
	}

}
