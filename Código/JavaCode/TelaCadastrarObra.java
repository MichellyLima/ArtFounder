package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.io.*;

public class TelaCadastrarObra extends JFrame{

	private JTextField nomeObra;
	private JTextField localizacaoObra;
	private JTextField nomeAutor;
	private JTextField nacionalidadeAutor;

	// Construtor TelaCadastrarObra()
	public TelaCadastrarObra(){
		initialize();

	}
	
	//Método para gravar em arquivos
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
	private void initialize(){
		getContentPane().setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		setResizable(false);
		getContentPane().setBackground(Color.GRAY);
		setTitle("Art Founder");
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//PAINEL JPANEL
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 180, 477);
		getContentPane().add(panel);
		
		//BOTÃO VOLTAR MENU
		JButton btnVoltarMenu = new JButton("Voltar Menu");
		btnVoltarMenu.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		btnVoltarMenu.setBounds(12, 68, 147, 28);
		panel.add(btnVoltarMenu);
		//AÇÕES
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicio ti = new TelaInicio();
				ti.setVisible(true);
				dispose();
			}
		});
		
		
		//JLABELS (TEXTO E IMAGENS)
		JLabel lblCadastrarObraDe = new JLabel("CADASTRAR OBRA DE ARTE");
		lblCadastrarObraDe.setForeground(Color.ORANGE);
		lblCadastrarObraDe.setFont(new Font("Lucida Sans", Font.BOLD, 24));
		lblCadastrarObraDe.setBounds(192, 0, 359, 64);
		getContentPane().add(lblCadastrarObraDe);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(TelaCadastrarObra.class.getResource("/imgs/abstrato.png")));
		fundo.setBounds(445, -12, 512, 512);
		getContentPane().add(fundo);
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra de Arte");
		lblNomeDaObra.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNomeDaObra.setBounds(288, 76, 166, 16);
		getContentPane().add(lblNomeDaObra);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setForeground(Color.ORANGE);
		lblAutor.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 17));
		lblAutor.setBounds(323, 306, 55, 16);
		getContentPane().add(lblAutor);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblCategoria.setBounds(288, 131, 74, 16);
		getContentPane().add(lblCategoria);
		
		JLabel lblLocalizacaoObra = new JLabel("Localiza\u00E7\u00E3o no Museu");
		lblLocalizacaoObra.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblLocalizacaoObra.setBounds(288, 239, 166, 16);
		getContentPane().add(lblLocalizacaoObra);
		
		JLabel lblMuseu = new JLabel("Museu");
		lblMuseu.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblMuseu.setBounds(288, 185, 55, 16);
		getContentPane().add(lblMuseu);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNome.setBounds(288, 329, 55, 16);
		getContentPane().add(lblNome);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNacionalidade.setBounds(288, 369, 107, 16);
		getContentPane().add(lblNacionalidade);
		

		//BOX INSERIR DADOS
		nomeObra = new JTextField();
		nomeObra.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		nomeObra.setBounds(288, 91, 166, 28);
		getContentPane().add(nomeObra);
		nomeObra.setColumns(10);
	
		
		localizacaoObra = new JTextField();
		localizacaoObra.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		localizacaoObra.setBounds(288, 254, 166, 28);
		getContentPane().add(localizacaoObra);
		localizacaoObra.setColumns(10);
		
		nomeAutor = new JTextField();
		nomeAutor.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		nomeAutor.setBounds(288, 343, 166, 28);
		getContentPane().add(nomeAutor);
		nomeAutor.setColumns(10);
		
		nacionalidadeAutor = new JTextField();
		nacionalidadeAutor.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		nacionalidadeAutor.setBounds(288, 383, 166, 28);
		getContentPane().add(nacionalidadeAutor);
		nacionalidadeAutor.setColumns(10);
		
		JComboBox<String> categoriaObra = new JComboBox<String>();
		categoriaObra.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		categoriaObra.setModel(new DefaultComboBoxModel<String>(new String[] {"Pintura", "Retrato", "Escultura", "Fotografia", "Reliquia", "Musica", "Pintura e Retrato", "Pintura e Escultura", "Fotografia e Retrato"}));
		categoriaObra.setBounds(288, 145, 166, 28);
		getContentPane().add(categoriaObra);
		
		JComboBox<String> museuobra = new JComboBox<String>();
		museuobra.setBounds(288, 200, 166, 28);
		getContentPane().add(museuobra);

		Museu museu = new Museu();
		ArrayList<String> listaNomesMuseus = new ArrayList<String>();
		listaNomesMuseus = museu.listaNomesMuseus();
		listaNomesMuseus.add("Nao Cadastrado");
		for(String s : listaNomesMuseus){
			museuobra.addItem(s);
		}
		listaNomesMuseus.removeAll(listaNomesMuseus);
		
		//BOTÃO CADASTRAR
				//*CRIAR EXCEÇÃO DE ERRO PARA FALTA DE INFORMAÇÕES
		
				JButton btnCadastrar = new JButton("CADASTRAR");
				btnCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) throws NaoPreenchidoException{
						try{
						String nome = nomeObra.getText();
						if(nome.isEmpty()){throw new NaoPreenchidoException("campo vazio");}
						String loc = localizacaoObra.getText();
						if(loc.isEmpty()){throw new NaoPreenchidoException("campo vazio");}
						//Autor
						String autorNome = nomeAutor.getText();
						String autorNacionalidade = nacionalidadeAutor.getText();
						if(autorNome.isEmpty() || autorNacionalidade.isEmpty()){
							throw new NaoPreenchidoException("campo vazio");
						}
						Autor autor = new Autor(autorNome, autorNacionalidade);
						
						//Categoria 
						if(categoriaObra.getSelectedItem().toString().isEmpty()){
							throw new NaoPreenchidoException("campo vazio");
						}
						Categoria categoria = new Categoria(categoriaObra.getSelectedItem().toString());
			
						//Obra de Arte
						ObradeArte obradearte = new ObradeArte(nome, loc, categoria, autor);
						
						//Museu
						String museuString = museuobra.getSelectedItem().toString();
						//**Museu padrão
						Categoria semCategoria = new Categoria("não fornecido");
						Museu museu = new Museu("nome do museu não fornecido", 
								new Localizacao("não fornecido", "não fornecido","não fornecido","não fornecido"), 
								semCategoria);
						//CASO DE MUSEU NÃO CADASTRADO
						if(museuString.equals("Nao Cadastrado")){ 
							obradearte.setMuseu(museu);
							obradearte.adicionaObra();
						}
						//CASO DE MUSEU CADASTRADO
						else{
							museu = museu.buscaMuseu(museuString);
							obradearte.setMuseu(museu);
							obradearte.adicionaObra();
						}
						//Gravando em Arquivo
						gravaArquivos();
						//Mostrando mensagem na tela
						JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
						}
						catch(NaoPreenchidoException npe){
							JOptionPane.showMessageDialog(null, "Campo Vazio! Preencha todos os Campos");
						}
					}
				});
				
				btnCadastrar.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
				btnCadastrar.setBounds(311, 423, 120, 28);
				getContentPane().add(btnCadastrar);

	}
}