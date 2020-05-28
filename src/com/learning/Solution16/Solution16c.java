package com.learning.Solution16;

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



class Result3 {

    /*
     * Complete the 'predictAnswer' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stockData
     *  2. INTEGER_ARRAY queries
     */

	
	public static int getLeftResult(int day, int[] stockData, int stockPrice) {
		int leftResult=-1;
		int leftSize = day-2;
		int leftIndex =-2;
		
		
		int i = leftSize;
		if(i>=0) {
			do {
				if(stockData[i] < stockPrice) {
					System.out.println("stockData.get(i) : " + stockData[i] + " : " + stockPrice);
					leftIndex = i;
					break;
				}			
				i--;
			}while(i>=0);
		}
		
//		for(int i=leftSize; i>=0;i--)
//		{
//			System.out.println(i + " : " + stockData.get(i));
//			if(stockData.get(i) < stockPrice) {
//				System.out.println("stockData.get(i) : " + stockData.get(i) + " : " + stockPrice);
//				leftIndex = i;
//				break;
//			}
//		}
		
		System.out.println("leftIndex :" + (leftIndex+1));
		leftResult = (leftIndex+1);
		
		return leftResult;
	}
	
	public static int getRightResult(int day, int[] stockData, int stockPrice) {
		int rightResult = -1;
		int rightIndex =-2;
//		int[] stock = stockData.stream().mapToInt(i->) 
		int i=day;
		int size = stockData.length;
		do {
			
			if(stockData[i] < stockPrice) {
				System.out.println("stockData.get(i) : " + stockData[i] + " : " + stockPrice);
				rightIndex = i;
				break;
			}
			i++;
			
		}while(i<(size-1));
		
		
//		for(int i=day; i<stockData.size();i++)
//		{
//			System.out.println(i + " : " + stockData.get(i));
//			if(stockData.get(i) < stockPrice) {
//				System.out.println("stockData.get(i) : " + stockData.get(i) + " : " + stockPrice);
//				rightIndex = i;
//				break;
//			}
//		}
		
		System.out.println("rightIndex :" + (rightIndex+1));		
		rightResult = (rightIndex+1);
		
		return rightResult;
	}
	
	public static int getResult(int day , int[] stockData){
			//System.out.println("day-----:" + day);
			int days = stockData.length;
			//System.out.println("days---:" + days);
			int stockPrice = stockData[day-1];
			System.out.println("stockPrice---:" + stockPrice);
	
			int leftResult = getLeftResult((day),stockData, stockPrice ) ;
			int rightResult = getRightResult((day),stockData, stockPrice ) ;

			int result = -1;
			int leftDiff = -1;
			int rightDiff = -1;
			if(leftResult!= -1)
				leftDiff = day - leftResult;
			if(rightResult != -1) 
				rightDiff = rightResult - day;
			
			
			if(leftResult == -1 && rightResult ==-1)
				result = -1;
			else {
				if(leftResult !=-1 && rightResult == -1)
					result = leftResult;
				else if(leftResult == -1 && rightResult != -1)
					result = rightResult;
				else if(leftDiff == rightDiff)
					result = leftResult;
				else if(leftDiff < rightDiff)
					result = leftResult;
				else
					result = rightResult;
			}
			
		//System.out.println("result------------------:"+result);	
		return result;
		
	}
	
    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
    	
    	//System.out.println("StockData--"+ stockData);
    	long startTime = System.nanoTime();
    	List<Integer> result = new ArrayList<>();
   
    	int[] stock = new int[stockData.size()];
    	for(int i = 0;i < stockData.size();i++)
    		stock[i] = stockData.get(i);
   	
    	
    	for(int i=0; i< queries.size();i++) {
    		result.add(getResult(queries.get(i), stock));
    	}
	
       	
		System.out.println("result--:" + result);
    // Write your code here
    	long endTime = System.nanoTime();
    	long secs=TimeUnit.NANOSECONDS.toMillis((endTime - startTime));
    	System.out.println("Seconds:" + secs); 
		return result;
    }

}

public class Solution16c {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stockDataCount = 100; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> stockData = Arrays.asList(89214,26671,75144,32445,13656,66289,21951,10265,59857,59133,63227,86121,37411,54628,25859,43510,63756,54763,30852,53243,
        		76238,96885,33074,17745,81814,43436,79172,92819,30001,68442,54021,35566,95113,29164,84362,25120,11804,6313,51736,71661,81797,
        		14962,57781,35560,85941,99991,95421,66048,54754,26272,35642,47343,39508,85068,65087,21321,28503,60611,30491,58503,29052,84512,
        		94069,40516,13675,78430,65635,25479,1094,17370,13491,99243,48683,71271,34802,34624,87613,46574,671,42366,89197,36313,89708,28704,
        		21380,54795,66376,49882,15405,96867,24737,60808,81378,35157,1324,11404,29938,66958,53234,47384);
        		
        		
//        IntStream.range(0, stockDataCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());

        int queriesCount = 50; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = Arrays.asList(80,24,26,62,46,79,85,59,52,8,76,
        		48,72,84,3,3,30,30,36,86,96,72,93,25,28,68,81,18,78,14,1,57,90,26,18,87,56,55,97,59,62,73,58,85,8,60,87,89,89,22);
        		
//        	List<Integer> queries = Arrays.asList(1);
        		
        		
//        		Arrays.asList(80,24,26,62,46,79,85,59,52,8,76,
//        		48,72,84,3,3,30,30,36,86,96,72,93,25,28,68,81,18,78,14,1,57,90,26,18,87,56,55,97,59,62,73,58,85,8,60,87,89,89,22);//, 1, 8
        		
//       IntStream.range(0, queriesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());

        List<Integer> result = Result3.predictAnswer(stockData, queries);

        
//        79,37,24,61,45,-1,89,57,51,38,79,49,71,85,2,2,29,29,37,85,95,71,92,24,27,69,80,19,79,13,2,56,89,24,19,86,65,56,96,57,61,71,57,89,38,59,86
//        95,95,21
//        bufferedWriter.write(
//            result.stream()
//                .map(Object::toString)
//                .collect(joining("\n"))
//            + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
