import java.io.IOException;



class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
    // Write your code here
    for (int i =1; i<=n; i++)
    {
    	
        //i is a multiple of both 3 and 5, print FizzBuzz
    		if(i%3==0 && i%5==0)
    			System.out.println("FizzBuzz");
    		if(i%3==0 && i%5 != 0)
				System.out.println("Fizz");
    		if(i%5==0 && i%3!=0)
				System.out.println("Buzz");
    		if(i%3!=0 && i%5!=0)
				System.out.println(i);
        //i is a multiple of 3 and not 5, print Fizz
        	
        
        //i is a multiple of 5 and not 3, print Buzz
        	
        
        //i is not a multiple of 3 or 5, print value of i.

    
    }
    	
    	
    	
    	
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        
        int n = 15;

        Result.fizzBuzz(n);
}
}