import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution4 {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

    	long count = 0;
 
    		
    	///check length of str is greater than number
    	///if greater then count a
    	long len = s.length();
    	if (len > n ) {
    		System.out.println(len + ":::" + n);
    		count = getaCount(s.substring(0,(int) n));
    	}else {
	    	//else go to repeat procedure
	    	//count a in the string
	    	//get how many times the string need to be appended
	    	//multiple th count with xfactor to get the result
	       	long xFactor =  (long) Math.ceil(n/len);
	       	long rem = n % len ;
	       	System.out.println(rem);
	    	System.out.println(xFactor);
	    	count = getaCount(s) * (xFactor);
	    	System.out.println(count);
	    	if(rem!=0) {
		    	long tmpCnt = getaCount(s.substring(0,(int) rem));
		    	count = count + tmpCnt;
	    	}
	    	System.out.println(count);
    	}
    	return count;
    	
    }
    
    static long getaCount(String s) {
    	
    	int count = 0;
    	for (int i =0 ; i< s.length(); i++) {
    		
    		char ch = s.charAt(i);
    		if(ch == 'a') {
    			count++;
    		}
    		
    	}
    	
    	System.out.println("getaCount ===" + count);
    	return count;
    }

    public static void main(String[] args) throws IOException {
      
    	String s = "ababa";
    	long n = 3;

        long result = repeatedString(s, n);

    }
}
