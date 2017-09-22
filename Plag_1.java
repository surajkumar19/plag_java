package plag_project;

import java.util.ArrayList;

public class Plag_1 {
	public static void main(String[] args) {
		
		Openfiles f=new Openfiles();
		ArrayList<Float> bag_plag=new ArrayList<>();
		ArrayList<Float> lcs_plag=new ArrayList<>();
		ArrayList<Float> fp_plag=new ArrayList<>();
		for (int i=0;i<f.freq.size();i++)
		{
			for(int j=0;j<f.freq.size();j++)
			{
				bag_plag.add(Bagofwords.plagiarism(f.freq.get(i),f.freq.get(j)));
				lcs_plag.add(Lcs.plagiarism(f.arraylist2.get(i),f.arraylist2.get(j)));
				fp_plag.add(fingerprinting.plagiarism(f.arraylist2.get(i),f.arraylist2.get(j)));
				
			}
		}
		//fingerprinting.plagiarism(f.arraylist2.get(0),f.arraylist2.get(1));
		
	
		
		Printmatrix p=new Printmatrix();
		System.out.printf("\n%50s\n\n", "Plagiarism by Bag Of Words");
		p.print_matrix(bag_plag);
		System.out.printf("\n%50s\n\n","plagiarism by LCS");
		p.print_matrix(lcs_plag);
		System.out.printf("\n%50s\n\n","plagiarism by finger printing");
		p.print_matrix(fp_plag);


		//System.out.println(bag_plag);
		//System.out.println(lcs_plag);
		
		
	}


}
