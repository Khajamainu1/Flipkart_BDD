package JavaPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountOccurence {
	
	public static void main(String[] args) {
		
		String input = "mapping";
		char[] c = input.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(Character ch : c)
		{
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
			}
			else
				map.put(ch,1);
		}
		
		for(Entry<Character, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey() +":"+ entry.getValue());
		}
	}

}
