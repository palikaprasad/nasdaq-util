package au.com.nasdaq;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		long index=1, n=0, c=0;
		Scanner in = null;
		List<BigInteger> resultAsList=new ArrayList<BigInteger>();
		
		try {
			
			//taking value as command line argument.
			in = new Scanner(System.in); 
	        System.out.printf("Enter value of N:  ");
	        n = in.nextLong();
	        System.out.printf("Enter value of C:  ");
 	        c = in.nextLong();
	        
	        //Execute the logic only when we recieve the proper values of C and N
			if(n > 0 && c > 0) {
				BigInteger sum=null;
				//First number in the List always zero.
				resultAsList.add(BigInteger.valueOf(0));
				while(true) {
					if(n > index) {
						BigInteger temp=multiplySequence(index, c);
						if(sum==null) {
							sum=temp;
						}else {
							sum=sum.add(temp);
						}
						index++;
						//Print all number when n is less than 100
						if(n <= 100) {
							resultAsList.add(temp);
						} else {
							if(index <=10) {
								resultAsList.add(temp);
							}
						}
						
					} else {
						break;
					}
				}
				//Print number here
				printNumbers(resultAsList, sum);
			} else {
				
			}
		}catch(Exception e) {
			System.out.println("exception occured while processing..");
			e.printStackTrace();
		}finally {
			if(in!=null) {
				in.close();
			}
		}
	}

	private static void printNumbers(List<BigInteger> resultAsList, BigInteger sum) {
		int index=0;
		for (Iterator<BigInteger> iterator = resultAsList.iterator(); iterator.hasNext();) {
			index++;
			BigInteger number = iterator.next();
			System.out.print(number.toString());
			if(resultAsList.size() == index) {
				System.out.print(" = ");
				System.out.print(sum.toString());
			} else {
				System.out.print(" + ");
			}
		}
		System.out.println("");
	}
	
	//This is recursive method calculates product of preceeding numbers based on value of C
	private static BigInteger multiplySequence(long number, long counter){
		
		if(counter==1 || number == 1) {
			return BigInteger.valueOf(number);
		}else {
			BigInteger bigIntNumber=BigInteger.valueOf(number);
			BigInteger result= bigIntNumber.multiply(multiplySequence(number-1, counter-1));
			return result;
		}
	}

}
