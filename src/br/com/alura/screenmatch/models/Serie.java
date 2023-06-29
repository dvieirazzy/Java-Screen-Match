package br.com.alura.screenmatch.models;

public class Serie extends Title{

	private int seasons;
	private int episodesBySeason;
	private boolean active;
	private int minutesByEpisode;
	
	public Serie(String name, int releaseYear) {
		super(name, releaseYear);
	}
	
	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}
	
	public void setEpisodesBySeason(int episodesBySeason) {
		this.episodesBySeason = episodesBySeason;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setMinutesByEpisode(int minutesByEpisode) {
		this.minutesByEpisode = minutesByEpisode;
	}
	
	public int getSeasons() {
		return seasons;
	}
	
	public int getEpisodesBySeason() {
		return episodesBySeason;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public int getMinutesByEpisode() {
		return minutesByEpisode;
	}
	
	@Override
	public int getDurationInMinutes() {
		return seasons * episodesBySeason * minutesByEpisode;
	}
	
	@Override
	public String toString() {
		return this.getName() + " (%d)".formatted(this.getReleaseYear());
	}
}
