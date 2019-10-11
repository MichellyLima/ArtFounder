package Interface;

import java.util.ArrayList;

public class ObradeArte extends IDObrasDeArte{
	private String nome;
	private String localizacao;
	private Categoria categoria;
	private Autor autor;
	private Museu museu;
	private int codigo;
	private static ArrayList<ObradeArte> obrasdeArte = new ArrayList<ObradeArte>();

	
	public ObradeArte(){}
	
	public ObradeArte(String nome, String loc, Categoria categoria, Autor autor){
		this.nome = nome;
		this.localizacao = loc;
		this.categoria = categoria;
		this.autor = autor;
		this.codigo = super.adicionaCodigo();
	}
	
	public ArrayList<ObradeArte> buscaObra(String categoria){
		
		ArrayList<ObradeArte> obrasEncontradas = new ArrayList<ObradeArte>();
		for(ObradeArte oa : ObradeArte.obrasdeArte){
			if(oa.getCategoria().nome.equals(categoria)){
				obrasEncontradas.add(oa);
			}
		}
		return obrasEncontradas;
	}
	
	public ArrayList<ObradeArte> buscaObra(String categoria, String autor){
		
		ArrayList<ObradeArte> obrasEncontradas = new ArrayList<ObradeArte>();
		for(ObradeArte oa : ObradeArte.obrasdeArte){
			if(oa.getCategoria().nome.equals(categoria)){
				if(oa.getAutor().getNome().equals(autor)){
					obrasEncontradas.add(oa);
				}
			}
		}
		return obrasEncontradas;
	}
	
	public void adicionaObra(){
			ObradeArte.obrasdeArte.add(this);
	}
	
	public void excluiObra(){
		ObradeArte.obrasdeArte.remove(this);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Museu getMuseu() {
		return museu;
	}

	public void setMuseu(Museu museu) {
		this.museu = museu;
	}
	
	public static ArrayList<ObradeArte> getObrasdeArte() {
		return obrasdeArte;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String toString(){
		String s = "ID " + this.codigo + " - " + this.nome + " - Categoria " + this.categoria.nome + " - Localizado em "
					+ this.localizacao + "\nAutor " + this.autor.toString() + "\nMuseu: " + this.museu.toString() + "\n";
		return s;
	}
	
	public String escreveArquivo(){
		String s = this.codigo + "#" + this.nome + "#" + this.categoria.nome + "#"
					+ this.localizacao + "#" + this.autor.escreveArquivo() + "#" + this.museu.escreveArquivo();
		return s;
	}
}