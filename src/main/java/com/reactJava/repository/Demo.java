package com.reactJava.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {
		List<Integer > list = new ArrayList<>();
		list.add(14);
		list.add(25);
		
		List<Integer> collect = list.stream().map((e)->e+10).collect(Collectors.toList());
		System.out.println(collect);
	}

}
