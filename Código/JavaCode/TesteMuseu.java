package Interface;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TesteMuseu {

	@Test
	public final void testAdicionaMuseu() {
		Localizacao l = new Localizacao("Rua 41", "Setor Morada Nova", "Goiânia", "Goiás");
		Categoria c = new Categoria("Contemporâneo");
		Museu m = new Museu("Gran Ville Museum", l, c);
		
		ArrayList<Museu> museus = new ArrayList<Museu>();
		museus.add(m);
		assertEquals(museus, m.listaNomesMuseus());
		
	}

	@Test
	public final void testBuscaMuseu() {
		Localizacao l = new Localizacao("Rua 41", "Setor Morada Nova", "Goiânia", "Goiás");
		Categoria c = new Categoria("Contemporâneo");
		Museu m = new Museu("Gran Ville Museum", l, c);
		m.adicionaMuseu();
		assertEquals(m, m.buscaMuseu("Gran Ville")); 
		
	}

	@BeforeClass
	public static void inicializaClass() {
		System.out.println("iniciou série de teste");
	}

	@AfterClass
	public static void finalizaClass() {
		System.out.println("Finalizou série de teste");
	}

}