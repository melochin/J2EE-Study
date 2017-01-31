package com.type.rtti;

import java.util.Arrays;
import java.util.List;

/**
 * Runtime type information
 * @author Admin
 *
 */
public abstract class Shape {
	void draw(){
		System.out.println(this + ".draw()");
	}
	
	abstract public String toString();
	
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(
				new Circle(), new Square(), new Triangle()
				);
		for(Shape shape : shapeList){
			shape.draw();
		}
	}
}

class Circle extends Shape {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
	
}

class Square extends Shape {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}

class Triangle extends Shape {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}

