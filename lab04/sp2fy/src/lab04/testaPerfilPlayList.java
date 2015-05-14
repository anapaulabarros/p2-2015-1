package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testaPerfilPlayList {

	private Musica dancandoJava;
	private Album dancasJavolicas;
	private Perfil programador;
	@Test
	public void testPlayList() {
		try{
			dancandoJava = new Musica("A danca do Java" , 3, "Pop");
			dancasJavolicas = new Album("Gosling", "Suite de dancas", 2015);
			programador = new Perfil("Zezinho programador");
			
			programador.adicionaAlbum(dancasJavolicas);
			programador.adicionaPlaylist("playList1", "Suite de dancas", 0);
			
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
