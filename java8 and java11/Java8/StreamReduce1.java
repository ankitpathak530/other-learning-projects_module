package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Java8.model.Employee;

public class StreamReduce1 {
	
	// creating a list of employee
	private static List<Employee> emps = List.of(
			new Employee("Ankit",2,"Aurangabad"),
			new Employee("Aman",4,"Ramgadh"),
			new Employee("Gautam",6,"Aurangabad"),
			new Employee("Raju",3,"Ramgadh"),
			new Employee("Sonu",2,"Aurangabad"),
			new Employee("Shalini",1,"Patna"),
			new Employee("Lav",1,"Aurangabad")
			);
	
	// creating a list of Strings
    private static List<String> words = Arrays.asList("Ankit", "Pathak", "Made",
                                       "For", "Everyone","and","for","EachOnes");

    
    
    
    
	public static void main(String[] args) {
		
  
        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        
        Optional<String> longestString = words.stream()
                                   					  .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
  
        // Displaying the longest String
        longestString.ifPresent(System.out::println);
		
        
        
        

        // Connecting strings with  "-"
        Optional<String> combinedString = words.stream()
                      .reduce((word1, word2) -> word1 +"-"+ word2);

        // Displaying the string connected with "-" string
        combinedString.ifPresent(System.out::println);
        
        
        
        
        
        
        
        // Connecting strings with  ","
        String joinedWords = words.stream()
				  .   collect(Collectors.joining(","));

        // Displaying the string connected with "," string
        System.out.println(joinedWords);

        
        
        
        
        
        
		List<Integer> listOfInteger = Arrays.asList(1,4,2,6,2,8);
		
		/*
		1-> 1  X  1 = 1
		2-> 1  X  4 = 4
		3-> 4  X  2 = 8
		4-> 8  X  6 = 48
		5-> 48 X  2 = 96
		6-> 96 X  8 = 768 */
		Integer multiply = listOfInteger.stream().reduce(1,(a,b) -> a*b);
		System.out.println(multiply);
		

		
		
		
		
		/*
		1-> 2   +  3 = 5
		2-> 5   +  4 = 9
		3-> 9   +  5 = 14
		4-> 14  +  6 = 20
		5-> 20  +  7 = 27       It includes starting range value but exclude last range value*/
		OptionalInt sumOfRange = IntStream.range(2, 8).reduce((a,b) -> a+b);
		sumOfRange.ifPresent(System.out::println);
		
		
		
		//Counting total number of kids of all employee
		Integer totalNoOfKids1 = emps.stream()
		    .map(Employee :: getNoOfKids)
		    .reduce(0,(a,b)-> a+b);
		
		System.out.println("Total Number of kids of all employee are:"+totalNoOfKids1);
		
		

		//Counting total number of kids of employee who comes from aurangabad city
		Integer totalNoOfKids2 = emps.stream()
			.filter(e -> e.getCity().equals("Aurangabad"))
		    .map(Employee :: getNoOfKids)
		    .reduce(0,(a,b)-> a+b);
		
		System.out.println("Total Number of kids of employee who comes from Aurangabad :"+totalNoOfKids2);
		
		
	}

}
