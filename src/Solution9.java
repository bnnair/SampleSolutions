import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.fluent.Async;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Solution9 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int userId = 2; //Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = 8; //Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = 5; //Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = 50; //Integer.parseInt(bufferedReader.readLine().trim());

        //int result = Result.getTransactions(userId, locationId, netStart, netEnd);
        int result = Result1.getTransactions(userId, locationId, netStart, netEnd);
       
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}


class Result1 {

    /*
     * Complete the 'getTransactions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER userId
     *  2. INTEGER locationId
     *  3. INTEGER netStart
     *  4. INTEGER netEnd
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */
	
	public static Map<String, Object> getFromhost(String userId) throws InterruptedException, ExecutionException {
    	
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
    		String resp="";
    		String requestURL = "https://jsonmock.hackerrank.com/api/transactions/search?userId="+String.valueOf(userId);
    		Request request = Request.Get(requestURL);
    		//System.out.println("Request:" + requestURL);
    		try {
    			resp = request.execute().returnContent().asString();
    			
    			//System.out.println(Thread.currentThread());
				return resp;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return resp;
    	});
		CompletableFuture<Map<String, Object>> future2 = future1.thenApply(s -> fromJson(s));
		
		return future2.get();
		
	}
		 
	  public static Map<String, Object> fromJson(String json) {
		  ObjectMapper objectMapper = new ObjectMapper();
	    try {
	      return objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
	    } catch (IOException e) {
	      throw new RuntimeException(e);
	    }
	  }
		  
	  
	  public static Map<String,Object> createMap(Object row){
		
		  ((Map<String,Object>)row).entrySet().stream()
		  	.filter(e->e.getKey()=="amount" || e.getKey()=="location" || e.getKey()=="ip")
		  	.forEach(System.out::println);
		  
		  
		  
		  return null;
		  
		  
	  }

	public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
 
   	
    	try {
			Map<String,Object> resp = getFromhost(String.valueOf(userId));
			//System.out.println("response--:"+ resp);
			List<Object> dataList= resp.entrySet().stream()
				.filter(e->e.getKey()=="data")
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
				
//			
			((Collection<Object>) dataList.get(0)).stream()
				.map(Result1::createMap)
				.forEach(System.out::println);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    	
    			
    	
  	
    	
//    	Future<Content> future = async.execute(request, new FutureCallback<Content>() {
//    	    public void failed (final Exception e) {
//    	        System.out.println(e.getMessage() +": "+ request);
//    	    }
//    	    public void completed (final Content content) {
//    	        System.out.println("Request completed: "+ request);
//    	        System.out.println("Response:\n"+ content.asString());
//    	    }
//
//    	    public void cancelled () {}
//    	});
    	
    	
    	
		return netEnd;

    }


    

    
    
    
    
}
