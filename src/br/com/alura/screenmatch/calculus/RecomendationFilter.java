package br.com.alura.screenmatch.calculus;

public class RecomendationFilter {

	public void filter(Rated rated) {
		if (rated.getReview() >= 4) {
			System.out.println("Top Tiles of the moment");
		}else if (rated.getReview() >= 3){
			System.out.println("Good Titles to Watch");
		}else {
			System.out.println("Alternative Titles");
		}
	}
}
