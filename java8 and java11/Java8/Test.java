package Java8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws IOException{
		
		  // Parses the date
        LocalDate dt = LocalDate.now();
        System.out.println(dt);
  
        // Function call
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        System.out.println(formatter.format(dt));
		
		

		// Java 10 or Higher
		// If we want to create Immutable List , Set , Map then we can use copyOf()		       		
		//List.copyOf(null);
		
		//Java 9  Immutable List
		List.of("Ankit","Pathak");
		
		
		Path paths = Paths.get("./text1.txt");
		String fileContent = Files.readString(paths);
		System.out.println(fileContent);
		
		fileContent += "Chor";
		
	    Files.writeString(paths, fileContent);

	    
	    //Java 11 Features
	    
	    //only Java code to compile and run
	    
	    //String method
        System.out.println(" ".isBlank()); //true
        
        String s = "Anupam";
        System.out.println(s.isBlank()); //false
	
        //String strip() method to trim
        
        String str = " JD "; 
        System.out.print("Start");
        System.out.print(str.strip());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(str.stripLeading());
        System.out.println("End");
        
        System.out.print("Start");
        System.out.print(str.stripTrailing());
        System.out.println("End");
        
        //Repeat method        
        String strr = "=".repeat(2);
        System.out.println(strr); //prints ==
        
        
        List<Integer> nums = Arrays.asList(2,3,4,1,2);
        int i = nums.stream().collect(Collectors.summingInt(Integer::intValue));
        int j = nums.parallelStream().reduce(0, Integer::sum);
        int k = nums.stream().reduce(0, Integer::sum);
        System.out.println(i+"  "+j+"   "+k);
        
	}
}
