package br.usjt.arqsw18.pipoca.model.service;

import java.util.ArrayList;

public class ResultadoTMDB {
	private ArrayList<FilmeTMDB> results;

	public ArrayList<FilmeTMDB> getResults() {
		return results;
	}

	public void setResults(ArrayList<FilmeTMDB> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ResultadoTMDB [results=" + results + "]";
	}
	
	
}
