package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.usjt.arqsw18.pipoca.model.dao.FilmeDAO;
import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;


@Service
public class FilmeService {
	private FilmeDAO dao;
	private GeneroService gs;
	public static final String API_KEY = "8ffbdd3af804afe23d498d46b7769878";
	public static final String URL = "https://api.themoviedb.org/3/movie/popular?api_key="+ API_KEY +"&language=en-US&page=1";
	public static final String IMG = "https://image.tmdb.org/t/p/w500";
	@Autowired
	public FilmeService(FilmeDAO fdao, GeneroService gs) {
		dao = fdao;
		this.gs = gs;
	}
	
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	@Transactional
	public Filme inserirFilme(Filme filme) throws IOException {
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		return filme;
	}
	
	@Transactional
	public void excluirFilme(Filme filme) throws IOException {
		dao.removerFilme(filme);
	}
	
	@Transactional
	public void atualizarFilme(Filme filme) throws IOException {
		dao.atualizarFilme(filme);
	}

	public List<Filme> listarFilmes(String chave) throws IOException{
		return dao.listarFilmes(chave);
	}

	public List<Filme> listarFilmes() throws IOException{
		return dao.listarFilmes();
	}
	
	@Transactional
	public void carregarFilmes() throws IOException {
		RestTemplate rt = new RestTemplate();
		ResultadoTMDB resultado = rt.getForObject(URL, ResultadoTMDB.class);
		System.out.println(resultado);
		ArrayList<FilmeTMDB> lista = resultado.getResults();
		for(FilmeTMDB filmeTMDB:lista) {
			Filme filme = new Filme();
			filme.setTitulo(filmeTMDB.getTitle());
			filme.setDescricao(filmeTMDB.getOverview());
			//filme.setPopularidade(filmeTMDB.getPopularity());
			filme.setPopularidade(10.0);
			filme.setPosterPath(IMG+filmeTMDB.getPosterPath());
			//Genero genero = gs.buscarGenero(filmeTMDB.getGenre_ids()[0]);
			Genero genero = gs.buscarGenero(28);
			filme.setGenero(genero);

			dao.inserirFilme(filme);
		}
		
	}
}
