package Interface;

import java.util.ArrayList;

public class Museu {
	private String nome;
	private Localizacao localizacao;
	private Categoria categoria;
	private static ArrayList<Museu> museus = new ArrayList<Museu>();
	
	
	public Museu(String nome, Localizacao loc, Categoria categoria){
		this.nome = nome;
		this.localizacao = loc;
		this.categoria = categoria;
	}
	
	public Museu(){};
	
	public void adicionaMuseu(){
		Museu.museus.add(this);
	}
	
	
	public ArrayList<String> listaNomesMuseus(){
		ArrayList<String> listaNomesdosMuseus = new ArrayList<String>();
		for(Museu museu : museus){
			listaNomesdosMuseus.add(museu.getNome());
		}
		return listaNomesdosMuseus;
	}
	
	public Museu buscaMuseu(String nomeMuseu){
		for(Museu mu : museus){
			if(mu.getNome().equals(nomeMuseu)){
				return mu;
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public static ArrayList<Museu> getMuseus() {
		return museus;
	}

	public String toString(){
		String s = this.nome + " - Categoria " + this.categoria.nome + "\nLoc. Museu: " + this.localizacao.toString();
		return s;
	}
	public String escreveArquivo(){
		String s = this.nome + "#" + this.categoria.nome + "#" + this.localizacao.escreveArquivo() + "\n";
		return s;
	}
}