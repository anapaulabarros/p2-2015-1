package lab04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testAlbum {

	@Test
	public void test() {
		try {
			Album OperaOfMozart = new Album("Mozart", "Le nozze di Figaro", 1786);
			Album SymphonyOfBeethoven = new Album("Beethoven", "5º Symphony", 1808);
			
			Assert.assertEquals("Mozart", OperaOfMozart.getArtista());
			Assert.assertEquals("Beethoven", SymphonyOfBeethoven.getArtista());
			
			
			OperaOfMozart.adicionaMusicaNoAlbum("Se Vuole Ballare", 4, "Classical");
			OperaOfMozart.adicionaMusicaNoAlbum("Via Resti Servita", 5, "Classical");
			
			//Teste para remover musica vazia do Album OperaOfMozart
			try {
				OperaOfMozart.removeMusicaDoAlbum("");
				Assert.fail();
			} catch (Exception e) {
				Assert.assertEquals("Nome da musica nao pode ser nula ou vazia.", e.getMessage());
			}
			
			
		}catch (Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testAlbumInvalido(){
		try {
			Album artistaInvalido = new Album("","Nocturnes",1790);
			Assert.fail(); 
		} catch (Exception e) {
			Assert.assertEquals("Nome do artista nao pode ser nulo ou vazio.", e.getMessage());
		}
		try {
			Album tituloInvalido = new Album("Chopin","",1790);
			Assert.fail(); 
		} catch (Exception e) {
			Assert.assertEquals("Titulo do album nao pode ser nulo ou vazio.", e.getMessage());
		}
		try {
			Album anoInvalido = new Album("Chopin","Nocturne",-1);
			Assert.fail(); 
		} catch (Exception e) {
			Assert.assertEquals("Ano de lancamento do album nao pode ser negativo.", e.getMessage());
		}
		
	}

}
