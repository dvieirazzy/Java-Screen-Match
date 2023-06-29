package br.com.alura.screenmatch.models;

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
	

	public void displaysTechnicalSheet() {
		String technicalSheet = """
				Name:              %s
				Release Year:      %d
				""".formatted(name, releaseYear);
		System.out.println(technicalSheet);
	}
	
	public void evaluates(double note){
		reviewsSum += note;
		reviewsNumber++;
	}
	
	public double averageRating() {
		return reviewsSum / reviewsNumber;
	}

	@Override
	public int compareTo(Title anotherMovie) {
		return this.getName().compareTo(anotherMovie.getName());
	}
}
