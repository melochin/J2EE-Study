package com.type.rtti;

public class SweetShop {
	
	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();	//执行static 部分的代码
		new Candy();	//不执行static 部分的代码
		
		try {
			//Class.forName 会加载class文件，执行static部分代码
			//因为会返回class对象
			Class.forName("com.type.rtti.Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("Cant find Gum");
		}
		new Gum();
		new Cookie();
		
	}
	
}

class Candy {
	/*
	 *	static 包含的代码块，只能在第一次加载Candy.class时候才会执行
	 *	加载完毕之后class就放在内存中
	 *	之后创建Candy对象，全部从内存中读取class 
	 */
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}
