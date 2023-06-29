import java.util.ArrayList;

import br.com.alura.screenmatch.calculus.RecomendationFilter;
import br.com.alura.screenmatch.calculus.TimeCalculator;
import br.com.alura.screenmatch.models.Episode;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;

public class Main {
	public static void main(String[] args) {
		Movie myMovie = new Movie("Harry Potter", 2001);
		myMovie.setDurationInMinutes(180);
		myMovie.displaysTechnicalSheet();
		
		myMovie.evaluates(8);
		myMovie.evaluates(9);
		System.out.println("Reviews Number: " + myMovie.getReviewsNumber());
		System.out.println("Average Rating: " + myMovie.averageRating());
		
		Serie mySerie = new Serie("Breaking Bad", 2008);
		mySerie.displaysTechnicalSheet();
		
		mySerie.setSeasons(5);
		mySerie.setEpisodesBySeason(12);
		mySerie.setMinutesByEpisode(50);
		System.out.println("Duration in Minutes: " + mySerie.getDurationInMinutes());
		
		Movie anotherMovie = new Movie("Cars", 2006);
		anotherMovie.setDurationInMinutes(150);
		
		TimeCalculator calculator = new TimeCalculator();
		calculator.add(myMovie);
		calculator.add(anotherMovie);	
		calculator.add(mySerie);
		System.out.println(calculator.getTotalTime());
		
		RecomendationFilter recomendation = new RecomendationFilter();
		recomendation.filter(myMovie);
	
		Episode episode = new Episode();
		episode.setNumber(1);
		episode.setSerie(mySerie);
		episode.setViews(99);
		recomendation.filter(episode);
		
		var newMovie = new Movie("Ice age", 2002);
		// newMovie.setName("Ice Age");
		// newMovie.setReleaseYear(2002);
		newMovie.setDurationInMinutes(81);
		newMovie.evaluates(9);;
		
		ArrayList<Movie> moviesList = new ArrayList<>();
		moviesList.add(myMovie);
		moviesList.add(anotherMovie);
		moviesList.add(newMovie);
		
		System.out.println("\nMovie list size: " + moviesList.size());
		System.out.println("First Movie: " + moviesList.get(0).getName());
		System.out.println(moviesList.toString());

		
	}
}
