package JavaPractice;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {
	public static void main(String[] args) {
		
	
	int a[] = {1,2,3,1,4};
	Set<Integer> dup = new HashSet<Integer>();
	Set<Integer> nonDup = new HashSet<Integer>();
	
	for(int n:a)
	{
		if(!nonDup.add(n))
		{
			dup.add(n);
		}
	}
	System.out.println(dup);
	System.out.println(nonDup);

}
}