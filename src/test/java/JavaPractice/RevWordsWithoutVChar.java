package JavaPractice;

public class RevWordsWithoutVChar {
	
	public static void main(String[] args) {
		
		String in = "the sky is blue";
		String[] words = in.split(" ");
		
		for(int i=words.length-1; i>=0; i--)
		{
			System.out.print(words[i]);
			System.out.print(" ");
		}
	}

}
