import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.exceptions.InvalidYearException;
import br.com.alura.screenmatch.models.OmdbTitle;
import br.com.alura.screenmatch.models.Title;

public class MainSearchs {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner input = new Scanner(System.in);
		
		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()
				.create();
		
		List<Title> moviesList = new ArrayList<>();
		String movie = "";
		while (true){
			System.out.print("\n>>> Search for a movie: ");
			movie = input.nextLine().strip().toLowerCase();
			
			if (movie.equals("")) {
				System.out.println("\n>>> Search ended");
				input.close();
				break;
			}
			
			var adress = "https://www.omdbapi.com/?t=" + movie.replace(" ", "+") + "&apikey=475df792";
			
			try {
				HttpClient client = HttpClient.newHttpClient();
		
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(adress))
						.build();
		
				HttpResponse<String> response = client
				  	     .send(request, BodyHandlers.ofString());
		
				String json = response.body();
				// System.out.println(json);
				
				OmdbTitle myOmdbTitle = gson.fromJson(json, OmdbTitle.class);
				// System.out.println(myOmdbTitle);
				
				Title myTitle = new Title(myOmdbTitle);
				moviesList.add(myTitle);
				System.out.println(myTitle.displaysTechnicalSheet());
				
			} catch(NumberFormatException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Error: Title search error");
			} catch (InvalidYearException e) {
				System.out.println(e.getMessage());
			}
		}
		FileWriter writer = new FileWriter("movies.json");
		writer.write(gson.toJson(moviesList));
		writer.close();

		for (Title title : moviesList) {
			System.out.println(title.displaysTechnicalSheet());
		}
	}
}
