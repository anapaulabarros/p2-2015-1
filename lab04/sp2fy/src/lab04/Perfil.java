package lab04;

import java.util.ArrayList;

public class Perfil {
	private String nome;
	private ArrayList<Album> listaAlbunsFavoritos;
	private ArrayList<Album> listaAlbuns;
	
	public Perfil(String nomeUsuario) throws Exception {
		if (nomeUsuario == null || nomeUsuario.equals(""))
			throw new Exception("O nome do usuario nao pode ser nula ou vazia");
		this.nome = nomeUsuario;
		this.listaAlbunsFavoritos = new ArrayList<Album>();
		this.listaAlbuns = new ArrayList<Album>();
	}
	
	
	public boolean equals(Object outroPerfil) {
		
		if (outroPerfil instanceof Perfil)
			return ((Perfil) outroPerfil).getNomePerfil().equals(nome);
		
		else 
			return false;
	}
	
	public String getNomePerfil() {
		return this.nome;
	}
	
	public void adicionaAlbum(Album album) {
		listaAlbuns.add(album);
	}
	
	public void adicionaAosFavoritos(Album album) {
		Album pesquisarAlbum = pesquisaAlbum( album.getTitulo());
		if (pesquisarAlbum != null)
			listaAlbunsFavoritos.add(album);
	}
	
	private Album pesquisaAlbum(String nomeAlbum){
		for (Album album : listaAlbuns) {
			if(album.getTitulo().equals(nomeAlbum))
				return album;
		}
		return null;
	}
	
	public ArrayList<Album> getListaAlbuns(){
		return this.listaAlbuns;
	}
	
	public ArrayList<Album> getListaAlbunsFavoritos(){
		return this.listaAlbunsFavoritos;
	}
	
	public void adicionaMusicaAoAlbumSimples(String nomeAlbum, String nomeMusica, int duracaoMusica, String tipoMusica) throws Exception{
		Album album = pesquisaAlbum(nomeAlbum);
		if (album != null){
			album.adicionaMusicaNoAlbum(nomeAlbum,duracaoMusica, tipoMusica);
		}
	}
	
}
