package plag_project;

import java.io.*;
import java.util.*;

public class Openfiles {
	ArrayList<HashMap<String, Integer> > freq=new  ArrayList<HashMap<String, Integer>>();
	ArrayList<String> arraylist2=new  ArrayList<>();
	static File[] listOfFiles;
			
	public Openfiles() {
		
		Scanner take= new Scanner(System.in);
		String path= take.nextLine();
		
		File folder = new File(path);
		listOfFiles = folder.listFiles(new FilenameFilter() { @Override public boolean accept(File dir, String name) { return name.endsWith(".txt"); } });
		
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
