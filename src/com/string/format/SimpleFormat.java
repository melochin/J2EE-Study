package com.string.format;

import java.util.Formatter;

public class SimpleFormat {
	
	public static void sysoutFormat(){
		int x = 5;
		double y = 2.33333;
		
		System.out.println("Row 1: [" + x + "," + y + "]");
		System.out.printf("Row 1: [%d,%f]\n", x, y);
		System.out.format("Row 1: [%d,%f]\n", x, y);
	}
	
	public static void main(String[] args){
		sysoutFormat();
		
		Turtle t = new Turtle("A", new Formatter(System.out));
		t.move(1, 2);
		
		Receipt r = new Receipt();
		r.printList();
		
		try{
			throw new DatabaseException(3, 7, "Write failed");
		}catch (Exception e) {
			System.out.println(e);
		}
		
		Hex h = new Hex();
		System.out.println(h.format("AAAAA".getBytes()));
	}
}

/**
 * Turtle
 * @author Admin
 *
 */
class Turtle{
	private String name;
	private Formatter f;
	
	public Turtle(String name, Formatter f) {
		this.name = name;
		this.f = f;
	}
	
	public void move(int x, int y){
		f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
	}
}

//format general syntax
//%[argument_index$][flags][width][.precision]conversion
//argument_index%  参数所在的位置
//flag 	-左对齐
//width	占宽
//precision 精度
//conversion d f s int double string

class Receipt{
	private double total = 0;
	private Formatter f = new Formatter(System.out);
	private int width[] = {15, 5, 10};
	
	private void printTitle(){
		f.format("%-" + width[0] + "s %" + width[1] +"s "
				+ "%" + width[2] + "s\n", "Item", "Qty", "Price");
		f.format("%-" + width[0] + "s %" + width[1] +"s "
				+ "%" + width[2] + "s\n", "----", "----", "----");
	}
	
	private void print(String name, int qty, double price){
		f.format("%-" + width[0] + "s %" + width[1] +"d "
				+ "%" + width[2] + ".2f\n", name, qty, price);
		total += price;
	}
	
	private void printTotal(){
		f.format("%-" + width[0] + "s %" + width[1] +"s "
				+ "%" + width[2] + ".2f\n", "Tax", "", total * 0.06);
		f.format("%-" + width[0] + "s %" + width[1] +"s "
				+ "%" + width[2] + "s\n", "", "", "----");
		f.format("%-" + width[0] + "s %" + width[1] +"s "
				+ "%" + width[2] + ".2f\n", "Total", "", total * 1.06);
	}
	
	public void printList(){
		printTitle();
		print("A", 4, 4.25);
		print("B", 2, 1.256);
		print("C", 3, 2.1);
		printTotal();
	}
}

//useage of String.format
class DatabaseException extends Exception {
	public DatabaseException(int transactionID, int queryID, String message){
		super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
	}
}

class Hex{
	public String format(byte[] data){
		StringBuilder result = new StringBuilder();
		int n = 0;
		for(byte b : data){
			if(n % 16 == 0){
				result.append(String.format("%05X:", n));
			}
			result.append(String.format("%02X ", b));
			n++;
			if(n % 16 == 0) result.append("\n");
		}
		result.append("\n");
		return result.toString();
	}
}

