package FunctionalProgramming;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaInternals {
	
	public static void main(String[] args) {
		// Using Java internals
		IntStream.of(34,52,12,9,22,17,0,1,2,-2,-4,-1).filter(e -> e%2==0).forEach(e -> System.out.println(e));
		// Using custom code
		IntStream.of(34,52,12,9,22,17,0,1,2,-2,-4,-1).filter(new EvenPredicate()).forEach(new EvenConsumer());
		// Using map
		System.out.println();
		IntStream.of(34,52,12,9,22,17,0,1,2,-2,-4,-1).map(e -> e*e).forEach(new EvenConsumer());
		// Using custom implementation of map
		IntStream.of(34,52,12,9,22,17,0,1,2,-2,-4,-1).map(new SquareMapper()).forEach(new EvenConsumer());
		
		// Function - takes input and returns an output of same type after doing something to the input
		// Predicate - takes input and returns true or false after doing something
		// Consumer - takes input and does something without returning anything
	}
	
	static class SquareMapper implements IntUnaryOperator {

		@Override
		public int applyAsInt(int operand) {
			return operand*operand;
		}
		
	}
	
	static class EvenPredicate implements IntPredicate {

		@Override
		public boolean test(int value) {
			// TODO Auto-generated method stub
			return value %2 == 0;
		}
		
	}
	
	static class EvenConsumer implements IntConsumer {

		@Override
		public void accept(int value) {
			System.out.println(value);
		}
		
	}
	
}
