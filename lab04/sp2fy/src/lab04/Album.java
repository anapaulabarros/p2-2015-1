package lab04;

import java.util.ArrayList;

import lab04.Musica;

public class Album {
	
	private ArrayList<Musica> listaMusicas;
	private String artista;
	private String titulo;
	private int anoLancamento;
	private int tempoDuracaoAlbum;
	
	public Album(String artista, String titulo, int anoLancamento) throws Exception {
		if (artista == null || artista.equals(""))
			throw new Exception("Nome do artista nao pode ser nulo ou vazio.");
		if (titulo == null || titulo.equals(""))
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		if (anoLancamento < 0)
			throw new Exception("Ano de lancamento do album nao pode ser negativo.");
		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.tempoDuracaoAlbum = 0;
	}
	
	
	public boolean equals(Object outroAlbum) {
			
			if (outroAlbum instanceof Album)
				return ((Album) outroAlbum).getArtista().equals(artista) && ((Album) outroAlbum).getTitulo() == titulo;
			
			else 
				return false;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getArtista() {
		return this.artista;
	}

}
