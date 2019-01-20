package classpack;

import interfacepack.MyInterface;

public class MyClass {
	protected int x;
	private int y;
	public int z;
	protected class InnerMyClass implements MyInterface {
		public InnerMyClass(){} //without this trying to create an instance of innerclass inside
		//a child class in a different package will not work
		@Override
		public void doDomething() {
			System.out.println("I am here");
			
		}
	}
}
