import java.io.IOException;

public class Solution3 {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
    	int steps=0;

    	
    	int n = c.length;
    	System.out.println("n :" + n);
    	//0,0,1,0,0,0,0,0,1,0
    	
        int i = 0;
		while (i < n-1) {
        	System.out.println(i + "=====" + c[i] + "======" + steps);
        	
        	if(i+2<n && c[i+2]==0) {
        		steps++;
        		i=i+2;
        		System.out.println("i=:" + i + "steps :" + steps);
         	} 
        	else {
        		steps++;
        		i++;
        		System.out.println("i=:" + i + "steps :" + steps);
        	}
        	
        	
        	//           	prevVal = val;       	
        }
    	
    	System.out.println("result :::: " + steps);
    	return steps;
    }


    public static void main(String[] args) throws IOException {
    	//0 0 1 0 0 1 0
//    	/0 0 0 1 0 0
    	//0 0 1 0 0 0 0 1 0 0
    	
        int[] c = new int[] {0,0,1,0,0,0,0,1,0,0};
        

        int result = jumpingOnClouds(c);


    }
}
