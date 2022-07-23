package Java8;

import java.util.Arrays;
import java.util.List;

public class LamdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> l = Arrays.asList("Ankit","Aman","Sonu","Monu");
		
		//match string with exactly "on" string. // OUTPUT:- 0
		long count1 = l.stream().filter(e-> e.matches("on")).count();
		System.out.println(count1);
		
		//match string contains "on" anywhere in the string // OUTPUT:- 2
		long count2 = l.stream().filter(e-> e.matches(".*(on).*")).count();
		System.out.println(count2);
		
		
		
		
	}

}
