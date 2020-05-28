import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Solution6 {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	int ln = a.length;
    	int[] result = new int[ln];
    	int j = d;
    	
    	for(int i=0; i<ln;i++) {
    		result[i] = a[j];
    		j+=1;
    		if(j==ln) {
    			j=0;
    		}
    		System.out.println(result[i]);
    	}
    		
    	
    	
    	
    	return result;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] nd = scanner.nextLine().split(" ");

        int n = 5; //Integer.parseInt(nd[0]);

        int d = 1; //Integer.parseInt(nd[1]);

        int[] a = new int[n];

        //String[] aItems = new String[] {"1","2","3",;
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            //int aItem = Integer.parseInt(aItems[i]);
            a[i] = i+1;
        }

        int[] result = rotLeft(a, d);

//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }



       // scanner.close();
    }
}
