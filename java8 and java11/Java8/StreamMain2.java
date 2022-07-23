package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import Java8.model.Hobbies;
import Java8.model.Person;

public class StreamMain2 {
	
	private static List<Hobbies> hobbies = List.of(new Hobbies("Play"),new Hobbies("Read"));
	
	//Mutable list
	private static List<Person> personsOriginal = Arrays.asList(
			new Person("Ankit",175,25.4,hobbies),
			new Person("Santosh",170,26.6,hobbies),
			new Person("Aman",175,22.1,hobbies));
	
	
	static Predicate<Person> p1 = StreamMain2 :: heightCheck;
	static BiPredicate<Integer,Double> p2 = StreamMain2 :: heightCheckWithAge;
	
	
	public static void main(String[] args) {

			
		    System.out.println("Filterring Person using Predicate 1st way ::-- Method Reference ---::");
            personsOriginal.stream().filter(StreamMain2 :: heightCheck).forEach(System.out::println);	
         
            System.out.println("\n\nFilterring Person using Predicate 2nd Way  ::-- Method Reference ---::");
            personsOriginal.stream().filter(p1).forEach(System.out::println);
           
            System.out.println("\n\nFilter Person using BiPredicate passing Name and Age");
	        personsOriginal.stream().filter( e1 -> p2.test(e1.getHeight(), e1.getAge())).forEach(System.out::println);;	
	    
	}
	
	static boolean heightCheck(Person person) {
		return person.getHeight() >= 175;
	}
	
	static boolean heightCheckWithAge(Integer height,Double age) {
		return height >= 175 && age >= 25;
	}
	
	
	
	
	
	
	
	
	
	
	
	static void immutableList() {	
				//-------------Create ImmutableList using of()--------------	
			   List<Person> persons_of = Arrays.asList(
						new Person("Ankit",175,25.4,hobbies),
						new Person("Santosh",170,26.6,hobbies),
						new Person("Aman",175,22.1,hobbies));
				
		        //Throw UnsupportedOperationException		
				persons_of.add(new Person("d",111,12.3,hobbies));
				

				
				
				 //-----------Create ImmutableList using copyOf()------------
		        List<Person> persons_copyOf = List.copyOf(personsOriginal);
		        
		        //Throw UnsupportedOperationException	
		        persons_copyOf.add(new Person("d",111,12.3,hobbies));
	}
	
}
