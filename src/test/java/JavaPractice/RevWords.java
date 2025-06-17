package JavaPractice;

public class RevWords {

	
	public static void main(String[] args) {
		
		String input = "Java Programming Language";
		String[] words = input.split(" ");
		String output = "";
		for(String word : words)
		{
			
		for(int i=word.length()-1; i>=0; i--)
		{
			output += word.charAt(i);
		}
		}
		System.out.println(output);
	}
}
