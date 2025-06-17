package JavaPractice;

import java.util.ArrayList;
import java.util.List;

public class RevKeepingSpecCharIndex {
	
	public static void main(String[] args) {
		String input = "Java@Pro1";
		char[] ch = input.toCharArray();
		int specIndex = input.indexOf("@");
		String rev = "";

		
		List<Character> list = new ArrayList<Character>();
		for(Character c : ch)
		if(Character.isLetterOrDigit(c))
		{
			rev += c;
		}
		
		System.out.println(rev);
		
		
		
		
		
		
		
		
		
	}

}