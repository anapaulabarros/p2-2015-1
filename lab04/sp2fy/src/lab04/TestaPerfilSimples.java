package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestaPerfilSimples {

	private Musica dancandoJava;
	private Album dancasJavolicas;
	private Perfil programador;
	
	@Test
	public void testPerfilSimples() {
		try{
			dancandoJava = new Musica("A danca do Java" , 3, "Pop");
			dancasJavolicas = new Album("Gosling", "Suite de dancas", 2015);
			programador = new Perfil("Zezinho programador");
			
			programador.adicionaAlbum(dancasJavolicas);
			
		}catch (Exception e) {
			Assert.fail();
		}
		//testa se album foi adicionado no perfil do usuario
		Assert.assertEquals(dancasJavolicas, programador.getListaAlbuns().get(0));
	}

}
