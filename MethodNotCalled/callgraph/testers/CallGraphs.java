package testers;

public class CallGraphs
{
	public static void main(String[] args) {
		doStuff();
	}
	
	public static void doStuff() {
		bar();
	}

	public static void foo() {

	}
	
	public static void bar() {
	foo();
	}

	public static void A() {
//	foo();
bar();
	}

	


}
