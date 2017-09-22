package plag_project;

public class Lcs {
	static float plag;
	
/*this class takes two strings of corresponding files as input and calucalates plagiarism 
 * between these two files by finding longest common substring using dynamic programming*/	

	public static Float plagiarism(String  a,String  b)
	{
		int n=a.length();
		int m=b.length();
		int [][] matrix=new int[n+1][m+1];
		int i,j;
		for(i=0;i<n+1;i++)
		{
			matrix[i][0]=0;			//initilaizing 1st coloumn of matrix with zeros
		}
		for(i=0;i<m+1;i++)
		{
			matrix[0][i]=0;			//initilaizing 1st row of matrix with zeros
		}
		/*this loop fills the array position with '0' if both chars are not same
		 * else fills with one more than previous diagonal element  */
		
		for(i=1;i<n+1;i++)
		{
			for(j=1;j<m+1;j++)
			{
				if(a.charAt(i-1)==b.charAt(j-1))
				{
					matrix[i][j]=matrix[i-1][j-1]+1;
				}
				else 
				{
					matrix[i][j]=0;
				}
			}
		}
		int max=0;
		
		//max of array is length of longest common substring
		
		for(i=0;i<n+1;i++)
		{
			for(j=0;j<m+1;j++)
			{
				if(max<matrix[i][j])
				{
					max=matrix[i][j];
				}
			}
			//System.out.println();
		}
		if(m+n==0)
		{
			plag=0;
		}
		else {
			plag=(float)(max*2)/(float)(m+n);
		}
		
		
		return plag*100;
		
	}
	

}
