package com.learning.Solution12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;



public class Solution13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String requestUrl = "https://jsonmock.hackerrank.com/api/transactions/search?userId=2";

		BufferedReader in = null;
		StringBuilder response=null;
		try {
	        final URLConnection con = new URL(requestUrl).openConnection();
			
	        final HttpsURLConnection httpsConn = (HttpsURLConnection) con;
	        httpsConn.setRequestMethod("GET");
	        con.setRequestProperty("Content-Type", "application/json");
	        
	        in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
	        String inputLine;
	        response = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        System.out.println(response.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (in != null) {
	            try {
	                in.close();
	            } catch (IOException ignored) {}
	        }
	    }
		
		
		Gson gson = new Gson();

		Sample sample = gson.fromJson(response.toString(),Sample.class);
		
		System.out.println(sample);
 
		
		
	}

}
