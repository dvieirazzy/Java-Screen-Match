package br.com.alura.screenmatch.calculus;
import br.com.alura.screenmatch.models.Title;

public class TimeCalculator {
	private int totalTime;

	public int getTotalTime() {
		return totalTime;
	}
	
//	public void add(Movie f) {
//		totalTime += f.getDurationInMinutes();
//	}
//	
//	public void add(Serie s) {
//		totalTime += s.getDurationInMinutes();
//	}
	
	public void add(Title title) {
		totalTime += title.getDurationInMinutes();
	}
}
