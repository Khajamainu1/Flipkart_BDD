package JavaPractice;

import java.util.function.Predicate;

public class Lamda {
	
	public static void main(String[] args) {
		
		Predicate<Integer> p = i->(i>10);
		System.out.println(p.test(20));
	}

}
