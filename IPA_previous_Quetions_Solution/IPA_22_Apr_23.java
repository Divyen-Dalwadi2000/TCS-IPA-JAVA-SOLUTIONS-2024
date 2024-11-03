/*
 read String and find the count of words starting with vovel in the Streing . 
 If no words are present in the String value then it should print "No String found " 
 
 
 Note : " All search should be case insensitive 
 
 
 
 input 1 : 
 Everyone should practice and learn to became professional.
 
 output : 
 2 

 input 2 : 
hi guys
 
 output : 
 No String found
 
 input 3 : 
 if you are alone then feel the nature 
 
 output : 
 3

 input 4: 
 The greatest glory in living lies not In never falling, but in rising every time we fall.
 
 output : 
 4
 
  
 */

import java.util.Scanner;

public class IPA_22_Apr_23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = getWordStartingWithVovel(s);
		if(count == 0)
		{
			System.out.println("No String Found");
		}else
		{
			System.out.println(count);
		}

	}

	public static int getWordStartingWithVovel(String str) {

		int count = 0 ;
			
		String arr [] = str.split(" ");
		for(int i = 0 ; i < arr.length-1 ; i++)
		{	
			char first = arr[i].toLowerCase().charAt(0);
			if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u')
			{
				count++;
			}
		}
 		return count ;
	}

}
