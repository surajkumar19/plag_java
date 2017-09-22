package plag_project;

import java.util.HashMap;
import java.util.Set;

/*this class takes two hashmaps of corresponding files as input and calucalates plagiarism 
 * between these two files*/

public class Bagofwords {
	static float plag;
	public static float plagiarism(HashMap<String, Integer> s1,HashMap<String, Integer> s2)
	{
		Set<String> z=s1.keySet();
		int sum=0;
		/*this loop finds cross product between two files*/
		for(String s:z)
		{
			if(s2.containsKey(s))
			{
				sum+=s1.get(s)*s2.get(s);
			
			}
		}
		
		double e1=euclid_value(s1);
		double e2=euclid_value(s2);
		plag=(float) (sum/(e1*e2));
		return plag*100;   //returns plagiarism percentage .
	}
	
	/*This method calculates the euclid value of a file*/
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
