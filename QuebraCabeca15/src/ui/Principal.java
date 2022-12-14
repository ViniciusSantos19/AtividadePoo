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
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import modelo.Agenda;
import modelo.Jogador;
import modelo.Jogo;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Scrollbar;
import java.awt.Label;

public class Principal implements ActionListener{

 private JFrame frame;
 private int tam = 4;
 private JButton tabuleiro[][] = new JButton[4][4];
 private JLabel imgs[][] = new JLabel[4][4];
 private JTextField txtNome;
 private Jogo jogo = new Jogo();
 private Jogador jogador;
 private JTextField txtCodigo;
 private JTextField txtNomeCadastro;
 private Agenda bd = new Agenda();
 private JTextField txtCodCadastro;
 private int idJogo;
 private Label contagemTempo = new Label("00:00:00");
 private boolean tempoPassando = false;
 private int iCount = 0;
 private Timer tm = null;
 private int salvarCoun;
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
  frame.setBounds(100, 100, 700, 458);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().setLayout(null);
  frame.setResizable(false);
  
  String qntdJogadores[] = {"1 jogador","2 jogadores", "3 jogadores"};
  String parOuImpar[] = {"embaralhar par","embaralhar ??mpar"};
  
  JPanel painelMenu = new JPanel();
  painelMenu.setBounds(0, 0, 157, 308);
  frame.getContentPane().add(painelMenu);
  painelMenu.setLayout(null);
  painelMenu.setBackground(Color.DARK_GRAY);
  
  final JTabbedPane tabedPane = new JTabbedPane(JTabbedPane.TOP);
  tabedPane.setBounds(155, 0, 541, 426);
  frame.getContentPane().add(tabedPane);
  
  JPanel painelCadastro = new JPanel();
  painelCadastro.setLayout(null);
  tabedPane.addTab("Cadastro", null, painelCadastro, null);
  
  JLabel lbNome_1 = new JLabel("Nome:");
  lbNome_1.setFont(new Font("Dialog", Font.PLAIN, 20));
  lbNome_1.setBounds(12, 39, 91, 42);
  painelCadastro.add(lbNome_1);
  
  txtNomeCadastro = new JTextField();
  txtNomeCadastro.setColumns(10);
  txtNomeCadastro.setBounds(84, 39, 130, 35);
  painelCadastro.add(txtNomeCadastro);
  
  JLabel lbNome_1_1 = new JLabel("C??digo:");
  lbNome_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
  lbNome_1_1.setBounds(12, 122, 91, 42);
  painelCadastro.add(lbNome_1_1);
  
  txtCodCadastro = new JTextField();
  txtCodCadastro.setColumns(10);
  txtCodCadastro.setBounds(94, 122, 130, 35);
  painelCadastro.add(txtCodCadastro);
  
  final JButton btnCadastra = new JButton("Cadastrar");
  btnCadastra.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() == btnCadastra) {
  			if(!txtCodCadastro.getText().isEmpty() && ! txtNomeCadastro.getText().isEmpty()) {
  				Jogador jogadorAux = new Jogador(Integer.parseInt(txtCodCadastro.getText()), txtNomeCadastro.getText(),0);
  	  			try {
  					bd.addJogador(jogadorAux);
  					JOptionPane.showMessageDialog(btnCadastra, "Cadastrado com sucesso");
  				} catch (Exception e1) {
  					JOptionPane.showMessageDialog(btnCadastra, "Erro ao cadastrar");
  					e1.printStackTrace();
  				}
  			}
  			
  		}
  	}
  });
  btnCadastra.setBounds(358, 122, 123, 37);
  painelCadastro.add(btnCadastra);
  
  JPanel painelLogin = new JPanel();
  tabedPane.addTab("Login", null, painelLogin, null);
  painelLogin.setLayout(null);
  
  final JPanel painelJogo = new JPanel();
  painelJogo.setLayout(new GridLayout(tam,tam));
  tabedPane.addTab("Jogo", null, painelJogo, null);
  tabedPane.setEnabledAt(2, false);
  
  JPanel painelRank = new JPanel();
  tabedPane.addTab("Rank", null, painelRank, null);
  painelRank.setLayout(null);
  
  JLabel labelRank = new JLabel("Rank:");
  labelRank.setFont(new Font("Dialog", Font.BOLD, 20));
  labelRank.setBounds(12, 24, 79, 48);
  painelRank.add(labelRank);
  
  final JTextArea textPane = new JTextArea();
  textPane.setBackground(new Color(0, 0, 0));
  textPane.setEnabled(false);
  textPane.setBounds(84, 36, 225, 299);
  textPane.setForeground(new Color(255, 255, 255));
  painelRank.add(textPane);
  JScrollPane jsp = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  jsp.setBounds(84, 36, 225, 299);
  painelRank.add(jsp);
  
  
  final JButton btnSetRank = new JButton("Gerar rank");
  btnSetRank.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		if(arg0.getSource() == btnSetRank) {
  			try {
  				List<Jogador> jogadores = bd.getRank();
  				String lista = " ";
  				for(int i = 0; i < jogadores.size(); i++) {
  					
  					lista+="\n"+jogadores.get(i).getIdJogador()+"\n"+jogadores.get(i).getNome()+"\n"+jogadores.get(i).getPontos()+"\n";
  				}
  				textPane.setText(lista);
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}
  		
  	}
  });
  btnSetRank.setBounds(87, 347, 117, 25);
  painelRank.add(btnSetRank);
  
  final JButton btnZerarRank = new JButton("Zerar rank");
  btnZerarRank.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		if(arg0.getSource() == btnZerarRank) {
  			try {
				bd.zerarRank();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}
  	}
  });
  btnZerarRank.setBounds(255, 347, 117, 25);
  painelRank.add(btnZerarRank);
  
 
  
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
  
  JLabel lblCodigo = new JLabel("C??digo:");
  lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 20));
  lblCodigo.setBounds(10, 79, 91, 42);
  painelLogin.add(lblCodigo);
  
  txtCodigo = new JTextField();
  txtCodigo.setColumns(10);
  txtCodigo.setBounds(88, 86, 91, 35);
  painelLogin.add(txtCodigo);
  
  final JComboBox cbModoJogo = new JComboBox(parOuImpar);
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
  
  
  contagemTempo.setFont(new Font("Dialog", Font.PLAIN, 20));
  contagemTempo.setForeground(new Color(255, 255, 255));
  contagemTempo.setBounds(12, 246, 117, 40);
  painelMenu.add(contagemTempo);
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
    		try {
				jogador = bd.getJogador(codigo,nome);
				jogo = bd.AddJogo(jogo);
				idJogo = jogo.getIdJogo();
				bd.addJogoJogador(jogo.getIdJogo(), codigo);
				JOptionPane.showMessageDialog(btnCadastra, "Login feito com sucesso");
				
				iniciarCronometro();
				
				if(cbModoJogo.getSelectedIndex() == 1) {
					jogoParouImpar(cbModoJogo.getSelectedIndex());
		    		btnJogo.setEnabled(true);
		    		JOptionPane.showMessageDialog(cbModoJogo, "Jogo impar (IMPOSSIVEL)");
				}else {
					jogoParouImpar(cbModoJogo.getSelectedIndex());
		    		btnJogo.setEnabled(true);
		    		JOptionPane.showMessageDialog(cbModoJogo, "Jogo par");
				}
				 tabedPane.setSelectedIndex(2);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(btnCadastra, "Erro ao fazer login");
				e1.printStackTrace();
			}
    		
    	}
    }
   }
  });
  btnIniciar.setBounds(355, 25, 123, 37);
  painelLogin.add(btnIniciar);
  
  final JButton btnCarregarJogo = new JButton("Carregar");
  btnCarregarJogo.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() ==btnCarregarJogo) {
  			if(!txtNome.getText().isEmpty() && !txtCodigo.getText().isEmpty()) {
  				String nome = txtNome.getText();
  	    		int codigo = Integer.parseInt(txtCodigo.getText());
  	    		try {
					jogador = bd.getJogador(codigo, nome);
					List lista = bd.getIdJogos(jogador);
					String[] array = (String[]) lista.toArray(new String[0]);
					JComboBox cbListaJogos = new JComboBox(array);
					JOptionPane.showMessageDialog(null, cbListaJogos, "Selecione o save", JOptionPane.QUESTION_MESSAGE);
					int aux= Integer.parseInt(cbListaJogos.getSelectedItem().toString());
					jogo= bd.getJogo(aux);
					idJogo = aux;
					
					CarregarTempo(jogo.getSecSalvo());
					
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
					btnJogo.setEnabled(true);
					tabedPane.setSelectedIndex(2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
  			}
  		}
  	}
  });
  btnCarregarJogo.setBounds(355, 90, 123, 37);
  painelLogin.add(btnCarregarJogo);
  
  
    
  JPanel painelPauseReset = new JPanel();
  painelPauseReset.setBounds(0, 292, 157, 134);
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
			reiniciarTabuleiro();
  		}
  	}
  });
  btnPauseReset.setBounds(29, 27, 101, 25);
  painelPauseReset.add(btnPauseReset);
  
  final JButton btnPausar = new JButton("Pausar");
  btnPausar.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() == btnPausar) {
  			if (tempoPassando == true) {
  				//tm = new Timer();
				tm.cancel();
				tm.purge();
				tempoPassando = false;
				salvarCoun = iCount;

			}else {
				tempoPassando= true;
				CarregarTempo(salvarCoun);
			}
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
  btnPausar.setBounds(29, 64, 101, 25);
  painelPauseReset.add(btnPausar);
  
  final JButton btnSalvar = new JButton("Salvar");
  btnSalvar.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource() == btnSalvar) {
  			try {
  	  			Jogo jogoAux = jogo;
  	  			jogoAux.setSecSalvo(iCount);
  	  			bd.updateTabuleiro(jogoAux, jogo.getIdJogo());
  				JOptionPane.showMessageDialog(btnCadastra, "Jogo "+idJogo+" salvo com sucesso");
  			} catch (Exception e1) {
  				JOptionPane.showMessageDialog(btnCadastra, "Erro ao salvar o jogo");
  				e1.printStackTrace();
  			}
  		}
  	}
  });
  btnSalvar.setBounds(29, 97, 101, 25);
  painelPauseReset.add(btnSalvar);
  
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
		 try {
			bd.updatePontos(jogador.getIdJogador(),jogo.calculaPonos(iCount));
			bd.deleteJogoJogador(idJogo);
			bd.deleteJogo(idJogo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 tempoPassando = false;
		 iCount = 0;
		 tm.cancel();
		 tm.purge();
		 JOptionPane.showMessageDialog(frame, "VOCE VENCEU");
		 reiniciarTabuleiro();
		 try {
			jogo = bd.AddJogo(jogo);
			bd.addJogoJogador(jogo.getIdJogo(), jogador.getIdJogador());
			tempoPassando = true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	 }
		
	}
 
 	public void iniciarCronometro() {
 		if(tempoPassando == true) {
			tm.cancel();
			tm.purge();
		}
 		tempoPassando = true;
		iCount = 0;
		
		tm = new Timer();
		
		tm.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				iCount++;
				salvarCoun = iCount;
				int seg = iCount % 60;
				int min = iCount / 60;
				int hora = min / 60;
				min %= 60;
				contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg)); // Mostra Tempo

			}

		}, 1000, 1000); // 1000 = 1s
 	}
 	
 	public void CarregarTempo(int tempoSomando) {
		if(tempoPassando == true) {
			tm.cancel();
			tm.purge();
		}
 		tempoPassando = true;
		iCount = tempoSomando;
		
		tm = new Timer();
		tm.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				iCount++;
				int seg = iCount % 60;
				int min = iCount / 60;
				int hora = min / 60;
				min %= 60;
				contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg)); // Mostra Tempo

			}

		}, 1000, 1000); // 1000 = 1s
 	}
 	
 	public void reiniciarTabuleiro() {
 		jogo.reiniciaJogo();
			
		iniciarCronometro();
			
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
 	
 	public void jogoParouImpar(int parOuImpar) {
 		if(parOuImpar == 1) {
 			jogo.getArrayInvalido();
 		}else {
 			jogo.getArrayValido();
 		}
 		jogo.testeOrdenado();
 		//jogo.iniciaTabuleiro();
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