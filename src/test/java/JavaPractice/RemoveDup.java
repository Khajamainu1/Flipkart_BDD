package JavaPractice;

import java.util.HashSet;
import java.util.Set;

public class RemoveDup {

	public static void main(String[] args) {
		
		String input = "Programming";
		char[] chars = input.toCharArray();
		
		Set<Character> dup = new HashSet<Character>();
		Set<Character> nonDup = new HashSet<Character>();
		
		for(Character c : chars)
		{
		if(!nonDup.add(c))
		{
			dup.add(c);
		}}
		
		System.out.println("Duplicate :" + dup);
		System.out.println("NonDuplicate :" + nonDup);
	}
}

