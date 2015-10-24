package teradatahack;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;




public class HttpRequests {
	
	public HttpRequests(){
	}
	
	public static void testHttp(){
		URL url;
		System.out.println("testHTTP");
		String userName = "hack_user05";
		String password = "tdhackathon";
		String path = "https://dragon.teradata.ws:1080/tdrest/systems";
		//String header = "{"
		try {
			url = new URL(path);
			try {
				URLConnection connection = url.openConnection();
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Accept", "application/vnd.com.teradata.rest-v1.0+json");
				connection.setRequestProperty("Authorization", "Basic aGFja191c2VyMDU6dGRoYWNrYXRob24=");
				HashMap<String, String> queryBands = new HashMap<String, String>();
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("query", "SELECT * FROM crime_data.murders_by_weapon_type");
				data.put("format", "object");
				System.out.println(connection);
				//connection.setRequestProperty("data", "{'query' : 'SELECT * ', 'format' : 'object'}");
				InputStream response = connection.getInputStream();
				//System.out.println(response);
				System.out.println("Second try");
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
		System.out.println(System.getProperty("java.runtime.version"));
		testHttp();
		System.out.println("we are done");
	}
	
}
