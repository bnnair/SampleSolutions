import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	int count = 0;
    	int prev = 0;
    	
        int[] ar = new int[]{ 10, 20, 20, 10, 10, 30, 50, 10, 20 };
        int n=9;

        Arrays.sort(ar);
        
        for (int i = 0; i < n; i++) {
        	  System.out.println(ar[i]);
        }
        
     	for (int i = 0; i < n; i++) {
         	int current = ar[i]; 
         	System.out.println(i + "--" + current);

         	System.out.println(prev);
         	
         	System.out.println((current ==  prev));
         	if(current == prev) {
         		count = count +1;
         		System.out.println("if--" + count);
         		prev = 0;
         	}else {
         		prev = current;
         	}
         	
     	}
     	System.out.println("count------"+count);
		
		
		

	}

}
