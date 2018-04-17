package FunctionalProgramming;

import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateOperations {

	public static void main(String[] args) {
		IntStream.range(1, 10).map(e -> e*e).forEach(e -> System.out.println(e));
		
		Arrays.asList(new String[] {"A","B","C"}).stream().map(m -> m.toLowerCase()).forEach(e -> System.out.println(e));
		
		Arrays.asList(new String[] {"A","B","C"}).stream().map(m -> m.length()).forEach(e -> System.out.println(e));
		
		
		
	}
	
}
