package com.type.rtti;

/**
 * 获得Class对象的方法
 * 1.Class.forName(fullName)
 * 2.object.getClass()
 * 3.clz.Clazz
 * @author Admin
 *
 */
public class ToyTest {

	static void printInfo(Class cc) {
		System.out.println("Class name:" + cc.getName() + 
				" is interface?[" + cc.isInterface() + "]");
		System.out.println("Class Simple name:" + cc.getSimpleName());
		System.out.println("Class Canonical name:" + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("com.type.rtti.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("cant find fancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class clz : c.getInterfaces()) {
			printInfo(clz);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printInfo(obj.getClass());
	}
	
}

interface HasBatteries {}
interface Wateproof {}
interface Shoots {}

class Toy{
	static{
		System.out.println("Loading Toy");
	}
	public Toy() {}
	public Toy(int i) {}
}

class FancyToy extends Toy 
	implements HasBatteries, Wateproof, Shoots{

	static{
		System.out.println("Loading FancyToy");
	}
	
	public FancyToy() {
		super(1);
	}
}
