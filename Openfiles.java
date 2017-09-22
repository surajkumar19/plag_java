package plag_project;

import java.io.*;
import java.util.*;

/*this class opens a file and reads it also stores the words in a hashmap and in a string of 
 * only alphabetical values*/


public class Openfiles {
	ArrayList<HashMap<String, Integer> > freq=new  ArrayList<HashMap<String, Integer>>();
	ArrayList<String> arraylist2=new  ArrayList<>();
	static File[] listOfFiles;
			
	public Openfiles() {
		
		Scanner take= new Scanner(System.in);
		String path= take.nextLine();
		
		File folder = new File(path);//storing the files from a folder from given path
		listOfFiles = folder.listFiles(new FilenameFilter() { @Override public boolean accept(File dir, String name) { return name.endsWith(".txt"); } });
		
		/*this loop takes a reads a file and stores only the alphabetical characters in two ways
		 * 1: creates a hashmap of words 
		 * 2: stores all alphabets without any sepecial chars and spaces */
		
		for(File f:listOfFiles)
		{
			try
			{
				
				HashMap<String, Integer> s=new HashMap<>();
				String s1="",s2="";
				FileReader file_reader=new FileReader(f);
				int i;
				while (( i=file_reader.read()) != -1)
				{
		            char z=(char) i;
		            if ((z>='a' && z<'z') || (z>='A' && z<'Z')|| z==' ')
		            {
		            	s1+=z;
			            if(z!=' ')
			            {
			            	s2+=z;
			            }
			            else
			            {
			            	s1=s1.toLowerCase();
			            	s.computeIfPresent(s1,(k,v)->v+1);
			    			s.computeIfAbsent(s1, k->1);
			            	s1="";
			            }
		            }
		            
		            
		        
				}
				freq.add(s);
				arraylist2.add(s2.toLowerCase());
				file_reader.close();

			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		
	}
		//System.out.println(freq);
//		System.out.println(arraylist2);
	
	take.close();
	
	
}
}
