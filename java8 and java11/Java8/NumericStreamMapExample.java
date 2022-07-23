package Java8;

import java.util.stream.IntStream;

public class NumericStreamMapExample {

	static double map2Double() {
		return IntStream
				.rangeClosed(1, 10) // primitive int element
				.mapToDouble(x -> x) // converting the elements to double
				.sum(); 
	}

	public static void main(String[] args) {
		

		System.out.println("Map to Double :"+map2Double());  
		
	}
	
	
	

}
