import br.com.alura.screenmatch.calculus.RecomendationFilter;
import br.com.alura.screenmatch.calculus.TimeCalculator;
import br.com.alura.screenmatch.models.Episode;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;

public class Main {
	public static void main(String[] args) {
		Movie myMovie = new Movie();
		myMovie.setName("Harry Potter");
		myMovie.setDurationInMinutes(180);
		myMovie.setReleaseYear(2001);
		myMovie.displaysTechnicalSheet();
		
		myMovie.evaluates(8);
		myMovie.evaluates(9);
		System.out.println("Reviews Number: " + myMovie.getReviewsNumber());
		System.out.println("Average Rating: " + myMovie.averageRating());
		
		Serie mySerie = new Serie();
		mySerie.setName("Breaking Bad");
		mySerie.setReleaseYear(2008);
		mySerie.displaysTechnicalSheet();
		
		mySerie.setSeasons(5);
		mySerie.setEpisodesBySeason(12);
		mySerie.setMinutesByEpisode(50);
		System.out.println("Duration in Minutes: " + mySerie.getDurationInMinutes());
		
		Movie anotherMovie = new Movie();
		anotherMovie.setName("Cars");
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
	}
}
