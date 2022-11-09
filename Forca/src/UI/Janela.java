package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
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
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 422, 244);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Inicio = new JPanel();
		tabbedPane.addTab("Início", null, Inicio, null);
		Inicio.setLayout(null);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButton radioFilme = new JRadioButton("Filmes");
		radioFilme.setBounds(30, 55, 149, 23);
		Inicio.add(radioFilme);
		
		JRadioButton RadioNovela = new JRadioButton("Novelas");
		RadioNovela.setBounds(30, 105, 149, 23);
		Inicio.add(RadioNovela);
		
		JRadioButton RadioCarro = new JRadioButton("Carros");
		RadioCarro.setBounds(30, 155, 149, 23);
		Inicio.add(RadioCarro);
		
		buttonGroup.add(RadioNovela);
		buttonGroup.add(radioFilme);
		buttonGroup.add(RadioCarro);
		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnJogar.setBounds(270, 154, 117, 25);
		Inicio.add(btnJogar);
		
		JLabel Início = new JLabel("Início");
		Início.setBounds(165, 12, 70, 15);
		Inicio.add(Início);
		
		JPanel Jogo = new JPanel();
		tabbedPane.addTab("Jogo", null, Jogo, null);
	}
}
