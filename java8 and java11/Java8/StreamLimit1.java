package Java8;

import java.util.Arrays;


import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class StreamLimit1 {

	
	
	public static void main(String[] args) {
	
		List<String> fruits = Arrays.asList("Apple","Bananna","Grapes","Mango");
		List<Integer> numbers = Arrays.asList(1,2,5,44,2,45,55);
		
		
		System.out.println("Prints two data from list:");
		fruits.stream()
		      .limit(2)
		      .forEach(System.out::println);
		
		
		
		System.out.println("\n\nSum first two data");
		Integer sum = numbers.stream()
		      .limit(2)
		      .reduce(0,(a,b) -> (a+b));
	
	    System.out.println("Sum = "+sum);
		
	    
	    
	    
	    
	    System.out.println("\n\nSum all data skip first two data");
		Integer sum2 = numbers.stream()
		      .skip(2)
		      .reduce(0,(a,b) -> (a+b));
	
	    System.out.println("Sum = "+sum2);
	    
	    
	    
	    
	    
	    System.out.println("\n\nSum all data in given range. It is more faster because It meant for primitive type");
	    IntStream range = IntStream.rangeClosed(1, 8);
	    int sum3 = range.sum();
	    System.out.println("Sum = "+sum3);
		
	    
	    System.out.println("\n\nMean of all data in given range");
	     OptionalInt min = IntStream.rangeClosed(1, 8).min();
	    System.out.println("Min = "+min);
	    

	    System.out.println("\n\nMax of all data in given range");
	     OptionalInt max = IntStream.rangeClosed(1, 8).max();
	    System.out.println("Max = "+max);
	    

	    System.out.println("\n\nAverage of all data in given range");
	    OptionalDouble average = IntStream.rangeClosed(1, 8).average();
	    System.out.println("Average = "+average);
		
	    
	    System.out.println("\n\nprimitive to wrapper object boxing");
	    List<Integer> collect = IntStream
	    		             .rangeClosed(1, 8) //primitive
	    		             .boxed() //converting to wrapper
	    		             .collect(Collectors.toList()); //collecting as list
	    		             
	    		        
		
	}
	
	

}
