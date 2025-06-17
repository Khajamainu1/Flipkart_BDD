package JavaPractice;

public class RevString {
	
	public static void main(String[] args) {
		
		String name = "Java Programming";
		String[] n = name.split(" ");
//		String[] output = [];
		
		String rev = n[0];
		String actual = "";
		for(int i=rev.length()-1; i>=0; i--)
		{
			actual+=rev.charAt(i);
		}
		System.out.println(actual +" "+n[1]);
		
		
	}

}
