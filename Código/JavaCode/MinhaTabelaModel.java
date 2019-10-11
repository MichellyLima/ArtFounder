package Interface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MinhaTabelaModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
    private List<ObradeArte> obrasDeArte;

    public MinhaTabelaModel(List<ObradeArte> obrasDeArte) {
        this.obrasDeArte = obrasDeArte;
    }
    
    public MinhaTabelaModel(){}
    
	@Override
	public String getColumnName(int column) {
	       switch (column) {
	       case 0:
	         return "ID";
	       case 1:
	         return "Nome";
	       case 2:
	    	   return "Categoria";
	       case 3:
	    	   return "Local";
	       case 4:
	    	   return "Autor";
	       case 5:
	    	   return "Nacion. Autor";
	       case 6:
	    	   return "Museu";
	       case 7:
	    	   return "Categoria Museu";
	       case 8:
	    	   return "Endereço";
	       case 9:
	    	   return "Bairro";
	       case 10:
	    	   return "Cidade";
	       case 11:
	    	   return "Estado";
	       }
	       return "";
	}
	
	@Override
    public int getColumnCount() {
        return 11;
    }
	
	@Override
	public int getRowCount() {
        return obrasDeArte.size();
    }
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ObradeArte obradeArte = obrasDeArte.get(rowIndex);
        switch (columnIndex) {
        case 0: 
          return obradeArte.getCodigo();
        case 1:
          return obradeArte.getNome();
        case 2:
          return obradeArte.getCategoria().nome;
        case 3:
            return obradeArte.getLocalizacao();
        case 4:
            return obradeArte.getAutor().getNome();
        case 5:
            return obradeArte.getAutor().getNacionalidade();
        case 6:
	    	   return obradeArte.getMuseu().getNome();
	       case 7:
	    	   return obradeArte.getMuseu().getCategoria().nome;
	       case 8:
	    	   return obradeArte.getMuseu().getLocalizacao().getEndereco();
	       case 9:
	    	   return obradeArte.getMuseu().getLocalizacao().getBairro();
	       case 10:
	    	   return obradeArte.getMuseu().getLocalizacao().getCidade();
	       case 11:
	    	   return obradeArte.getMuseu().getLocalizacao().getEstado();
        }
		return "";
	}
	
	/* Remove todos os registros. */
	public void limpar() {
		// Remove todos os elementos da lista.
		obrasDeArte.clear();
		
		fireTableDataChanged();
	}

	public void removeRow(int selectedRow) {
		obrasDeArte.remove(selectedRow);
		
	}
	
	

}