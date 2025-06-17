package JavaPractice;

public class RevAfterSpecialChar {

	public static void main(String[] args) {
		
		String input = "Java@Program";
		String[] words = input.split("@");
		
		String word1 = words[1];
		String revWord1 = "";
		for(int i=word1.length()-1; i>=0; i--)
		{
			revWord1 += word1.charAt(i);
		}
		
		System.out.println(words[0]+"@"+revWord1);
	}

}
