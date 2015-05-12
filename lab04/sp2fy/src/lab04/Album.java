package lab04;

import java.util.ArrayList;

import lab04.Musica;

public class Album implements Comparable<Album> {
	
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
		this.listaMusicas = new ArrayList<Musica>();
		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.tempoDuracaoAlbum = 0;
	}
	
	@Override
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
	
	public int getTempoTotalAlbum() {
		return this.tempoDuracaoAlbum;
	}
	
	public void adicionaMusicaNoAlbum(String nome, int duracao, String genero){
		try {
			Musica novaMusica = new Musica(nome, duracao, genero);
			listaMusicas.add(novaMusica);
			setTempoAlbum(duracao, "add"); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void setTempoAlbum(int duracao, String tipoOperacao) {
		if(tipoOperacao.equals("add"))
			this.tempoDuracaoAlbum += duracao;
		else
			this.tempoDuracaoAlbum -= duracao;
	}
	
	public ArrayList<Musica> getListaMusicas() { 
		return this.listaMusicas;
	}
	
	public void removeMusicaDoAlbum(String nomeMusica) throws Exception {
		if(nomeMusica == null || nomeMusica.equals(""))
			throw new Exception("Nome da musica nao pode ser nula ou vazia.");
		for(int i = 0; i < listaMusicas.size(); i++) {
			Musica musicaAtual = listaMusicas.get(i); 
			if (musicaAtual.getNome().equals(nomeMusica)){
				listaMusicas.remove(i);
				setTempoAlbum(musicaAtual.getDuracao(), "del"); 
			}
		}
	}
	
	@Override
	public int compareTo(final Album outroAlbum) {
		if (this.anoLancamento == outroAlbum.anoLancamento)
			return 0;
		else
			return this.anoLancamento > outroAlbum.anoLancamento ? 1 : -1;
	}
	
	public int compareNomeArtista (Album outroAlbum) {
		if(this.artista.equals(outroAlbum.artista))
			return 0;
		else
			return this.artista.length() > outroAlbum.artista.length() ? 1 : -1;
	}
	
	public int compareTempoDuracao(Album outroAlbum) {
		if (this.tempoDuracaoAlbum == outroAlbum.tempoDuracaoAlbum)
			return 0;
		else
			return this.tempoDuracaoAlbum > outroAlbum.tempoDuracaoAlbum ? 1 : -1;
	}
}
