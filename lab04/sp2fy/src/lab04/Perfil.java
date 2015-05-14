package lab04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class Perfil {
	private String nome;
	private ArrayList<Album> listaAlbunsFavoritos;
	private ArrayList<Album> listaAlbuns;
	private Map<String, ArrayList<Musica>> playListas;
	
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
		Collections.sort(listaAlbuns);
		return listaAlbuns;
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
	
	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		
		if(nomePlaylist == null || nomePlaylist.equals(""))
			throw new Exception("Nome da PlayList nao pode ser nula ou vazia.");
		if (nomeAlbum == null || nomeAlbum.equals(""))
			throw new Exception("Nome do Album nao pode ser nula ou vazia.");
		if (faixa <= 0 || faixa > listaAlbuns.size())
			throw new Exception("A faixa especificada nao possui intevalo valido.");
		
		ArrayList<Musica> musicasDaPlayList;
		Album albumAtual;
		if (!playListas.keySet().contains(nomePlaylist)){
			playListas.put(nomeAlbum, new ArrayList<Musica>());
		}
		else {
			musicasDaPlayList = playListas.get(nomePlaylist);
			if((albumAtual = pesquisaAlbum(nomeAlbum)) == null) {
				throw new Exception("Álbum não pertence ao Perfil especificado");
			}
			else
			{
				musicasDaPlayList.add(albumAtual.getListaMusicas().get(faixa - 1));
			}	
		}
			
		
	}
}
