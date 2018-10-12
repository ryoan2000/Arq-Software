package br.usjt.arqsw18.pipoca.model.service;

import java.util.Arrays;

public class FilmeTMDB {
	private String posterPath;
	private boolean adult;
	private String overview;
	private String release_date;
	private String title;
	private double popularity;
	private int[] genre_ids;
	
	
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	public int[] getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(int[] genre_ids) {
		this.genre_ids = genre_ids;
	}
	@Override
	public String toString() {
		return "FilmeTMDB [posterPath=" + posterPath + ", adult=" + adult + ", overview=" + overview + ", release_date="
				+ release_date + ", title=" + title + ", popularity=" + popularity + ", genre_ids="
				+ Arrays.toString(genre_ids) + "]";
	}
	
	
	
}
