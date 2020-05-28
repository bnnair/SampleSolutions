package com.learning.Solution15;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result2 {

    /*
     * Complete the 'kthPerson' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY p
     *  3. INTEGER_ARRAY q
     */
	public static int getResult(int qi, List<Integer> p, int k){
		int kth = 0;
		int count = 0;
		
		Integer[] targetArray = p.toArray(new Integer[p.size()]);
		int i=0;
		do {
			if(targetArray[i] >= qi) {
				kth = i+1;
				count++;
				if(count == k) {
					break;
				}
			}
			i++;
		}while(i<targetArray.length);
		
		
		
		
		
//		
//			for(int i=0;i<p.size();i++) {
//				if(p.get(i) >= qi) {
//					kth = i+1;
//					count++;
//					if(count == k) {
//						break;
//					}
//				}
//			}
		if (count<k)
			kth = 0;
		System.out.println("kth:");
		return kth;
	}
	
    public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {
		
    // Write your code here
	//k -- bus capacity
	//p -- list of passenger patience
	//q -- list of bus arrival times
    	System.out.println("p--:"+ p);
    	System.out.println("q--:"+ q); 
    	//System.out.println("Current thread :" + Thread.currentThread());

//   	List<Integer> result = new ArrayList<Integer>();
//    	int i=0;
//    	do {
//    		result.add(getResult(q.get(i), p, k));
//    		i++;
//    	}while(i<q.size());
    	
//    	for(int i=0; i<q.size();i++) {
//    		result.add(getResult(q.get(i), p, k));
//    	}
    	
    	
    	
    	List<Integer> result = q.stream().parallel()
			.map(e->{
				return getResult(e, p, k);	
			})
			.collect(Collectors.toList());
		
		System.out.println("result--:" + result);
    	return result;   // result =[2,4,0]
    }

}

public class Solution15b {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int k = 3; //Integer.parseInt(bufferedReader.readLine().trim());

        int pCount = 3; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Arrays.asList(2,5,3);
        		
        		
//        		new ArrayList<Integer>();
//        		p.add(1);
//        		p.add(4);
//        		p.add(4);
//        		p.add(3);
//        		p.add(1);
//        		p.add(2);
//        		p.add(6);
        		
//        IntStream.range(0, pCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());

        int qCount =2; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> q = Arrays.asList(1,5);
        		
//        		new ArrayList<Integer>();
//        	q.add(1);
//        	q.add(2);
//        	q.add(3);
//        	q.add(4);
//        	q.add(5);
//        	q.add(6);
//        	q.add(7);

//        IntStream.range(0, qCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());

        List<Integer> result = Result2.kthPerson(k, p, q);

//        bufferedWriter.write(
//            result.stream()
//                .map(Object::toString)
//                .collect(joining("\n"))
//            + "\n"
//        );

//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
