package embrace.devops;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MondayComOperations {

	private static final Logger LOGGER = LoggerFactory.getLogger(MondayComOperations.class);
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-item-by-Id")
	public String getItemById(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Item Id") MDParameterId MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemById entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items(ids:" + MDParams.getId() + "){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Get-multiple-items-by-Ids")
	public String getItemsByIds(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Item Ids") MDParameterId MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemsByIds entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items(ids:[" + MDParams.getId() + "]){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	


	@MediaType(value = ANY, strict = false)
	@Alias("Get-all-items-limit-by-number")
	public String getItemsLimitByNum(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Limit by") MDParameterLimitBy MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemsLimitByNum entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items(limit:" + MDParams.getId() + "){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Get-all-boards-limit-by-number")
	public String getBoardsLimitByNum(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Limit by") MDParameterLimitBy MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getBoardsLimitByNum entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{boards(limit:" + MDParams.getId() + "){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	

	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-all-items-newest-first")
	public String getItemsNewestFirst(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemsNewestFirst entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items(newest_first:true){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	

	
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-all-items-stucked")
	public String getItemsStucked(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Board Id") MDParameterId MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemsStucked entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items_by_column_values(board_id:" + MDParams.getId() + ",column_id:\\\"status\\\",column_value:\\\"Stuck\\\"){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}
	
	@MediaType(value = ANY, strict = false)
	@Alias("Get-all-items-done")
	public String getItemsDone(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Board Id") MDParameterId MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemsDone entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items_by_column_values(board_id:" + MDParams.getId() + ",column_id:\\\"status\\\",column_value:\\\"Done\\\"){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}

	@MediaType(value = ANY, strict = false)
	@Alias("Get-all-items-work-in-progress")
	public String getItemsWIP(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Board Id") MDParameterId MDParams, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com getItemsWIP entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\": \"{items_by_column_values(board_id:" + MDParams.getId() + ",column_id:\\\"status\\\",column_value:\\\"Working on it\\\"){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = getRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}

	
	@MediaType(value = ANY, strict = false)
	@Alias("Add-new-item")
	public String addItem(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Board Id") MDParameterId MDParams, @ParameterGroup(name="Item name") MDParameterName MDParamName, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com addItem entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\":\"mutation {create_item(item_name:\\\"" + MDParamName.getItemName() + "\\\", board_id:" + MDParams.getId() + "){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = postRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	

	@MediaType(value = ANY, strict = false)
	@Alias("Delete-item-by-Id")
	public String deleteItem(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Item Id") MDParameterId MDParams) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com deleteItem entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\":\"mutation {delete_item(item_id:" + MDParams.getId() + "){id}}\"}";
		
		responseBody = postRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	
	
	@MediaType(value = ANY, strict = false)
	@Alias("List-all-users")
	public String listUsers(@Config MondayComConfiguration MDConfig, @ParameterGroup(name="Response Fields") MDGraphQLQueryFields MDFields) throws IOException, InterruptedException {
    	LOGGER.info("Monday.com listUsers entered");  		

		String responseBody;
		String url_in = MDConfig.getUrl();
    	String url = url_in;
    	String MDPayload = "{\"query\":\"{users(){"+ MDFields.getFields() + "}}\"}";
		
		responseBody = postRequest(MDConfig, url, MDPayload);

		return responseBody;
		
		
	}	

	
	private String getRequest(@Config MondayComConfiguration MDConfig, String MDURL, String MDPayload) throws IOException, InterruptedException {

		StringBuilder responseBodyReturn;
		int responseCode = 0;
		
		String pat = MDConfig.getToken();
    	String payload = MDPayload;    
		
    	URL url = new URL(MDURL);
    	LOGGER.info("Monday Request-url: " + url);  		
    	
    	URLConnection conn = url.openConnection();

    	try {
	    	if(conn instanceof HttpsURLConnection){
				LOGGER.info("Processing HTTPS request");
				HttpsURLConnection https = (HttpsURLConnection) conn;
	
	        	https.setDoOutput(true);
		    	https.setDoInput(true);
		    	https.setRequestMethod("GET");
		    	https.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		    	https.setRequestProperty("Accept", "application/json");    	
		    	
		    	https.setRequestProperty ("Authorization", pat);
		    	
	        	try(OutputStream os = conn.getOutputStream()){
					byte[] input = payload.getBytes("utf-8");
					os.write(input,0,input.length);
				}
				
		    	LOGGER.info("Response Code sendGETRequest: " + https.getResponseCode());
	
	    	} 
	    	else {
				LOGGER.info("Processing HTTP request");
		    	HttpURLConnection http = (HttpURLConnection) conn;
	        	String userCredentials = ":" + pat;

		    	http.setDoOutput(true);
		    	http.setDoInput(true);
		    	http.setRequestMethod("GET");
		    	http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		    	http.setRequestProperty("Accept", "application/json");    	

	        	http.setRequestProperty ("Authorization", pat);
		    	try(OutputStream os = conn.getOutputStream()){
					byte[] input = payload.getBytes("utf-8");
					os.write(input,0,input.length);
				}
				
		    	LOGGER.info("Response Code sendRequest: " + http.getResponseCode());

	    	}
	    	
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line+"\n");
	        }
	        br.close();

	        responseBodyReturn = sb;

	    	
		} catch(IOException e) {
	    	LOGGER.error("Error occurred while GET resource: " + url);
	    	e.printStackTrace();
	    	responseBodyReturn = null;
		}
		
		
	
		return responseBodyReturn.toString();
	}

	
	private String postRequest(@Config MondayComConfiguration MDConfig, String MDURL, String MDPayload) throws IOException, InterruptedException {

		StringBuilder responseBodyReturn;
		int responseCode = 0;
		
		String pat = MDConfig.getToken();
    	String payload = MDPayload;    
		
    	URL url = new URL(MDURL);
    	LOGGER.info("Monday Request-url: " + url);  		
    	
    	URLConnection conn = url.openConnection();

    	try {
	    	if(conn instanceof HttpsURLConnection){
				LOGGER.info("Processing HTTPS request");
				HttpsURLConnection https = (HttpsURLConnection) conn;
	
	        	https.setDoOutput(true);
		    	https.setDoInput(true);
		    	https.setRequestMethod("POST");
		    	https.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		    	https.setRequestProperty("Accept", "application/json");    	
		    	
		    	https.setRequestProperty ("Authorization", pat);
		    	
	        	try(OutputStream os = conn.getOutputStream()){
					byte[] input = payload.getBytes("utf-8");
					os.write(input,0,input.length);
				}
				
		    	LOGGER.info("Response Code postRequest: " + https.getResponseCode());
	
	    	} 
	    	else {
				LOGGER.info("Processing HTTP request");
		    	HttpURLConnection http = (HttpURLConnection) conn;

		    	http.setDoOutput(true);
		    	http.setDoInput(true);
		    	http.setRequestMethod("POST");
		    	http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		    	http.setRequestProperty("Accept", "application/json");    	

	        	http.setRequestProperty ("Authorization", pat);
		    	try(OutputStream os = conn.getOutputStream()){
					byte[] input = payload.getBytes("utf-8");
					os.write(input,0,input.length);
				}
				
		    	LOGGER.info("Response Code postRequest: " + http.getResponseCode());

	    	}
	    	
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line+"\n");
	        }
	        br.close();

	        responseBodyReturn = sb;

	    	
		} catch(IOException e) {
	    	LOGGER.error("Error occurred while postRequest: " + url);
	    	e.printStackTrace();
	    	responseBodyReturn = null;
		}
		
		
	
		return responseBodyReturn.toString();
	}

}
