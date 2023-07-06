package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.exceptions.InvalidYearException;

public class Title implements Comparable<Title>{
	private String name;
	private int releaseYear;
	private boolean inThePlan;
	private double reviewsSum;
	private int reviewsNumber;
	private int durationInMinutes;
	
	public Title(String name, int releaseYear) {
		this.name = name;
		this.releaseYear = releaseYear;
	}
	
	public Title(OmdbTitle omdbTitle) {
		this.name = omdbTitle.title();
		
		if (omdbTitle.year().length() > 4) {
			throw new InvalidYearException("Error: Unable to access year of release for this title");
		}
		this.releaseYear = Integer.valueOf(omdbTitle.year());
		this.durationInMinutes = Integer.valueOf(omdbTitle.runtime().substring(0, 3).strip());
	}

	public void setInThePLan(boolean inThePlan) {
		this.inThePlan = inThePlan;
	}
	
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	public String getName() {
		return name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public boolean getInThePlan() {
		return inThePlan;
	}

	public int getReviewsNumber() {
		return reviewsNumber;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	
	public String displaysTechnicalSheet() {
		String technicalSheet = """
				
				Name:              %s
				Release Year:      %d
				Runtime:           %d min""".formatted(name, releaseYear, durationInMinutes);
		return technicalSheet;
	}
	
	public void evaluates(double note){
		reviewsSum += note;
		reviewsNumber++;
	}
	
	public double averageRating() {
		return reviewsSum / reviewsNumber;
	}
	
	@Override
	public String toString() {
		return "(Title: " + this.name + ", Release Year: " + this.releaseYear 
				+ ", Runtime: " + this.durationInMinutes + " min)";
	}

	@Override
	public int compareTo(Title anotherMovie) {
		return this.getName().compareTo(anotherMovie.getName());
	}
}
