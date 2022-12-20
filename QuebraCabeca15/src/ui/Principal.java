package ui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class Principal {

	private JFrame frame;
	private int tam = 4;
	private JButton tabuleiro[][] = new JButton[4][4];
	private JLabel imgs[][] = new JLabel[4][4];
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
		
		JPanel painelMenu = new JPanel();
		painelMenu.setBounds(12, 12, 146, 344);
		frame.getContentPane().add(painelMenu);
		painelMenu.setLayout(null);
		
		
		JTabbedPane tabedPane = new JTabbedPane(JTabbedPane.TOP);
		tabedPane.setBounds(160, 12, 524, 344);
		frame.getContentPane().add(tabedPane);
		
		JPanel painelLogin = new JPanel();
		tabedPane.addTab("Login", null, painelLogin, null);
		
		JPanel painelJogo = new JPanel();
		painelJogo.setLayout(new GridLayout(tam,tam));
		tabedPane.addTab("Jogo", null, painelJogo, null);
		
		JPanel painelRank = new JPanel();
		tabedPane.addTab("Rank", null, painelRank, null);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(12, 50, 117, 25);
		painelMenu.add(btnMenu);
		
		JButton btnJogo = new JButton("Jogo");
		btnJogo.setEnabled(false);
		btnJogo.setBounds(12, 155, 117, 25);
		painelMenu.add(btnJogo);
		
		JButton btnRank = new JButton("Rank");
		btnRank.setBounds(12, 260, 117, 25);
		painelMenu.add(btnRank);
		
		for(int i = 0; i < tam; i++) {
			for(int j = 0; j < tam; j++) {
				tabuleiro[i][j] = new JButton();
				tabuleiro[i][j].setSize(50,50);
				painelJogo.add(tabuleiro[i][j]);
			}
		}
		
	}
}
