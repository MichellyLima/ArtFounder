package Interface;

public abstract class IDObrasDeArte {
	private static int id = 1;
	
	public int adicionaCodigo(){
		int codigo = this.getId();
		this.setId(this.getId()+1);
		return codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		IDObrasDeArte.id = id;
	}
}
