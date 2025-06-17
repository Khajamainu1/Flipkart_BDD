package JavaPractice;

public class Count_SpecChar_Lett_Dig {

	public static void main(String[] args) {
		 
		String input = "Abc@123#XyZ";
		char[] ch = input.toCharArray();
		int letters=0, specChar =0, digits =0;
		
		for(Character c : ch)
		{
			if(Character.isLetter(c)) letters++;
			else if (Character.isDigit(c)) digits++;
			else specChar++;
		}
		
		System.out.println("Letters :" +letters);
		System.out.println("Digits :" +digits);
		System.out.println("specChar :" +specChar);
		
	}
}
