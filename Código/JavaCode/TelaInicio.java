package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;


public class TelaInicio extends JFrame{

	// Construtor TelaInicio()
	
	public TelaInicio() {
		initialize();
}
	


	//initialize() contém os elementos da tela
	private void initialize() {
		
		
		setTitle("Art Founder");
		setBackground(Color.ORANGE);
		setResizable(false);
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setForeground(Color.ORANGE);
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//PAINEL JPANEL
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 180, 477);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//BOTÃO ENCONTRAR OBRA DE ARTE
		JButton btnEncontrarObra = new JButton("Encontrar Obra de Arte");
		btnEncontrarObra.setBackground(Color.LIGHT_GRAY);
		btnEncontrarObra.setBounds(12, 98, 162, 28);
		btnEncontrarObra.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		panel.add(btnEncontrarObra);
		//AÇÕES
		btnEncontrarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEncontrarObra teo = new TelaEncontrarObra();
				teo.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		
		// BOTÃO CADASTRAR OBRA DE ARTE
		JButton btnCadastrarObra = new JButton("Cadastrar Obra de Arte");
		btnCadastrarObra.setBounds(12, 225, 156, 28);
		btnCadastrarObra.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		panel.add(btnCadastrarObra);
		//AÇÕES
		btnCadastrarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarObra tco = new TelaCadastrarObra();
				tco.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		
		// BOTÃO CADASTRAR MUSEU
		JButton btnCadastrarMuseu = new JButton("Cadastrar Museu");
		btnCadastrarMuseu.setBounds(12, 349, 156, 28);
		panel.add(btnCadastrarMuseu);
		btnCadastrarMuseu.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 10));
		//AÇÕES
		btnCadastrarMuseu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarMuseu tco = new TelaCadastrarMuseu();
				tco.setVisible(true);
				dispose();
				setVisible(false);
			}
		});

		
		//JLABELS (TEXTOS E IMAGENS)//
		
		JLabel lblArtFounder = new JLabel("ART FOUNDER");
		lblArtFounder.setBackground(Color.GRAY);
		lblArtFounder.setForeground(Color.ORANGE);
		lblArtFounder.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 27));
		lblArtFounder.setBounds(552, 190, 215, 28);
		getContentPane().add(lblArtFounder);
		
		JLabel lblDesenvPorMichelly = new JLabel("Por MichellyLima e BeatrizGuimar\u00E3es");
		lblDesenvPorMichelly.setForeground(Color.BLACK);
		lblDesenvPorMichelly.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblDesenvPorMichelly.setBounds(541, 443, 253, 16);
		getContentPane().add(lblDesenvPorMichelly);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/arte.png")));
		lblFundo.setBounds(168, 0, 512, 477);
		getContentPane().add(lblFundo);

	}
}