package lab04;

import org.junit.Assert;
import org.junit.Test;

public class TestMusica {

	@Test
	public void test() {
		try{
			Musica chandelier = new Musica("Chandelier",3,"Pop");
			Musica elasticHeart = new Musica("Elastic Heart",3,"Pop");
			Musica cellophane = new Musica("Cellophane",4,"Pop");
			
			Assert.assertEquals("Chandelier", chandelier.getNome());
			Assert.assertEquals(3, chandelier.getDuracao());
			Assert.assertEquals("Pop", chandelier.getTipo());

			Assert.assertEquals("Elastic Heart", elasticHeart.getNome());
			Assert.assertEquals(3, elasticHeart.getDuracao());
			Assert.assertEquals("Pop", elasticHeart.getTipo());
			
			Assert.assertEquals("Cellophane", cellophane.getNome());
			Assert.assertEquals(4, cellophane.getDuracao());
			Assert.assertEquals("Pop", cellophane.getTipo());
			
			Musica chandelierRemix = new Musica("Chandelier",3,"Pop");
			Assert.assertEquals(chandelier, chandelierRemix);
			Assert.assertFalse(chandelier.equals(cellophane));

		}catch(Exception e){
			Assert.fail();
		}
	}
	
	
	@Test
	public void testMusicaInvalida(){
		try {
			Musica tituloInvalido = new Musica("",3,"Pop");
			Assert.fail(); 
		} catch (Exception e) {
			Assert.assertEquals("Titulo da musica nao pode ser vazio.", e.getMessage());
		}

		try {
			Musica duracaoInvalida = new Musica("Elastic Heart",-5,"Pop");
			Assert.fail(); 
		} catch (Exception e) {
			Assert.assertEquals("Duracao da musica nao pode ser negativa.", e.getMessage());
		}
		
		
		try {
			Musica tipoInvalido = new Musica("Cellophane",4,"");
			Assert.fail(); 
		} catch (Exception e) {
			Assert.assertEquals("Genero da musica nao pode ser vazio.", e.getMessage());
		}
		
	}

}
