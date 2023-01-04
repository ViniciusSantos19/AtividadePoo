package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import modelo.Jogador;
import modelo.Jogo;

import java.awt.Font;
import javax.swing.JComboBox;

public class Principal implements ActionListener{

 private JFrame frame;
 private int tam = 4;
 private JButton tabuleiro[][] = new JButton[4][4];
 private JLabel imgs[][] = new JLabel[4][4];
 private JTextField txtNome;
 private Jogo jogo = new Jogo();
 private Jogador jogador;
 private JTextField txtCodigo;
 private JTextField textField_1;
 private JTextField textField_2;
 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Principal window = new Principal();
     window.frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
  */
 public Principal() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  frame = new JFrame();
  frame.setBounds(100, 100, 700, 400);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().setLayout(null);
  frame.setResizable(false);
  
  String qntdJogadores[] = {"1 jogador","2 jogadores", "3 jogadores"};
  String parOuImpar[] = {"embaralhar par","embaralhar ímpar"};
  
  JPanel painelMenu = new JPanel();
  painelMenu.setBounds(0, 0, 157, 266);
  frame.getContentPane().add(painelMenu);
  painelMenu.setLayout(null);
  painelMenu.setBackground(Color.DARK_GRAY);
  
  final JTabbedPane tabedPane = new JTabbedPane(JTabbedPane.TOP);
  tabedPane.setBounds(155, 0, 529, 368);
  frame.getContentPane().add(tabedPane);
  
  JPanel painelCadastro = new JPanel();
  painelCadastro.setLayout(null);
  tabedPane.addTab("Cadastro", null, painelCadastro, null);
  
  JLabel lbNome_1 = new JLabel("Nome:");
  lbNome_1.setFont(new Font("Dialog", Font.PLAIN, 20));
  lbNome_1.setBounds(12, 39, 91, 42);
  painelCadastro.add(lbNome_1);
  
  textField_1 = new JTextField();
  textField_1.setColumns(10);
  textField_1.setBounds(84, 39, 130, 35);
  painelCadastro.add(textField_1);
  
  JLabel lbNome_1_1 = new JLabel("Código:");
  lbNome_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
  lbNome_1_1.setBounds(12, 122, 91, 42);
  painelCadastro.add(lbNome_1_1);
  
  textField_2 = new JTextField();
  textField_2.setColumns(10);
  textField_2.setBounds(94, 122, 130, 35);
  painelCadastro.add(textField_2);
  
  JButton btnCadastra = new JButton("Cadastrar");
  btnCadastra.setBounds(358, 122, 123, 37);
  painelCadastro.add(btnCadastra);
  
  JPanel painelLogin = new JPanel();
  tabedPane.addTab("Login", null, painelLogin, null);
  painelLogin.setLayout(null);
  
  JPanel painelJogo = new JPanel();
  painelJogo.setLayout(new GridLayout(tam,tam));
  tabedPane.addTab("Jogo", null, painelJogo, null);
  tabedPane.setEnabledAt(2, false);
  
  JPanel painelRank = new JPanel();
  tabedPane.addTab("Rank", null, painelRank, null);
  
  JLabel lbNome = new JLabel("Nome:");
  lbNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lbNome.setBounds(10, 25, 91, 42);
  painelLogin.add(lbNome);
  
  
  txtNome = new JTextField();
  txtNome.setBounds(88, 25, 130, 35);
  painelLogin.add(txtNome);
  txtNome.setColumns(10);
  
  JLabel lbMododeJogo = new JLabel("Modo de Jogo:");
  lbMododeJogo.setFont(new Font("Dialog", Font.PLAIN, 20));
  lbMododeJogo.setBounds(10, 155, 155, 42);
  painelLogin.add(lbMododeJogo);
  
  JLabel lblCodigo = new JLabel("Código:");
  lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 20));
  lblCodigo.setBounds(10, 79, 91, 42);
  painelLogin.add(lblCodigo);
  
  txtCodigo = new JTextField();
  txtCodigo.setColumns(10);
  txtCodigo.setBounds(88, 86, 91, 35);
  painelLogin.add(txtCodigo);
  
  JComboBox cbModoJogo = new JComboBox(parOuImpar);
  cbModoJogo.setBounds(165, 166, 177, 24);
  painelLogin.add(cbModoJogo);
  
  JLabel lblQuantidadeDeJogadores = new JLabel("Quantidade de jogadores:");
  lblQuantidadeDeJogadores.setFont(new Font("Dialog", Font.PLAIN, 20));
  lblQuantidadeDeJogadores.setBounds(10, 225, 275, 42);
  painelLogin.add(lblQuantidadeDeJogadores);
  
  JComboBox cbQntdJogadores = new JComboBox(qntdJogadores);
  cbQntdJogadores.setBounds(274, 236, 130, 24);
  painelLogin.add(cbQntdJogadores);

  final JButton btnMenu = new JButton("Login");
  btnMenu.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnMenu) {
     tabedPane.setSelectedIndex(1);
    }
   }
  });
  btnMenu.setBounds(12, 85, 117, 25);
  painelMenu.add(btnMenu);
  
  final JButton btnJogo = new JButton("Jogo");
  btnJogo.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnJogo) {
     tabedPane.setSelectedIndex(2);
    }
   }
  });
  btnJogo.setEnabled(false);
  btnJogo.setBounds(12, 149, 117, 25);
  painelMenu.add(btnJogo);
  
  final JButton btnRank = new JButton("Rank");
  btnRank.setBounds(12, 215, 117, 25);
  painelMenu.add(btnRank);
  
  final JButton btnCadastro = new JButton("Cadastro");
  btnCadastro.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() == btnCadastro) {
  			tabedPane.setSelectedIndex(0);
  		}
  	}
  });
  btnCadastro.setBounds(12, 26, 117, 25);
  painelMenu.add(btnCadastro);
  btnRank.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnRank) {
     tabedPane.setSelectedIndex(3);
     	
    }
   }
  });
  
  final JButton btnIniciar = new JButton("Novo jogo");
  btnIniciar.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnIniciar) {
    	if(!txtNome.getText().isEmpty() && !txtCodigo.getText().isEmpty()) {
    		String nome = txtNome.getText();
    		int codigo = Integer.parseInt(txtCodigo.getText());
    		Jogador jogador = new Jogador(codigo,nome,jogo,0);
    		jogo.setIdJogo(codigo);
    		btnJogo.setEnabled(true);
    	}
    }
   }
  });
  btnIniciar.setBounds(355, 25, 123, 37);
  painelLogin.add(btnIniciar);
  
  JButton btnCarregarJogo = new JButton("Carregar");
  btnCarregarJogo.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		
  	}
  });
  btnCarregarJogo.setBounds(355, 90, 123, 37);
  painelLogin.add(btnCarregarJogo);
  
  
    
  JPanel painelPauseReset = new JPanel();
  painelPauseReset.setBounds(0, 265, 157, 103);
  frame.getContentPane().add(painelPauseReset);
  painelPauseReset.setLayout(null);
  painelPauseReset.setBackground(Color.RED);
  
  jogo.testeOrdenado();
  for(int i = 0; i < tam; i++) {
   for(int j = 0; j < tam; j++) {
	String texto = i+","+j;
	tabuleiro[i][j] = new JButton();
	tabuleiro[i][j].addActionListener(this);
    tabuleiro[i][j].setSize(50,50);
    int num = jogo.tabuleiro[i][j];
    if(num != -1) {
    	String numImg = "Numeros/"+num+".png";
    	imgs[i][j] = new JLabel(new ImageIcon(numImg),JLabel.CENTER);
    }else if(num == -1) {
    	imgs[i][j] = new JLabel(new ImageIcon("Numeros/branco.png"),JLabel.CENTER);
    }
    tabuleiro[i][j].setBorder(BorderFactory.createLineBorder(Color.black,2));
    tabuleiro[i][j].add(imgs[i][j]);
    
    tabuleiro[i][j].setText(texto);
    tabuleiro[i][j].setForeground(Color.DARK_GRAY);
    tabuleiro[i][j].setBackground(Color.DARK_GRAY);
    painelJogo.add(tabuleiro[i][j]);
   }
  }
  
  
  
  final JButton btnPauseReset = new JButton("Reiniciar");
  btnPauseReset.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() == btnPauseReset) {
  			jogo.reiniciaJogo();
  			for(int i = 0; i < tam; i++) {
  			   for(int j = 0; j < tam; j++) {
  				String texto = i+","+j;
  				int  num = jogo.tabuleiro[i][j];
  				tabuleiro[i][j].remove(imgs[i][j]);
  				 if(num != -1) {
  					String numImg = "Numeros/"+num+".png";
  			    	imgs[i][j] = new JLabel(new ImageIcon(numImg),JLabel.CENTER);
  				 }else {
  					 imgs[i][j] = new JLabel(new ImageIcon("Numeros/branco.png"),JLabel.CENTER);
  				 }
  				 tabuleiro[i][j].setText(String.valueOf(jogo.tabuleiro[i][j]));
  				 tabuleiro[i][j].add(imgs[i][j]);
  				 tabuleiro[i][j].setText(texto);
  			   }
  			  }
  		}
  	}
  });
  btnPauseReset.setBounds(29, 12, 101, 25);
  painelPauseReset.add(btnPauseReset);
  
  final JButton btnPausar = new JButton("Pausar");
  btnPausar.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() == btnPausar) {
  			for(int i = 0; i < tam; i++) {
  				for(int j = 0;  j < tam; j++) {
  					if(tabuleiro[i][j].isEnabled() == true) {
  						tabuleiro[i][j].setEnabled(false);
  						btnPauseReset.setEnabled(false);
  						
  					}else {
  						tabuleiro[i][j].setEnabled(true);
  						btnPauseReset.setEnabled(true);
  					}
  				}
  			}
  		}
  	}
  });
  btnPausar.setBounds(29, 66, 101, 25);
  painelPauseReset.add(btnPausar);
  
 }
 
 public void actionPerformed(ActionEvent e) {
	 boolean venceu = jogo.ehVitoria();
	 if(venceu == false) {
		 String s = e.getActionCommand().toString();
		 int l = Integer.parseInt(s.split(",")[0]);
         int c = Integer.parseInt(s.split(",")[1]);
         if(jogo.tabuleiro[l][c] != -1) {
        	 if(l + 1 < tam && jogo.tabuleiro[l+1][c] == -1) {
        		 imgs[l][c].setIcon(new ImageIcon("Numeros/branco.png"));
        		 String numImg = "Numeros/"+jogo.tabuleiro[l][c]+".png";
        		 imgs[l+1][c].setIcon(new ImageIcon(numImg));
        		 jogo.troca(l, c, l+1, c);
        	 }else if(l - 1 >= 0 && jogo.tabuleiro[l-1][c] == -1) {
        		 imgs[l][c].setIcon(new ImageIcon("Numeros/branco.png"));
        		 String numImg = "Numeros/"+jogo.tabuleiro[l][c]+".png";
        		 imgs[l-1][c].setIcon(new ImageIcon(numImg));
        		 jogo.troca(l, c, l-1, c);
        	 }else if(c + 1 < tam && jogo.tabuleiro[l][c+1] == -1) {
        		 imgs[l][c].setIcon(new ImageIcon("Numeros/branco.png"));
        		 String numImg = "Numeros/"+jogo.tabuleiro[l][c]+".png";
        		 imgs[l][c+1].setIcon(new ImageIcon(numImg));
        		 jogo.troca(l, c, l, c+1);
        	 }else if(c - 1 >=0 && jogo.tabuleiro[l][c-1] == -1) {
        		 imgs[l][c].setIcon(new ImageIcon("Numeros/branco.png"));
        		 String numImg = "Numeros/"+jogo.tabuleiro[l][c]+".png";
        		 imgs[l][c-1].setIcon(new ImageIcon(numImg));
        		 jogo.troca(l, c, l, c-1);
        	 }
         }
	 }else {
		 JOptionPane.showMessageDialog(frame, "VOCE VENCEU");
	 }
		
	}
}