package exercise_take.home.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class BaseClass {
	protected static final String BASE_URL = "https://dummyjson.com/";

	protected <T> T sendHttpGetRequest(String url, Type responseType) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();

				Gson gson = new Gson();
				return gson.fromJson(response.toString(), responseType);
			} else {
				System.out.println("Error: HTTP GET request failed with response code: " + responseCode);
			}
		} catch (IOException e) {
			System.out.println("Error: Failed to send HTTP GET request: " + e.getMessage());
		}

		return null;
	}

}
