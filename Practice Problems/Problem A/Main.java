import java.util.*;
import java.io.*;
public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//noOfCases will store number of cases in input
		int noOfCases = sc.nextInt();
		sc.nextLine();
		//caseInLine will store a input case at a time
		String caseInLine = "";
		//temp will temporarily store index of alien_number's digit in source_language
		//intermedCounter will finally store the count of alien numbers in source_language before alien_number
		//tempCounter will temporarily store value of intermedCounter before performing some changes on intermedCounter
		//noOfDigits will finally store the number of digits in the alien_number in target_language
		//tempDigits will temporarily store modified noOfDigits to perform calculations
		//index will finally store the index of digit in target_language, which is the current digit in alien_number of target_language
		int temp, intermedCounter, tempCounter, noOfDigits, tempDigits, index;
		//this "for" loop iterates over all cases one at a time
		for(int i=0;i<noOfCases;i++) {
			caseInLine = sc.nextLine();
			//caseDetail will store 3 parts of input case separately in the array
			//caseDetail[0] will store alien_number
			//caseDetail[1] will store source_language
			//caseDetail[2] will store target_language
			String [] caseDetail;
			caseDetail = caseInLine.split(" ");
			//intermedCounter reset to zero for each case
			intermedCounter = 0;
			//if number is 4 digit number, then this "for" loop is to count number of all 1,2,3 digit numbers
			for(int j=1;j<caseDetail[0].length();j++) {
				intermedCounter = intermedCounter + (caseDetail[1].length()-1)*(int)(Math.pow(caseDetail[1].length(),j-1));
			}
			//if number is 4 digit number, then this "for" loop is to count no of 4 digit number before given alien_number
			for(int j=1;j<=caseDetail[0].length();j++) {
				temp = caseDetail[1].indexOf(caseDetail[0].charAt(j-1));
				if(j==1)
					temp = temp-1;
				intermedCounter = intermedCounter + temp*(int)(Math.pow(caseDetail[1].length(),caseDetail[0].length()-j));
			}
			//Displays count of alien numbers in source_language before alien_number
			//System.out.println("Case #" + (i+1) + ": " + intermedCounter);
			//ans will finally store alien_number in target_language, the equivalent of given alien_number in source_language
			String ans = "";
			//intermedCounter reset to zero for each case
			tempCounter = 0;
			//noOfDigits reset to one for each case
			noOfDigits = 1;
			//this while loop is to find the number of digits in the alien_number in target_language
			while(intermedCounter>=0) {
				tempCounter = intermedCounter;
				intermedCounter = intermedCounter - (caseDetail[2].length()-1)*(int)(Math.pow(caseDetail[2].length(),noOfDigits-1));
				noOfDigits++;
			}
			//total noOfDigits-1 digits as last while loop iteration increments noOfDigits by extra 1 
			tempDigits = noOfDigits-1;
			//this while loop is to iterate over all digits, one at a time
			while(tempDigits>0) {
				//index reset to zero for each digit
				index = 0;
				intermedCounter = tempCounter;
				while(intermedCounter >= 0) {
					tempCounter = intermedCounter;
					intermedCounter = intermedCounter - (int)Math.pow(caseDetail[2].length(),tempDigits-1);
					index++;
				}
				index--;
				if(tempDigits==(noOfDigits-1)) {
					index++;
				}
				//every time a digit of alien_number in target_language is concatenated to ans
				ans = ans + String.valueOf(caseDetail[2].charAt(index));
				tempDigits--;
			}
			//Displays alien_number in target_language, the equivalent of given alien_number in source_language for each case
			System.out.println("Case #" + (i+1) + ": " + ans);
		}
	}
}