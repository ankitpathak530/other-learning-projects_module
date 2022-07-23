package Java8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Java8.model.Hobbies;
import Java8.model.Person;

/*
Sequence of Data elements is called stream
Can be performed either sequentially or Parallel
Do not support indexed access
Lazy access supported
Stream is basically designed for LAMDA
  Stream API does not change the original data
*/ 

public class StreamMain1 {

	
	private static List<Hobbies> hobbies = List.of(new Hobbies("Play"),new Hobbies("Read"));
	
	//Mutable list
	private static List<Person> personsOriginal = Arrays.asList(
			new Person("Ankit",175,25.4,hobbies),
			new Person("Santosh",170,26.6,hobbies),
			new Person("Aman",170,22.1,hobbies));
	
	
	private static Person person;
	
	
	
	public static void main(String... args)
	{	
		String[] names = {"Ankit",null,"Santosh",null,"Shyam","Pulu","Golu"};
		
		
		List<Integer> orgnl = Arrays.asList(1,2,0,44,2,45,55);
		List<String> nameList = Arrays.asList(names);
		
		System.out.println("Original Integer Values:");
		orgnl.forEach( e -> System.out.print(e + " "));
		
		System.out.println("\n\nOriginal NameList Strings:");
		nameList.forEach( e -> System.out.print(e + " "));
		
		
		
		
		
		//Saving even no. to List
		orgnl.stream().filter(e -> e%2 == 0 ).collect(Collectors.toList());
	    
		
		System.out.println("\n\nEven no. just after filtering");
		orgnl.stream().filter( e -> e%2==0 ).forEach( e -> System.out.print(e + " "));
		


		System.out.println("\n\nfiltering nameList according to length less than 8 and greater that 6");
		nameList.stream().filter( e -> e != null && e.length() >6 && e.length() <8).forEach( e -> System.out.print( e +" "));
		System.out.println();
		
		
		System.out.println("\n All Not null strings:");
		nameList.stream().filter( e -> e != null).forEach( e -> {
			System.out.print( e +" ");
		});
		
		
		System.out.println("\n\nAdding 20 to original list with each element:");
		orgnl.stream().map(i->i+20).collect(Collectors.toList()).forEach( e -> System.out.print( e +" "));
		
		
		
	    System.out.println("\n\nPrinting ames based on natural sorting order:-");
		nameList.stream().filter(e->e!=null).sorted((e1,e2) -> e1.compareTo(e2)).forEach(e->System.out.print(e+" "));
		

		
	    System.out.println("\n\nPrinting ames based on custom sorting order. Just add \"-\" symbol :-");
		nameList.stream().filter(e->e!=null).sorted((e1,e2) -> -e1.compareTo(e2)).forEach(e->System.out.print(e+" "));		

	

		  Map<String, List<Hobbies>> nameHobbiesPerson = personsOriginal
				                                                     .stream()
				                                                     .collect(Collectors.toMap(Person :: getName, Person :: getHobbies));
		  nameHobbiesPerson.forEach((e1,e2) -> System.out.println("Name: "+e1 + "Hobbies:"+e2));
		  

		  System.out.println("\n");
		  List<String> collect = personsOriginal
		                 .stream()
		                 .map(Person :: getHobbies) // Stream List<String>
		                 .flatMap(List :: stream)
		                 .distinct()
		                 .map(e -> e.getHobbiesName()).collect(Collectors.toList());
		  

		                
		
		 Stream<String> stream = collect.stream();
		 stream.forEach(System.out::print); // Once we use stream we can't use it again in program
		 //stream.forEach(System.out::print); // this line will get IllegalStateException because we have already operated this stream
		 
		 String string = collect.stream().collect(Collectors.joining(","));
		 System.out.println("\n"+string);
		 
		 
			
		 // peak can be used to see the data before or after mapping or flattering
		 System.out.println("\n\nPeak use in stream api\n");
		personsOriginal.stream()
		                .peek(e -> System.out.println("\n"+e))
		                .map(Person :: getHobbies)
		                .peek(e -> System.out.println(e))          
		                .flatMap(List :: stream)  
		                .map(e -> e.getHobbiesName())
		                .distinct()
		                .collect(Collectors.toList()).forEach(e -> System.out.println(e));
		 
		                
		 
		System.out.println("\nSorting person by name Ascending");
		personsOriginal.stream()
		                .map(Person :: getName)   
		                .sorted(Comparator.comparing(String :: toString))
		                .forEach(e->System.out.print(e + " "));
		
		System.out.println("\n\nSorting person by name Decending");
		personsOriginal.stream()
		                .map(Person :: getName)   
		                .sorted(Comparator.comparing(String :: toString).reversed())
		                .forEach(e->System.out.print(e + " "));
		
    	              
		System.out.println("\n\nSorting by name , age and hobbies using `thenComparing` ");
		personsOriginal.stream()
		                .sorted(Comparator.comparing(Person :: getName)
		                		         .thenComparing(Person :: getAge)
		                		         .thenComparing(e -> e.getHobbies().size()))
		                .forEach(e->System.out.print(e + " "));
		  
        
        System.out.println("\n\n Return least age Person");
		Optional<Person> p2 = personsOriginal.stream()
		               .collect(Collectors.minBy(Comparator.comparing(Person :: getAge)));
		p2.ifPresent(System.out::println);
		
		
        
        System.out.println("\n\n Return max age Person");
		Optional<Person> p3 = personsOriginal.stream()
		               .collect(Collectors.maxBy(Comparator.comparing(Person :: getAge)));
		p3.ifPresent(System.out::println);
		
		
		
		
        
        System.out.println("\n\n Return least height Persons ");
		Optional<Person> p4 = personsOriginal.stream()
		               .collect(Collectors.minBy(Comparator.comparing(Person :: getHeight)));
		if(p4.isPresent()) person = p4.get();
		
		personsOriginal.stream() 
		               .filter(p -> p.getHeight() == person.getHeight())
		               .collect(Collectors.toList())
		               .forEach(e -> System.out.println(e +" "));
		
		
		
		
		
		
	}
}
