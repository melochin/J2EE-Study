package com.type.rtti;

public class SweetShop {
	
	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();	//ִ��static ���ֵĴ���
		new Candy();	//��ִ��static ���ֵĴ���
		
		try {
			//Class.forName �����class�ļ���ִ��static���ִ���
			//��Ϊ�᷵��class����
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
	 *	static �����Ĵ���飬ֻ���ڵ�һ�μ���Candy.classʱ��Ż�ִ��
	 *	�������֮��class�ͷ����ڴ���
	 *	֮�󴴽�Candy����ȫ�����ڴ��ж�ȡclass 
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
