package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import modelo.Jogo;

import java.awt.Font;

public class Principal {

 private JFrame frame;
 private int tam = 4;
 private JButton tabuleiro[][] = new JButton[4][4];
 private JLabel imgs[][] = new JLabel[4][4];
 private JTextField textField;
 private Jogo jogo = new Jogo();
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
  
  JPanel painelMenu = new JPanel();
  painelMenu.setBounds(0, 0, 157, 266);
  frame.getContentPane().add(painelMenu);
  painelMenu.setLayout(null);
  painelMenu.setBackground(Color.DARK_GRAY);
  
  final JTabbedPane tabedPane = new JTabbedPane(JTabbedPane.TOP);
  tabedPane.setBounds(155, 0, 529, 368);
  frame.getContentPane().add(tabedPane);
  
  JPanel painelLogin = new JPanel();
  tabedPane.addTab("Login", null, painelLogin, null);
  painelLogin.setLayout(null);
  
  JPanel painelJogo = new JPanel();
  painelJogo.setLayout(new GridLayout(tam,tam));
  tabedPane.addTab("Jogo", null, painelJogo, null);
  tabedPane.setEnabledAt(1, false);
  
  JPanel painelRank = new JPanel();
  tabedPane.addTab("Rank", null, painelRank, null);
  
  JLabel lbNome = new JLabel("Nome:");
  lbNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lbNome.setBounds(10, 25, 91, 42);
  painelLogin.add(lbNome);
  
  
  textField = new JTextField();
  textField.setBounds(88, 25, 130, 35);
  painelLogin.add(textField);
  textField.setColumns(10);
  
  
  
  
  final JButton btnMenu = new JButton("Login");
  btnMenu.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnMenu) {
     tabedPane.setSelectedIndex(0);
    }
   }
  });
  btnMenu.setBounds(12, 30, 117, 25);
  painelMenu.add(btnMenu);
  
  final JButton btnJogo = new JButton("Jogo");
  btnJogo.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnJogo) {
     tabedPane.setSelectedIndex(1);
    }
   }
  });
  btnJogo.setEnabled(false);
  btnJogo.setBounds(12, 110, 117, 25);
  painelMenu.add(btnJogo);
  
  final JButton btnRank = new JButton("Rank");
  btnRank.setBounds(12, 189, 117, 25);
  painelMenu.add(btnRank);
  btnRank.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnRank) {
     tabedPane.setSelectedIndex(2);
    }
   }
  });
  
  final JButton btnIniciar = new JButton("Inicar Jogo");
  btnIniciar.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnIniciar) {
     btnJogo.setEnabled(true);
    }
   }
  });
  btnIniciar.setBounds(355, 25, 123, 37);
  painelLogin.add(btnIniciar);
  
  JPanel painelPauseReset = new JPanel();
  painelPauseReset.setBounds(0, 265, 164, 103);
  frame.getContentPane().add(painelPauseReset);
  painelPauseReset.setLayout(null);
  painelPauseReset.setBackground(Color.RED);
  
  
  for(int i = 0; i < tam; i++) {
   for(int j = 0; j < tam; j++) {
	tabuleiro[i][j] = new JButton();
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
    
    tabuleiro[i][j].setText(String.valueOf(jogo.tabuleiro[i][j]));
    tabuleiro[i][j].setForeground(Color.WHITE);
    tabuleiro[i][j].setBackground(Color.WHITE);
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
  				int  num = jogo.tabuleiro[i][j];
  				tabuleiro[i][j].remove(imgs[i][j]);
  				 if(jogo.tabuleiro[i][j] == num && jogo.tabuleiro[i][j] != -1) {
  					String numImg = "Numeros/"+num+".png";
  			    	imgs[i][j] = new JLabel(new ImageIcon(numImg),JLabel.CENTER);
  				 }else {
  					 imgs[i][j] = new JLabel(new ImageIcon("Numeros/branco.png"),JLabel.CENTER);
  				 }
  				 tabuleiro[i][j].setText(String.valueOf(jogo.tabuleiro[i][j]));
  				 tabuleiro[i][j].add(imgs[i][j]); 					 
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
 
 public void acaoBotao(ActionEvent e) {
	 boolean venceu = jogo.ehVitoria();
	 if(venceu == false) {
		 
	 }
 } 
 
}