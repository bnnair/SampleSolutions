package com.learning.Solution14;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



class Result1 {

     /*
     * Complete the 'countMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY firstDay
     *  2. INTEGER_ARRAY lastDay
     */

	public static Set<Integer> addMeetings(List<Integer> firstDay, List<Integer> lastDay) {
		System.out.println("Current Thread-:" + Thread.currentThread());
		
    	Set<Integer> meetings = new HashSet<>();
    	
    	
//		for (int i=0;i<firstDay.size();i++) {
//			int start = firstDay.get(i);
//			int end = lastDay.get(i);
//
//			if(start == end) {
//				if(!meetings.contains(start)) {
//					meetings.add(start);
//				}
//			}
//			else {
//	    		for (int j=start; j<=end;j++) {
//	    			if(!meetings.contains(j)){
//	    				meetings.add(j);
//	    				break;
//	    			}
//	    		}
//			}
//			System.out.println(start+" : "+ end + " : " + meetings);
//		}
		return meetings;
	}
    
    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
    	System.out.println(firstDay);
    	System.out.println(lastDay);
    	Set<Integer> countList = new HashSet<>();
    	long startTime = System.nanoTime();
    	countList = addMeetings(firstDay, lastDay);
    	System.out.println("countlist :"+ countList);
		
    	long endTime = System.nanoTime();
    	long secs=TimeUnit.NANOSECONDS.toMillis((endTime - startTime));
    	System.out.println("Seconds:" + secs); 
    	
    	return countList.size();

		

    }

}

public class Solution14a {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int firstDayCount = 5; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> firstDay = new ArrayList<>();
        firstDay.add(1);
        firstDay.add(2);
        firstDay.add(1);
        firstDay.add(2);
        firstDay.add(2);

        
//        for (int i = 0; i < firstDayCount; i++) {
//            int firstDayItem = Integer.parseInt(bufferedReader.readLine().trim());
//            firstDay.add(firstDayItem);
//        }

        int lastDayCount = 5; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> lastDay = new ArrayList<>();
        lastDay.add(3);
        lastDay.add(2);
        lastDay.add(1);
        lastDay.add(3);
        lastDay.add(3);
        
//        for (int i = 0; i < lastDayCount; i++) {
//            int lastDayItem = Integer.parseInt(bufferedReader.readLine().trim());
//            lastDay.add(lastDayItem);
//        }

        int result = Result1.countMeetings(firstDay, lastDay);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
