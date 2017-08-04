package com.zwl.List;

public class Factorial {

	public static int factorial(int n)
	{
		if(n<0)
			throw new IllegalArgumentException("n="+n);
		if(n==0||n==1)
			return n;
		return factorial(n-1)+factorial(n-2);
	}
	
	public static void main(String args[]){
		for(int i=0;i<=24;i++)
			System.out.print(factorial(i)+" ");
		
	}
}
