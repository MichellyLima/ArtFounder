package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;




public class TelaEncontrarObra extends JFrame{
	private JTextField buscaAutor;
	private JLabel lblNewLabel;
	

	// Construtor TelaInicio()
	public TelaEncontrarObra() {
		initialize();
	}
	
	private void gravaArquivos(){
		try {
			//ARQUIVO OBRAS DE ARTE
			File diretorio = new File("ArtFounder/BancoDeDados");
			
			if(!diretorio.exists()){
				diretorio.mkdirs();
			}
			
			File file = new File("ArtFounder/BancoDeDados/ObrasDeArte.txt");
			OutputStream os = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			for(ObradeArte obradeArte : ObradeArte.getObrasdeArte()){
				bw.write(obradeArte.escreveArquivo());
			}
			bw.close();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//initialize() contém os elementos da tela
	private void initialize() {
		getContentPane().setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		setResizable(false);
		getContentPane().setBackground(Color.GRAY);
		setTitle("Art Founder");
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		//PAINEL JPANEL
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 180, 477);
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel);
		
		//BOTÃO VOLTAR MENU
		JButton btnVoltarMenu = new JButton("Voltar Menu");
		btnVoltarMenu.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		btnVoltarMenu.setBounds(12, 68, 147, 28);
		panel.add(btnVoltarMenu);
		
		lblNewLabel = new JLabel("Para Excluir ou Alterar\r\n");
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		lblNewLabel.setBounds(-6, 196, 186, 39);
		panel.add(lblNewLabel);
		
		JLabel lblCliquexNo = new JLabel("Clique 2x no Nome");
		lblCliquexNo.setForeground(Color.WHITE);
		lblCliquexNo.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		lblCliquexNo.setBounds(12, 241, 168, 16);
		panel.add(lblCliquexNo);
		//AÇÕES
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio ti = new TelaInicio();
				ti.setVisible(true);
				dispose();
			}
		});
		
		
		//JLABELS (TEXTO E IMAGENS)
		JLabel lblEncontrarObra = new JLabel("ENCONTRAR OBRA DE ARTE");
		lblEncontrarObra.setBounds(192, 0, 359, 64);
		lblEncontrarObra.setForeground(Color.ORANGE);
		lblEncontrarObra.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		getContentPane().add(lblEncontrarObra);
		
		//TABELA
		JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		table.setCellSelectionEnabled(true);
        table.setBorder(new LineBorder(Color.black));
        table.setGridColor(Color.black);
        table.setShowGrid(true);
                
        JPanel panelResultado = new JPanel();
        panelResultado.setBackground(Color.DARK_GRAY);
        panelResultado.setBounds(190, 221, 594, 239);
        getContentPane().add(panelResultado);
        panelResultado.setLayout(null);
                
         JScrollPane scroll = new JScrollPane();
         scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
         scroll.setBounds(10, 11, 574, 217);
         panelResultado.add(scroll);
                
         scroll.setViewportView(table);
		
		
		JLabel fundo = new JLabel("");
		fundo.setBounds(445, -12, 512, 512);
		fundo.setIcon(new ImageIcon(TelaCadastrarObra.class.getResource("/imgs/abstrato.png")));
		getContentPane().add(fundo);

		JLabel lblInsiraONome = new JLabel("Buscar por nome do Autor:");
		lblInsiraONome.setBounds(192, 61, 199, 16);
		lblInsiraONome.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		getContentPane().add(lblInsiraONome);
		
		JLabel lblQualA = new JLabel("Buscar na Categoria:");
		lblQualA.setBounds(192, 115, 166, 16);
		lblQualA.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		getContentPane().add(lblQualA);
		
		//BOX INSERIR DADOS
		buscaAutor = new JTextField();
		buscaAutor.setBounds(192, 74, 185, 28);
		getContentPane().add(buscaAutor);
		buscaAutor.setColumns(10);
			
		JComboBox<String> buscaCategoria = new JComboBox<String>();
		buscaCategoria.setBounds(192, 129, 166, 28);
		buscaCategoria.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		buscaCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Pintura", "Retrato", "Escultura", "Fotografia", "Reliquia", "Musica", "Pintura e Retrato", "Pintura e Escultura", "Fotografia e Retrato"}));
		getContentPane().add(buscaCategoria);
		
		
		//BOTÃO BUSCAR
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(414, 103, 90, 28);
		btnBuscar.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		getContentPane().add(btnBuscar);
		//AÇÕES
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String categoria = buscaCategoria.getSelectedItem().toString();
				String autor = buscaAutor.getText();
				ObradeArte obraTemp = new ObradeArte();
				MinhaTabelaModel model = new MinhaTabelaModel();
				ArrayList<ObradeArte> obrasBuscadas = new ArrayList<ObradeArte>();
				if(autor.isEmpty()){
					obrasBuscadas = obraTemp.buscaObra(categoria);
					if(obrasBuscadas.size() == 0){
						JOptionPane.showMessageDialog(null, "Obra de Arte Não Encontrada");
					}else{
						List<ObradeArte> listadeObras = obrasBuscadas;
				        table.setModel(new MinhaTabelaModel(listadeObras));
				        table.getColumnModel().getColumn(0).setPreferredWidth(27);
				        table.getColumnModel().getColumn(1).setPreferredWidth(100);
				        table.getColumnModel().getColumn(2).setPreferredWidth(100);
				        table.getColumnModel().getColumn(3).setPreferredWidth(100);
				        table.getColumnModel().getColumn(4).setPreferredWidth(200);
				        table.getColumnModel().getColumn(5).setPreferredWidth(100);
				        table.getColumnModel().getColumn(6).setPreferredWidth(100);
				        table.getColumnModel().getColumn(7).setPreferredWidth(100);
				        table.getColumnModel().getColumn(8).setPreferredWidth(100);
				        table.getColumnModel().getColumn(9).setPreferredWidth(100);
				        table.getColumnModel().getColumn(10).setPreferredWidth(200);

						
					}
					
				}else{
					obrasBuscadas = obraTemp.buscaObra(categoria, autor);
					if(obrasBuscadas.size() == 0){
						JOptionPane.showMessageDialog(null, "Obra de Arte Não Encontrada");
					}else{
						List<ObradeArte> listadeObras = obrasBuscadas;
						table.setModel(new MinhaTabelaModel(listadeObras));
				        table.getColumnModel().getColumn(0).setPreferredWidth(27);
				        table.getColumnModel().getColumn(1).setPreferredWidth(100);
				        table.getColumnModel().getColumn(2).setPreferredWidth(100);
				        table.getColumnModel().getColumn(3).setPreferredWidth(100);
				        table.getColumnModel().getColumn(4).setPreferredWidth(200);
				        table.getColumnModel().getColumn(5).setPreferredWidth(100);
				        table.getColumnModel().getColumn(6).setPreferredWidth(100);
				        table.getColumnModel().getColumn(7).setPreferredWidth(100);
				        table.getColumnModel().getColumn(8).setPreferredWidth(100);
				        table.getColumnModel().getColumn(9).setPreferredWidth(100);
				        table.getColumnModel().getColumn(10).setPreferredWidth(200);
				        table.getColumnModel().getColumn(11).setPreferredWidth(100);
				        
					}
					
				}
				
				table.setDefaultEditor(Object.class, null);
				table.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						if(e.getClickCount() == 2){
							int row = table.rowAtPoint(e.getPoint());
							
							if(table.getSelectedRow() != -1){
								String[] options = {"Alterar Dados", "Excluir Obra de Arte"};
								int x = JOptionPane.showOptionDialog(null, "Escolha uma Opção", "Alterar / Excluir",
																			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
								
								if(x == 0){
									ObradeArte obraProcura = new ObradeArte();
									for(ObradeArte oa : ObradeArte.getObrasdeArte()){
										int linha = table.getSelectedRow(); int coluna = table.getSelectedColumn();
										String nomeObra = (String) table.getValueAt(linha, coluna);
										if(oa.getNome().equals(nomeObra)){
											obraProcura = oa;
											break;
										}
									}
									TelaAlterar ta = new TelaAlterar(obraProcura);
									ta.setVisible(true);
									dispose();
									setVisible(false);
									obraProcura.excluiObra();
								}
								if(x == 1){
									ObradeArte obraProcura = new ObradeArte();
									for(ObradeArte oa : ObradeArte.getObrasdeArte()){
										int linha = table.getSelectedRow(); int coluna = table.getSelectedColumn();
										String nomeObra = (String) table.getValueAt(linha, coluna);
										if(oa.getNome().equals(nomeObra)){
											obraProcura = oa;
											break;
										}
									}
									obraProcura.excluiObra();
									gravaArquivos();
									JOptionPane.showMessageDialog(null, "Excluído com Sucesso");
								}
							}
						}
					}
				});
				
			}
		});
	}
}