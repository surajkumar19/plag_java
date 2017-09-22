package plag_project;

import java.util.HashMap;
import java.util.Set;

public class Bagofwords {
	static float plag;
	public static float plagiarism(HashMap<String, Integer> s1,HashMap<String, Integer> s2)
	{
		Set<String> z=s1.keySet();
		int sum=0;
		for(String s:z)
		{
			if(s2.containsKey(s))
			{
				sum+=s1.get(s)*s2.get(s);
				//System.out.println(s);
			}
		}
		
		double e1=euclid_value(s1);
		double e2=euclid_value(s2);
		//System.out.println(e1*2+"  "+sum);
		plag=(float) (sum/(e1*e2));
		return plag*100;
	}
	public static double euclid_value(HashMap<String, Integer> k) {
		double a;
		int sum=0;
		Set<String> z=k.keySet();
		for(String s:z)
		{
			sum+=k.get(s)*k.get(s);
		}
		a=Math.sqrt(sum);
		return a;
	}
}
