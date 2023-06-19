package br.com.alura.screenmatch.models;
import br.com.alura.screenmatch.calculus.Rated;

public class Episode implements Rated{
	private int number;
	private String name;
	private Serie serie;
	private int views;
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public void setViews(int views) {
		this.views = views;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public int getViews() {
		return views;
	}

	@Override
	public int getReview() {
		if (views >= 100) {
			return 4;
		}
		return 3;
	}
}
