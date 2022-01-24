package tests;

import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter the size of array  :");
		Scanner scan = new Scanner(System.in);
		
		int sizeOfArray = scan.nextInt();
		
		if (sizeOfArray <= 0)
			System.out.println("Size of the array cannot be negative value or zero, please enter real size ...");
		else {
			
			int a[] = new int[sizeOfArray];
			
			for (int i=0; i<a.length; i++) {
				System.out.println("Please enter number : " + (i+1) + ":");
				a[i] = scan.nextInt();
				maxAndMin(a);
			}
		}
		
	}

	public static void maxAndMin(int a[]) {
		
		int maxNum= 0;
		int minNum = 0;
		
		for(int i=0; i<a.length; i++) {
			
			 if (a[i]>maxNum)
				maxNum = a[i];
			else if (a[i]<minNum)
				minNum = a[i];
		}
		System.out.println("Maxmum number value : " + maxNum);
		System.out.println("Minimum number value : " + minNum);
	}
}
