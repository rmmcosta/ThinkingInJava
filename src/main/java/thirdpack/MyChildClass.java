package thirdpack;

import classpack.MyClass;
import interfacepack.MyInterface;

public class MyChildClass extends MyClass{
	public MyInterface getInter() {
		MyChildClass obj = new MyChildClass();
		return obj.new InnerMyClass();
	}

	class MyChildInner extends InnerMyClass{
		public void xpto(){
			doDomething();
		}
	}

	public static void main(String[] args) {
		MyClass m = new MyClass();
		System.out.println(m.z);
		//MyInterface in = m.new InnerMyClass();
		MyChildClass c = new MyChildClass();
		//MyInterface in1 = c.new InnerMyClass();
		//c.InnerMyClass innerMyClass = new c.InnerMyClass();
		//c.getInter().doDomething();
		MyChildInner mci = c.new MyChildInner();
		mci.doDomething();
		c.getInter().doDomething();
	}
	
}
