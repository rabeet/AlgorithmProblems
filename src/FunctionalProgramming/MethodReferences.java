package FunctionalProgramming;

import java.util.stream.Stream;

public class MethodReferences {
	
	private static void print(int num) {
		System.out.println(num);
	}
	
	public static boolean isEven(int num) {
		return num%2==0;
	}
	
	public static int maxOfTwo(int num1, int num2) { // NOT NEEDED! can directly call Integer::compare
		return Integer.compare(num1, num2);
	}

	public static void main(String[] args) {
//		testMethodReferences1();
		testMethodReferences2();
	}

	private static void testMethodReferences2() {
		int x = Stream.of(23,45,67,34)
				.filter(n -> n%2==0)
				.max((n1,n2) -> Integer.compare(n1,n2))
				.orElse(0);
		System.out.println(x);
		
		x = Stream.of(23,45,67,34)
				.filter(MethodReferences::isEven)
				.max(Integer::compare)
				.orElse(0);
		System.out.println(x);
	}

	private static void testMethodReferences1() {
		// All do the same thing!
		Stream.of("Cat","Dog","Elephant")
		.map(e -> e.length())
		.forEach(e -> System.out.println(e));
		
		Stream.of("Cat","Dog","Elephant")
		.map(e -> e.length())
		.forEach(System.out::println);
		
		Stream.of("Cat","Dog","Elephant")
		.map(e -> e.length())
		.forEach(MethodReferences::print);
		
		Stream.of("Cat","Dog","Elephant")
		.map(String::length) // can even call instance methods
		.forEach(MethodReferences::print);
	}
	
	
}
