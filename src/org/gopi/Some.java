package org.gopi;

public class Some {

	public void printDigitPattern()
	{

		int lastdigit = 0;
		int remainder = 0;
		int flag = 0;
		for(int i = 10; i < 1000; i++)
		{

		int n = i;
		remainder = n%10;

		while(n>0)
		{

		lastdigit = n%10;
		n = n/10;
		if(!(lastdigit == remainder)){
		flag=0;
		break;
		}
		flag++;
		}
		if(flag>0)
		System.out.println(i);

		}	
		}
	public static void main(String[] args) 
	{
		Some s=new Some();
		s. printDigitPattern();

	}

}
