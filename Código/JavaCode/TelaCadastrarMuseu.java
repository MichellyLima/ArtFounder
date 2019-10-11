package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastrarMuseu extends JFrame{
	private JTextField nomeMuseu;
	private JTextField enderecoMuseu;
	private JTextField bairroMuseu;
	private JTextField cidadeMuseu;
	private JTextField estadoMuseu;
	protected String nome;
	boolean continua = true;
	
	// Construtor TelaCadastrarMuseu()
		public TelaCadastrarMuseu(){
			initialize();
		}
		
	
	//Método para gravar em arquivos
	private void gravaArquivos(){
		try {
			//ARQUIVO MUSEUS
			File diretorio = new File("ArtFounder/BancoDeDados");
			
			if(!diretorio.exists()){
				diretorio.mkdirs();
			}
			
			File file = new File("ArtFounder/BancoDeDados/Museus.txt");
			OutputStream os = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			for(Museu museu : Museu.getMuseus()){
					bw.write(museu.escreveArquivo());
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
		JButton buttonVoltarMenu = new JButton("Voltar Menu");
		buttonVoltarMenu.setBounds(10, 70, 147, 28);
		buttonVoltarMenu.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		getContentPane().add(buttonVoltarMenu);
		//AÇÕES
		buttonVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio ti = new TelaInicio();
				ti.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		
		
		//JLABEL (TEXTOS E IMAGENS)
		JLabel fundo = new JLabel("");
		fundo.setBounds(445, -12, 512, 512);
		fundo.setIcon(new ImageIcon(TelaCadastrarMuseu.class.getResource("/imgs/abstrato.png")));
		getContentPane().add(fundo);
		
		JLabel lblCadastrarMuseu = new JLabel("CADASTRAR MUSEU");
		lblCadastrarMuseu.setBounds(251, 0, 194, 64);
		lblCadastrarMuseu.setForeground(Color.ORANGE);
		lblCadastrarMuseu.setFont(new Font("Lucida Sans", Font.BOLD, 19));
		getContentPane().add(lblCadastrarMuseu);
		
		JLabel lblNewLabel = new JLabel("Nome do Museu");
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNewLabel.setBounds(290, 54, 116, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNewLabel_1.setBounds(304, 106, 88, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endereco");
		lblNewLabel_2.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNewLabel_2.setBounds(304, 186, 88, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Localiza\u00E7\u00E3o");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 17));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(282, 165, 132, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Bairro");
		lblNewLabel_4.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNewLabel_4.setBounds(321, 236, 55, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblCidade.setBounds(321, 288, 55, 16);
		getContentPane().add(lblCidade);
		
		JLabel lblNewLabel_5 = new JLabel("Estado");
		lblNewLabel_5.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		lblNewLabel_5.setBounds(321, 341, 55, 16);
		getContentPane().add(lblNewLabel_5);
		
		//BOX INSERIR DADOS
		nomeMuseu = new JTextField();
		nomeMuseu.setBounds(276, 75, 144, 28);
		getContentPane().add(nomeMuseu);
		nomeMuseu.setColumns(10);
		
		enderecoMuseu = new JTextField();
		enderecoMuseu.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		enderecoMuseu.setBounds(276, 208, 144, 28);
		getContentPane().add(enderecoMuseu);
		enderecoMuseu.setColumns(10);
		
		bairroMuseu = new JTextField();
		bairroMuseu.setBounds(276, 257, 144, 28);
		getContentPane().add(bairroMuseu);
		bairroMuseu.setColumns(10);
		
		cidadeMuseu = new JTextField();
		cidadeMuseu.setBounds(276, 309, 144, 28);
		getContentPane().add(cidadeMuseu);
		cidadeMuseu.setColumns(10);
		
		estadoMuseu = new JTextField();
		estadoMuseu.setBounds(276, 363, 144, 28);
		getContentPane().add(estadoMuseu);
		estadoMuseu.setColumns(10);
		
		JComboBox<String> categoriaMuseu = new JComboBox<String>();
		categoriaMuseu.setModel(new DefaultComboBoxModel<String>(new String[] {"Musica", "Espacial", "Arte Medieval", "Arte Moderna", "Arte Contemporanea"}));
		categoriaMuseu.setFont(new Font("Lucida Sans", Font.BOLD, 13));
		categoriaMuseu.setBounds(276, 128, 144, 28);
		getContentPane().add(categoriaMuseu);
		
		//BOTÃO CADASTRAR
		JButton buttonCadastrar = new JButton("CADASTRAR");
		buttonCadastrar.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 13));
		buttonCadastrar.setBounds(282, 420, 132, 28);
		getContentPane().add(buttonCadastrar);
		//AÇÕES
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NaoPreenchidoException{
				try{
				//NOME DO MUSEU
				String nomemuseu = nomeMuseu.getText();
				if(nomemuseu.isEmpty()){ throw new NaoPreenchidoException("campo vazio");}
				//CATEGORIA DO MUSEU
				String categoriaMuseuString = categoriaMuseu.getSelectedItem().toString();
				if(categoriaMuseuString.isEmpty()){ throw new NaoPreenchidoException("campo vazio");}
				Categoria categoriamuseu = new Categoria(categoriaMuseuString);
				
				//ENDEREÇO 
				String endereco = enderecoMuseu.getText();
				String bairro = bairroMuseu.getText();
				String cidade = cidadeMuseu.getText();
				String estado = estadoMuseu.getText();
				if(endereco.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado.isEmpty()){ 
					throw new NaoPreenchidoException("campo vazio");
				}
				Localizacao localizacao = new Localizacao(endereco, bairro, cidade, estado);
				
				Museu museu = new Museu(nomemuseu, localizacao, categoriamuseu);
				
				museu.adicionaMuseu();
				gravaArquivos();
				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
				}
				catch(NaoPreenchidoException npe){
					JOptionPane.showMessageDialog(null, "Campo Vazio! Preencha todos os Campos");
				}
			}
		});
		
	}
}