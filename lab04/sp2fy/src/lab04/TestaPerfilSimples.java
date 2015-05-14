package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testaPerfilSimples {

	private Musica dancandoJava;
	private Album dancasJavolicas;
	private Album dancasDoLinux;
	private Perfil programador;
	
	@Test
	public void testPerfilSimples() {
		try{
			dancandoJava = new Musica("A danca do Java" , 3, "Pop");
			dancasJavolicas = new Album("Gosling", "Suite de dancas", 2015);
			dancasDoLinux = new Album("Torvalds", "Danca para relaxar", 2013);
			programador = new Perfil("Zezinho programador");
			
			programador.adicionaAlbum(dancasJavolicas);
			programador.adicionaAlbum(dancasDoLinux);
			programador.adicionaAosFavoritos(dancasDoLinux);
			
		}catch (Exception e) {
			Assert.fail();
		}
		Assert.assertEquals(dancasDoLinux, programador.getListaAlbunsFavoritos().get(0));
		Assert.assertEquals(dancasJavolicas, programador.getListaAlbuns().get(0));
	}

}
