package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Principal {
	public static void main(String args[]){
		repositorio();
		TelaInicio ti = new TelaInicio();
		ti.setVisible(true);
	}
	
	private static void repositorio(){
		try {
			//CARREGA OBRAS DE ARTE
			File diretorioObras = new File("ArtFounder/BancoDeDados");
			
			if(!diretorioObras.exists()){
				diretorioObras.mkdirs();
			}
			
			File fileObras = new File("ArtFounder/BancoDeDados/ObrasDeArte.txt");
			
			InputStream is = new FileInputStream(fileObras);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			
			while(s != null){
				String[] campos = s.split("#");
				
				Categoria catObradeArte = new Categoria(campos[2]);
				Autor autorObradeArte = new Autor(campos[4], campos[5]);
				Museu museuTemp = new Museu(campos[6], new Localizacao(campos[8], campos[9], campos[10], campos[8]), catObradeArte);
				ObradeArte oa = new ObradeArte(campos[1], campos[3], catObradeArte, autorObradeArte);
				oa.setMuseu(museuTemp);
				oa.adicionaObra();
				s = br.readLine();
				
			}
			br.close();
			
			//CARREGA MUSEUS
			File diretorioMuseus = new File("ArtFounder/BancoDeDados");
			
			if(!diretorioMuseus.exists()){
				diretorioMuseus.mkdirs();
			}
			
			File fileMuseus = new File("ArtFounder/BancoDeDados/Museus.txt");
			is = new FileInputStream(fileMuseus);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			s = br.readLine();
			
			while(s != null){
				String[] campos = s.split("#");
				
				Localizacao locMuseu = new Localizacao(campos[2], campos[3], campos[4], campos[5]);
				Categoria catMuseu = new Categoria(campos[1]);
				Museu museu = new Museu(campos[0], locMuseu, catMuseu);
				museu.adicionaMuseu();
				s = br.readLine();
			}
			br.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
