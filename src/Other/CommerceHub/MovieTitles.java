package Other.CommerceHub;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class MovieTitles {

	public static void main(String[] args) throws Exception {
		System.out.println(Arrays.toString(getMovieTitles("1")));
	}

	/*
	 * Complete the function below.
	 */
    // TODO: Sanitize the input so that invalid chars are stripped off?
	// TODO: Reject null input or empty string?
	static String[] getMovieTitles(String substr) {
		if (substr == null) return new String[] {};
		Gson gson = new Gson();
		List<String> movieTitles = new ArrayList<>();
		int currentpage = 1;
		int totalpages = 2; // initialize totalpages to 2 to start things off and then update it from within the loop
		while (currentpage <= totalpages) {
			String queryString = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + currentpage;
			// Get Json Object using gson - Can also map to a POJO but not needed at this point
			JsonObject jsonObject = null;
			try {
				jsonObject = gson.fromJson(getJsonString(queryString), JsonObject.class);
			} catch (JsonSyntaxException | IOException e) {
				e.printStackTrace();
                // Log this
                return new String[] {};
			}
			JsonArray jsonArray = jsonObject.getAsJsonArray("data");
			for (JsonElement jsonElement : jsonArray) {
				movieTitles.add(jsonElement.getAsJsonObject().get("Title").getAsString());
			}
			totalpages = jsonObject.get("total_pages").getAsInt();
			currentpage++;
		}
		String[] movies = movieTitles.toArray(new String[] {});
		Arrays.sort(movies); // sort and return
		return movies;
	}

	// http://www.baeldung.com/java-http-request
	// If third-party libraries are usable then:
	// better alternative would be to use a library such as Jersey or Apache
	// HttpClient for handling things like timeouts, proxy, and authentication
	private static String getJsonString(String query) throws IOException {
		URL url = new URL(query);
		StringBuilder result = new StringBuilder();
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
	}


}
