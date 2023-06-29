import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Title;

public class MainLists {
	public static void main(String[] args) {
		Movie myMovie = new Movie("Harry Potter", 2001);
		myMovie.evaluates(8);
		
		Movie anotherMovie = new Movie("Cars", 2006);
		anotherMovie.evaluates(10);
		
		var newMovie = new Movie("Ice age", 2002);
		newMovie.evaluates(7);
		
		Serie mySerie = new Serie("Breaking Bad", 2008);
		mySerie.evaluates(9);
		
		
		List<Title> list = new ArrayList<>();
		list.add(myMovie);
		list.add(anotherMovie);
		list.add(newMovie);
		list.add(mySerie);
		

		for (Title title : list) {
			System.out.println("\n" + title.getName());
			if(title instanceof Movie movie) {
				System.out.println("Stars: " + movie.getReview());
			}else {
				System.out.println("Average rating: " + title.averageRating());
			}
		}
		
		list.forEach(title -> System.out.println("\n" + title.getName()));
		
		List<String> searchForArtist = new ArrayList<>();
		searchForArtist.add("Adam Sandler");
		searchForArtist.add("Tom Cruise");
		searchForArtist.add("Brad Pitt");
		searchForArtist.add("Will Smith");
		searchForArtist.add("Johnny Depo");
		System.out.println(searchForArtist);
		
		Collections.sort(searchForArtist);
		System.out.println(searchForArtist);
		
		Collections.sort(list);
		System.out.println("Movies sorted by name, using Comparable:");
		System.out.println(list);
		
		list.sort(Comparator.comparing(Title::getReleaseYear));
		System.out.println("Movies sorted by release year, using Comparator");
		System.out.println(list);
	}
}
