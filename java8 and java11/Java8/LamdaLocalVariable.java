package Java8;

import java.util.function.Consumer;

public class LamdaLocalVariable {
	
	private static int sum = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i = 10;
		

        Consumer<Integer> c1 = (j) -> {
		   //	i += 10;
            System.out.println("\n---- We can not modify local variable inside lamda ----");
			System.out.println(i);
		};
        

        Consumer<Integer> c2 = (j) -> {
			sum += 10;
	        System.out.println("\n---- We can modify static or instance variable inside lamda ----");
			System.out.println(sum);
		};
		
		c1.accept(20);
		c2.accept(1);
		
//		System.out.println(sum);
		
	}

}
