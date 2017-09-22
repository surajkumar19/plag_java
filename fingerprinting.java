package plag_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class fingerprinting {
	
	
	public static float plagiarism(String  a,String  b)
	{
		//k-gram is 4
		ArrayList<Integer> hash1=new ArrayList<>();
		ArrayList<Integer> hash2=new ArrayList<>();
		hash1=hashvalues(a);
		hash2=hashvalues(b);
//		System.out.println(hash1);
//		System.out.println(hash2);
		int count=0;
		
		HashMap<Integer, Integer> hashtable1=new HashMap<>();
		HashMap<Integer, Integer> hashtable2=new HashMap<>();
		for(Integer s:hash1)
		{
			hashtable1.computeIfPresent(s,(k,v)->v+1);
			hashtable1.computeIfAbsent(s, k->1);
		}
		for(Integer s:hash2)
		{
			hashtable2.computeIfPresent(s,(k,v)->v+1);
			hashtable2.computeIfAbsent(s, k->1);
		}
		Set<Integer> z=hashtable1.keySet();
		for(int i:z)
		{
			if(hashtable2.containsKey(i))
			{
				count+=Math.min(hashtable2.get(i),hashtable1.get(i));
			}
		}
		
		
		
		float plag=(float)(count*2)/(hash1.size()+hash2.size());
		
		return plag*100;
	}
	public static ArrayList<Integer> hashvalues(String s)
	{
		ArrayList<Integer> hash=new ArrayList<>();
		int i;
		for(i=0;i<s.length()-3;i++)
		{
			int z=(int) (s.charAt(i)*Math.pow(10,3)+s.charAt(i+1)*Math.pow(10,2)+s.charAt(i+2)*Math.pow(10,1)+s.charAt(i+3)*Math.pow(10,0));
			z=z%10007;
			hash.add(z);
		}
		return hash;
	}

}
