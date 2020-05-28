import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class solution5 {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int[] sum = new int[16];
    	int n = 0;


    	int col = 0;
    	int hour=0;
    	int row = 0;
    	
    	int endcol = 3;
    	int rowstart = 0;
    	int colstart = 0;
    	int colcnt = 0;
		int rowlen = 6;
		int collen = 6;
		
    	while(true) {
    		hour++;

	        for (int i = rowstart; i < rowlen; i++) {
	        	System.out.println("---------------------------");
            	row++;
	            for (int j = colstart; j < collen; j++) {
	            	
	            	sum[n] += arr[i][j];
	            	colcnt++;
	                System.out.print(arr[i][j] + " " );
	                
	                if(colcnt==endcol) {
	                	col++;
	                	j=colstart;
	                	n++;
	                	colstart++;
	                	colcnt=0;
	                }
	                if(col == 4) {
	                	col=0;
	                	colcnt=0;
	                	if (hour ==2) {
	                		colstart =1;
	                	}else
	                		colstart=0;
	                	break;
	                }
	            }
	            System.out.println("");

	            if (row == 4) {
	            	colstart=1;
	            	break;
	            }
	        }
	        rowstart++;
	        collen=6;
	        colstart=0;
	        endcol=3;
	        n=0;
	        row=0;
	        if(hour==1) {
	        	endcol = 1;
	        	colstart=1;
	        }
	        if(hour ==3)
	        	break;
    	} 
    	
        
        Arrays.sort(sum);
        for (int k = 0; k < 16; k++) {
        	System.out.print(sum[k] + " " );
        }
        
        System.out.println(sum[15] + " " );

        
    	return sum[15];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
        	
            for (int j = 0; j < 6; j++) {
                arr[i][j] = j;
                System.out.print(arr[i][j] + " " );
            }
            System.out.println(" " );
        }

        int result = hourglassSum(arr);

    }
}
