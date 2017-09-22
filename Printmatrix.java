package plag_project;

import java.io.File;
import java.util.ArrayList;

/*This class takes a array list as input and  prints out plagiarism between list of files  
 * in form of matrix*/

public class Printmatrix {
	
	public void print_matrix(ArrayList<Float> a)
	{
		System.out.printf("\t\t");
		int count=0,i,count2=0;
		for(File f:Openfiles.listOfFiles)
		{
			System.out.printf("%s \t",f.getName());
			count++;
		}
		System.out.println();
		for(i=0;i<count;i++)
		{
			System.out.printf("%s\t",Openfiles.listOfFiles[i].getName());
			for(int j=0;j<count;j++)
			{
				
				System.out.printf("%.2f\t\t",a.get(count2));
				count2++;
			}
			System.out.println();
		}
		
	}


	

}
