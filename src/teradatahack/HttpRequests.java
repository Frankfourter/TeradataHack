package teradatahack;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import javax.xml.bind.DatatypeConverter;

import json.JSONObject;




public class HttpRequests {
	
	public HttpRequests(){
	}
	
	public static void testHttp(){
		URL url;
		System.out.println("testHTTP");
		String userName = "hack_user05";
		String password = "tdhackathon";
		String path = "https://153.64.73.17:1080/tdrest";
		//String header = "{"
		try {
			url = new URL(path);
			try {
				URLConnection connection = url.openConnection();
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Accept", "application/vnd.com.teradata.rest-v1.0+json");
				connection.setRequestProperty("Authorization", DatatypeConverter.printBase64Binary(("Basic " + userName + ":" + password).getBytes()));
				HashMap<String, String> queryBands = new HashMap<String, String>();
				queryBands.put("Application Name", "TeradataHackathon");
				queryBands.put("version", "1.0");
				HashMap<String, String> data = new HashMap<String, String>();
				data.put("query", "SELECT * FROM crime_data.murders_by_weapon_type");
				data.put("format", "object");
				//data.put("queryBands", value)
				//data = new JSONStringer				
				System.out.println(connection);
				//connection.setRequestProperty("data", "{'query' : 'SELECT * ', 'format' : 'object'}");
				connection.connect();
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
