package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

public class getAPI {
	public static void main(String[] args) {
		try {
			String apiURL = "https://schoolmenukr.ml/api/high/B100000658";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			}
			else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			String responseStr = response.toString();
			String[] responseArr = responseStr.substring(150, responseStr.length()).split("},");
			List<String> menuList = new ArrayList<String>();
			List<String> startIdxList = new ArrayList<String>();
			List<String> endIdxList = new ArrayList<String>();
			for(int i = 0; i < responseArr.length; i++) {
				if(responseArr[i].contains("lunch") && !responseArr[i].contains("lunch\":[]")) {
					menuList.add(responseArr[i]);
				}
			}
			String[] menuArr = new String[ menuList.size() ];
			menuList.toArray(menuArr);
			for(int i = 0; i < menuArr.length; i++) {
				menuArr[i] = menuArr[i].replace(String.valueOf(i),"");
				menuArr[i] = menuArr[i].replace(".","");
				menuArr[i] = menuArr[i].replace(",\"breakfast\":[]","");
				menuArr[i] = menuArr[i].replace(",\"date\":\"\"","");
				menuArr[i] = menuArr[i].replace(",\"dinner\":[]","");
				startIdxList.add(String.valueOf(menuArr[i].indexOf("\"lunch\":[")));
//				endIdxList.add(String.valueOf(menuArr[i].indexOf("d")));
//				System.out.println(endIdxList + menuArr[i]);
//				System.out.println(menuArr[i]);
			}
			String[] strartIdxArr = new String[ startIdxList.size() ];
			startIdxList.toArray(strartIdxArr);
			for(int i = 0; i < strartIdxArr.length; i++) {
				menuArr[i] = menuArr[i].substring(Integer.parseInt(strartIdxArr[i]), menuArr[i].length());
			}
			for(int i = 0; i < menuArr.length; i++) {
				endIdxList.add(String.valueOf(menuArr[i].indexOf("d")));
			}
			String[] endIdxArr = new String[ endIdxList.size() ];
			endIdxList.toArray(endIdxArr);
			for(int i = 0; i < strartIdxArr.length; i++) {
				if(Integer.parseInt(endIdxArr[i]) != -1) {
					menuArr[i] = menuArr[i].substring(0, Integer.parseInt(endIdxArr[i])-2);
				}
			}
			for(int i = 0; i < menuArr.length; i++) {
				menuArr[i] = menuArr[i].replace("\"lunch\":[","");
				menuArr[i] = menuArr[i].replace("]","");
				System.out.println(menuArr[i]);
			}
//        	JSONParser jsonParser = new JSONParser();
//        	JSONObject jsonObject = (JSONObject)jsonParser.parse(response.toString());
//			JSONObject jsonObject = (JSONObject)jsonParser.parse(response.toString());
//			System.out.println(jsonObject);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
