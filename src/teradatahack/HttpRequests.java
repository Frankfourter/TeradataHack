package teradatahack;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;




public class HttpRequests {
	
	public HttpRequests(){
	}
	
	public static void testHttp(){
		URL url;
		System.out.println("testHTTP");
		String userName = "hack_user05";
		String password = "tdhackathon";
		String path = "https://dragon.teradata.ws:1080";
		//String header = "{"
		try {
			url = new URL(path);
			try {
				URLConnection connection = url.openConnection();
				connection.setRequestProperty("Accept-Charset", "UTF-8");
				connection.setRequestProperty("contentType", "application/json");
				connection.setRequestProperty("Accept",  "application/vnd.com.teradata.rest-v1.0+json");
				connection.setRequestProperty("Authorization", "Basic " + userName + ":" + password);
				connection.connect();
				//connection.setRequestProperty("data", "{'query' : 'SELECT * ', 'format' : 'object'}");
				InputStream response = connection.getInputStream();
				System.out.println(response);
				System.out.println("Second try");
				connection.connect();
				/*connection.setDoOutput(true);

				*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("We hv");
				e.printStackTrace();
			}
		} catch (MalformedURLException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		testHttp();
		System.out.println("we are done");
	}
	
}
