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
			
		}catch (Exception e){
			Assert.fail();//nao deveria ter lancado nenhuma Exception nesse teste.
		}
	}

}
