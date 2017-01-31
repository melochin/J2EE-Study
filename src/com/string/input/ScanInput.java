package com.string.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class ScanInput {
	public static void main(String[] args) throws IOException {
		SimpleRead r = new SimpleRead();
		r.read();
		
		BetterRead br = new BetterRead();
		br.read();
	}
}

class SimpleRead{
	
	public static BufferedReader input = new BufferedReader(
			new StringReader("Sir Robin of Camelot\n22 1.61803"));
	
	public void read() throws IOException{
		System.out.println("What is your name?");
		//input 含有2行数据，这里只读取了一行，即第一行
		String name = input.readLine();
		System.out.println(name);
		
		System.out.println("How old are u? What is ur favorite double?");
		System.out.println("(input:<age> <double>)");
		//读取了第二行
		String numbers = input.readLine();
		System.out.println(numbers);
		
		String[] numArray = numbers.split(" ");
		int age = Integer.parseInt(numArray[0]);
		double favorite = Double.parseDouble(numArray[1]);
		
		System.out.format("Hi %s.\n", name);
		System.out.format("In 5 years you will be  %d.\n", age + 5);
		System.out.format("My favorite double is %.2f.\n", favorite / 2);
	}
	
}

class BetterRead{
	
	public void read(){
		Scanner stdin = new Scanner(SimpleRead.input);
		String name = stdin.nextLine();
		int age = stdin.nextInt();
		double favorite = stdin.nextDouble();
		System.out.format("name is %s, age is %d, favorite double is %f", name, age, favorite);
	}
}
