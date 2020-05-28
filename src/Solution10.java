import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.fluent.Request;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Solution10 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int userId = 2; //Integer.parseInt(bufferedReader.readLine().trim());

        int locationId = 8; //Integer.parseInt(bufferedReader.readLine().trim());

        int netStart = 100; //Integer.parseInt(bufferedReader.readLine().trim());

        int netEnd = 200; //Integer.parseInt(bufferedReader.readLine().trim());

        //int result = Result.getTransactions(userId, locationId, netStart, netEnd);
        int result = Result2.getTransactions(userId, locationId, netStart, netEnd);
       
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}

class Sample {

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<UserDetails> data;
	
	public Sample(int page, int per_page, int total, int total_pages, List<UserDetails> data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}
	
	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<UserDetails> getData() {
		return data;
	}
	public void setData(List<UserDetails> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Sample [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages=" + total_pages
				+ ", data=" + data + ", toString()=" + super.toString() + "]";
	}

	
}

class UserDetails {
	
	private int id;
	private int userId;
	private String userName;
	private String timestamp;
	private String txnType;
	private String amount;
	private Location location;
	private String ip;
	
	public UserDetails(int id, int userid, String userName, String timestamp, String txnType, String amount,
			Location location, String ip) {
		super();
		this.id = id;
		this.userId = userid;
		this.userName = userName;
		this.timestamp = timestamp;
		this.txnType = txnType;
		this.amount = amount;
		this.location = location;
		this.ip = ip;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timeStamp) {
		this.timestamp = timeStamp;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userId=" + userId + ", userName=" + userName + ", timestamp=" + timestamp
				+ ", txnType=" + txnType + ", amount=" + amount + ", location=" + location + ", ip=" + ip
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}

class Location {
	private int id;
	private String address;
	private String city;
	private String zipCode;
	public Location(int id, String address, String city, String zipCode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return "Location [id=" + id + ", address=" + address + ", city=" + city + ", zipCode=" + zipCode
				+ ", toString()=" + super.toString() + "]";
	}
	
}



class Result2 {

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
	
	public static Sample getFromhost(String userId) throws InterruptedException, ExecutionException {
    	
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
		CompletableFuture<Sample> future2 = future1.thenApply(s -> fromJson(s));
		
		return future2.get();
		
	}
		 
	  public static Sample fromJson(String json) {
		  ObjectMapper objectMapper = new ObjectMapper();
	    try {
	      return objectMapper.readValue(json, Sample.class);
	    } catch (IOException e) {
	      throw new RuntimeException(e);
	    }
	  }
		  

	public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
 
   	
    	try {
			Sample resp = getFromhost(String.valueOf(userId));
			System.out.println("response--:"+ resp);
			int pageNo = resp.getTotal_pages();

			resp.getData().stream()
			.filter(e-> Integer.parseInt(e.getIp().substring(0,3))>=netStart && Integer.parseInt(e.getIp().substring(0,3))<=netEnd)
			.filter(e->e.getLocation().getId()==locationId)
			.forEach(System.out::println);			
			
			
			double summ = resp.getData().stream()
				.filter(e-> Integer.parseInt(e.getIp().substring(0,3))>=netStart && Integer.parseInt(e.getIp().substring(0,3))<=netEnd)
				.filter(e->e.getLocation().getId()==locationId)
				.mapToDouble(e->{
					try {
						return NumberFormat.getCurrencyInstance(Locale.US).parse(e.getAmount()).floatValue();
					} catch (ParseException e1) {
						e1.printStackTrace();
						return 0;
					}
					
				})
				.sum();
				
			System.out.println("summation--:" + summ);
			
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    	
 		return 0;

    }


    

    
    
    
    
}
