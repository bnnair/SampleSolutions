import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

    	int level = 0;
    	int valleys = 0;
    	boolean  prevNegVal = false;
    	int negVal = 0;
    	
    	for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            System.out.println(ch);

             
            if(ch == 'D') {
	        		negVal++;
	        		System.out.println("negVal:" + negVal);
            }else {
	        	  negVal--;
            	  System.out.println("negVal:" + negVal);
    	      	  if(negVal==0 ) {
    	    		  valleys++;
    	    		  System.out.println("valleys:" + valleys);
    	    	  }
            }
   	
    	}
    	//valleys--;
		System.out.println("valleys====" + valleys);
		return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

    	//UDDDUDUU  ---- 1
    	//UDUUUDUDDD --- 0
    	//DDUU --1
    	//DDUUDDUDUUUD  -- 2
        String s = "DDUUDDUDUUUD";
		int n = 8;
		int result = countingValleys(n, s);
		


    }
}
