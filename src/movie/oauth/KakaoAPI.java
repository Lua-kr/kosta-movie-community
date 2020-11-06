package movie.oauth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class KakaoAPI {
	private final String api_key = "f7eccd34f9b5aa5b18e0a8d1257e4cce";
	private final String secret_key = "Koq2mEIswVmeaaCoDj2wf8oiltI2Er46";
	private final String redirect_uri = "http://localhost:8000/MovieWorld/login";
	
    public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=" + api_key);
            sb.append("&client_secret=" + secret_key);
            sb.append("&redirect_uri=" + redirect_uri);
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();
            
            int responseCode = conn.getResponseCode();
//            System.out.println("getAccessToken responseCode : " + responseCode);
 
            if (responseCode == 200) {
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line = "";
	            String result = "";
	            
	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
//	            System.out.println("response body : " + result);
	            
	            JsonParser parser = new JsonParser();
	            JsonElement element = parser.parse(result);

	            access_Token = element.getAsJsonObject().get("access_token").getAsString();
	            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
	            
//	            System.out.println("access_token : " + access_Token);
//	            System.out.println("refresh_token : " + refresh_Token);
	            
	            br.close();
	            bw.close();
            }
        } catch (IOException e) {
            // e.printStackTrace();
        	System.out.println("getAccessToken Error: " + e.getMessage());
        } 
        
        return access_Token;
    }
    
    public HashMap<String, Object> getUserInfo (String access_Token) {
        
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me?target_id_type=user_id&secure_resource=false&property_keys=%5B%22id%22%2C+%22properties.nickname%22%2C+%22properties.profile_image%22%2C+%22kakao_account.email%22%2C+%22kakao_account.age_range%22%5D";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);
            
            int responseCode = conn.getResponseCode();
//            System.out.println("getUserInfo responseCode : " + responseCode);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String line = "";
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
//            System.out.println("response body : " + result);
            
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            if (!element.getAsJsonObject().has("id")) return userInfo;

            userInfo.put("uid", element.getAsJsonObject().get("id").getAsString());
            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            if (properties.getAsJsonObject().has("nickname"))
            	userInfo.put("nickname", properties.getAsJsonObject().get("nickname").getAsString());
            else
            	userInfo.put("nickname", null);

            if (properties.getAsJsonObject().has("profile_image"))
            	userInfo.put("profile_img", properties.getAsJsonObject().get("profile_image").getAsString());
            else
            	userInfo.put("profile_img", null);

            if (kakao_account.getAsJsonObject().has("email_needs_agreement") && kakao_account.getAsJsonObject().has("has_email")) {
            	boolean emailNeedAgree = kakao_account.getAsJsonObject().get("email_needs_agreement").getAsBoolean();
            	boolean emailExist = kakao_account.getAsJsonObject().get("has_email").getAsBoolean();
            	if (!emailNeedAgree && emailExist) {
            		userInfo.put("email", kakao_account.getAsJsonObject().get("email").getAsString());
            	}
            	else {
            		userInfo.put("email", null);
            	}
            	userInfo.put("email_needs_agreement", emailNeedAgree);
            	userInfo.put("has_email", emailExist);
            }
            else {
            	userInfo.put("email", null);
            	userInfo.put("has_email", false);
            	userInfo.put("email_needs_agreement", true);
            }
            
        	boolean ageRangeNeedAgree = kakao_account.getAsJsonObject().get("age_range_needs_agreement").getAsBoolean();
            if (!ageRangeNeedAgree && kakao_account.has("age_range"))
            	userInfo.put("age_range", kakao_account.getAsJsonObject().get("age_range").getAsString());
            else
            	userInfo.put("age_range", null);
            userInfo.put("age_range_needs_agreement", ageRangeNeedAgree);
            
        } catch (IOException e) {
            // e.printStackTrace();
        	System.out.println("getUserInfo Error: " + e.getMessage());
        }
        
        return userInfo;
    }
    
    public void kakaoLogout(String access_Token) {
        String reqURL = "https://kapi.kakao.com/v1/user/logout";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);
            
/*            int responseCode = conn.getResponseCode();
//            System.out.println("responseCode : " + responseCode);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String result = "";
            String line = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println(result);	*/
        } catch (IOException e) {
            // e.printStackTrace();
        	System.out.println("kakaoLogout Error: " + e.getMessage());
        }
    }

	public String kakaoAuthorizeAccessURL(String access_Token, String scopes) {
		return "https://kauth.kakao.com/oauth/authorize?client_id=" + api_key + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=" + scopes;
	}
}
