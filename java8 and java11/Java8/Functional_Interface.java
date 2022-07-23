package Java8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
//Function  apply()
//Predicate  test()
//Supplier   get()
public class Functional_Interface {

	public static void main(String[] args) {
		
		//Predicate<Integer> predicate  =  i -> i%2 == 0;  //Go for Wrapper
		IntPredicate predicate = i -> i%2 == 0;             //IntPredicate
                                                          //DoublePredicate
		                                                  //LongPredicate
		System.out.println(predicate.test(10));   //Predicate always return true or false
	
	
	   //Supplier
		//It does not take argument or input. Just supply my required object like OTP.
		Supplier<String> s = ()->{
			String otp = "";
			for(int i=1; i<=6; i++)
				otp += (int)(Math.random()*10);
		   return otp;
	     };
	     //Call s.get() It will generate random OTP
	    System.out.println(s.get());
	    System.out.println(s.get());
	    
	    
	    
	    //Function 1st Argument input , 2nd Argument return type
	    Function<String,Integer> function = str -> str.length();
        BiFunction<String, String, Integer> bifn = (s1,s2) -> s1.length() + s2.length(); 	    
        
        
	    
	    System.out.println(function.apply("ankit"));
	    System.out.println(bifn.apply("Ankit Kumar", "Pathak"));
	}

}
