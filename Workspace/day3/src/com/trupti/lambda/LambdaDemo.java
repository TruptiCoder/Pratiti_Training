package com.trupti.lambda;

interface Calculate {
	void calc();
}

class AddCalculator implements Calculate {

	@Override
	public void calc() {
		System.out.println("Add calculator called");
	}
}
	
class SubCalculator implements Calculate {
		
	@Override
	public void calc() {
		System.out.println("Sub calculator called");
	}
}

public class LambdaDemo extends Object {
	
	class Divide implements Calculate {

		@Override
		public void calc() {
			System.out.println("Divide Called");
		}
		
	}
	
	public void call() {
//		SubCalculator s = new SubCalculator();
//		doCalc(s);
		
		class Multiply implements Calculate {

			@Override
		    public void calc() {
				System.out.println("Multiply Called");
		    }
			
		}
//		doCalc(new Multiply());
		
		Calculate modulus = new Calculate() {
			@Override
			public void calc() {
				System.out.println("Modulus: This is anonymous class");
			}
		};
//		doCalc(modulus);
		
		doCalc(new Calculate() {
			@Override
			public void calc() {
				System.out.println("WAHAHAHA");
			}
		});
		
//		doCalc(new Divide());
		
		
		// Lambda function
		Calculate c1 = () -> {
			System.out.println("Calculate: This is lambda function");
		};
		
		doCalc(c1);
	}
	
	public void doCalc(Calculate calculate) {
		calculate.calc();
	}
	
	public static void main(String[] args) {
		new LambdaDemo().call();
	}
}
