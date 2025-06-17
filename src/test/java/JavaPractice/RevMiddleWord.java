package JavaPractice;

public class RevMiddleWord {
	
	public static void main(String[] args) {
		
		String input = "Java Programming Language";
		String[] words = input.split(" ");
		
		for(String word : words)
		{
		
		}
		String word1 = words[1];
		String output1 = "";
		for(int i=word1.length()-1; i>=0; i--)
		{
			output1 += word1.charAt(i); 
		}
		
		System.out.println(words[0] + output1 +words[2]);
	}

}
