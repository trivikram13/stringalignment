/**
 * @(#)String_Align.java
 *
 * String_Align application
 *
 * @author 
 * @version 1.00 2013/1/7
 */
import java.io.*;
public class String_Align {
    
    public static void main(String[] args) throws IOException{
    	
    	int gap = -1;
    	int mat=3,mismat=-2;
    	
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str1=br.readLine();
    	br.readLine();
    	String str2 = br.readLine();
    	System.out.println(str1 + " "+str2);
    	int a[][]=new int[str1.length()+1][str2.length()+1];
    	a[0][0]=0;
    	for(int i=1;i<=str1.length();i++)
    	{
    		a[i][0]=(gap*i);
    	}
    	for(int i=1;i<=str2.length();i++)
    	{
    		a[0][i]=(gap*i);
    	}
    	
    	for(int i=1;i<=str1.length();i++)
    	{
    		
    		for(int j=1;j<=str2.length();j++)
    		{
    			int match=0;
    			int max=-20;
    			if(str1.charAt(i-1)==str2.charAt(j-1))
    			{
    				match=mat;
    			}
    			else {
    				match=mismat;
    			}
    			
    			int s1=a[i-1][j-1]+match;
    
    			if(s1>(a[i-1][j]+gap)&&s1>(a[i][j-1]+gap)){
    				max=s1;
    			}
    			
    			else if(a[i-1][j]>=a[i][j-1]){
    				max = a[i-1][j]+gap;
    			}
    			else{
    				max = a[i][j-1]+gap;
    			}
    			a[i][j]=max;
    			
    			
    			//System.out.print(a[i][j]+"  ");
    		}
    		//System.out.println();
    	}
    	
    	for(int i=0;i<=str1.length();i++){
    		for(int j=0;j<=str2.length();j++){
    			
    			System.out.print(a[i][j]+"  ");
    			
    		}
    		System.out.println();
    	}
    	
    	
  
    	
    	int i=str1.length();
    	int j=str2.length();
    	String first="";
    	String sec="";
    	
    	while(i>0&&j>0){
    	
    	if((a[i][j]-gap)==a[i-1][j])
    		{
    			first =(str1.charAt(i-1)+"")+first;
    			sec = ('_'+"")+sec;
    			i--;	
    		}
    			
    		else if((a[i][j]-gap)==a[i][j-1]) {
    			sec =(str2.charAt(j-1)+"")+sec;
    			first =('_'+"")+first;
    			j--;
    			
    		}
    		else
    		//if((a[i][j]-1==a[i-1][j-1])||(a[i][j]==a[i-1][j-1]))
    		{
    			first = (str1.charAt(i-1)+"")+first;
    			sec =(str2.charAt(j-1)+"")+sec;
    			i--;
    			j--;
    		}	
    	}
    	if(i>0){
    		while(i>0){
    			first =(str1.charAt(i-1)+"")+first;
    			sec =('_'+"")+sec;
    			i--;
    		}
    	}
    	else{
    		while(j>0){
    			first =('_'+"")+first;
    			sec = (str2.charAt(j-1)+"")+sec;
    			j--;
    		}
    	}
    	
    System.out.println(first);
    System.out.println(sec);
    	
    	
  }
}

