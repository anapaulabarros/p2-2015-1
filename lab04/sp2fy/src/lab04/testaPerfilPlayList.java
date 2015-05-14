package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

public class TestaPerfilPlayList {

		
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
			
			assertEquals(1, programador.getListaPlayList().keySet().size());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(expected = Exception.class)
	public void testPlayListInvalida() throws Exception{
			 dancandoJava = new Musica(null , 3, "Pop");
			 dancasJavolicas = new Album("Gosling", "Suite de dancas", 2015);
			 programador = new Perfil("Zezinho programador");
			 
			 programador.adicionaAlbum(dancasJavolicas);
			 programador.adicionaPlaylist("playList1", "Suite de dancas", 0);
	}
	

}
