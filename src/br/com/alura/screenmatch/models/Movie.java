package br.com.alura.screenmatch.models;
import br.com.alura.screenmatch.calculus.Rated;

public class Movie extends Title implements Rated{
	
	private String director;
	
	public Movie(String name, int releaseYear) {
		super(name, releaseYear);
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public int getReview() {
		return (int) averageRating() / 2;
	}
	
	@Override
	public String toString() {
		return this.getName() + " (%d)".formatted(this.getReleaseYear());
	}
}
