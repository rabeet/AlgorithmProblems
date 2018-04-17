package FunctionalProgramming;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StoringAndReturningFunctions {
	
	public static void main(String[] args) {
		
		testingMethodStoringAndReturning();
	}

	private static void testingMethodStoringAndReturning() {
		Comparator<? super Integer> comparator = (n1,n2) -> Integer.compare(n1, n2);
		Comparator<? super Integer> comparatorMethod = returningMethod();
		Predicate<? super Integer> even = n -> n%2==0;
		Predicate<? super Integer> odd = n -> n%2==1;
		int x = Stream.of(1,2,3,4).filter(even).max(comparator).orElse(0);
		System.out.println(x);
		x = Stream.of(1,2,3,4).filter(odd).max(comparator).orElse(0);
		System.out.println(x);
		
		BinaryOperator<Integer> accumulator = (n1,n2) -> n1+n2;
		x = Stream.of(1,2,3,4).reduce(0, accumulator);
		System.out.println(x);
	}

	private static Comparator<? super Integer> returningMethod() {
		return (n1,n2) -> Integer.compare(n1, n2);
	}
	
}
