package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import negocio.Pontos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jogo {

	private JFrame frame;
	private JTextField txtVencedor;
	private JTextField txtPlacarX;
	private JTextField txtPlacarY;
	//private Pontos pontos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo window = new Jogo();
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
	public Jogo() {
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
		String Letras[] = {"X","O"};
		Pontos pontos = new Pontos();
		
		JLabel lblNewLabel = new JLabel("Jogo da velha");
		lblNewLabel.setBounds(165, 6, 95, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vencedor:");
		lblNewLabel_1.setBounds(32, 231, 84, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtVencedor = new JTextField();
		txtVencedor.setBounds(104, 224, 38, 29);
		frame.getContentPane().add(txtVencedor);
		txtVencedor.setColumns(10);
		
		JComboBox cb1 = new JComboBox(Letras);
		cb1.setBounds(32, 33, 66, 35);
		frame.getContentPane().add(cb1);
		//cb1.addItem(Letras);
		
		JComboBox cb2 = new JComboBox(Letras);
		cb2.setBounds(165, 33, 66, 35);
		frame.getContentPane().add(cb2);
		//cb2.addItem(Letras);
		
		JComboBox cb3 = new JComboBox(Letras);
		cb3.setBounds(303, 33, 66, 35);
		frame.getContentPane().add(cb3);
		//cb3.addItem(Letras);
		
		JComboBox cb5 = new JComboBox(Letras);
		cb5.setBounds(165, 91, 66, 35);
		frame.getContentPane().add(cb5);
		//cb5.addItem(Letras);
		
		JComboBox cb6 = new JComboBox(Letras);
		cb6.setBounds(303, 91, 66, 35);
		frame.getContentPane().add(cb6);
		//cb6.addItem(Letras);
		
		JComboBox cb4 = new JComboBox(Letras);
		cb4.setBounds(32, 91, 66, 35);
		frame.getContentPane().add(cb4);
		//cb4.addItem(Letras);
		
		JComboBox cb9 = new JComboBox(Letras);
		cb9.setBounds(303, 150, 66, 35);
		frame.getContentPane().add(cb9);
		//cb9.addItem(Letras);
		
		JComboBox cb8 = new JComboBox(Letras);
		cb8.setBounds(165, 150, 66, 35);
		frame.getContentPane().add(cb8);
		//cb8.addItem(Letras);
		
		JComboBox cb7 = new JComboBox(Letras);
		cb7.setBounds(32, 150, 66, 35);
		frame.getContentPane().add(cb7);
		//cb7.addItem(Letras);
		
		JLabel lblNewLabel_2 = new JLabel("Placar:");
		lblNewLabel_2.setBounds(268, 231, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtPlacarX = new JTextField();
		txtPlacarX.setColumns(10);
		txtPlacarX.setBounds(328, 217, 38, 29);
		frame.getContentPane().add(txtPlacarX);
		txtPlacarX.setText(""+pontos.getPontosJogador1());
		
		txtPlacarY = new JTextField();
		txtPlacarY.setColumns(10);
		txtPlacarY.setBounds(378, 217, 38, 29);
		frame.getContentPane().add(txtPlacarY);
		txtPlacarY.setText(""+pontos.getPontosJogador2());
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(341, 197, 25, 15);
		frame.getContentPane().add(lblX);
		
		JLabel lblO = new JLabel("O");
		lblO.setBounds(391, 197, 25, 15);
		frame.getContentPane().add(lblO);
		
		JButton btaoJogar = new JButton("Jogar");
		btaoJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb1.getSelectedItem().toString() == "X" && cb2.getSelectedItem().toString() == "X" && cb3.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb1.getSelectedItem().toString() == "O" && cb2.getSelectedItem().toString() == "O" && cb3.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb4.getSelectedItem().toString() == "X" && cb5.getSelectedItem().toString() == "X" && cb6.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb4.getSelectedItem().toString() == "O" && cb5.getSelectedItem().toString() == "O" && cb6.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb7.getSelectedItem().toString() == "X" && cb8.getSelectedItem().toString() == "X" && cb9.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb7.getSelectedItem().toString() == "O" && cb8.getSelectedItem().toString() == "O" && cb9.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb1.getSelectedItem().toString() == "X" && cb4.getSelectedItem().toString() == "X" && cb7.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb1.getSelectedItem().toString() == "O" && cb4.getSelectedItem().toString() == "O" && cb7.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb2.getSelectedItem().toString() == "X" && cb5.getSelectedItem().toString() == "X" && cb8.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb2.getSelectedItem().toString() == "O" && cb5.getSelectedItem().toString() == "O" && cb8.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb3.getSelectedItem().toString() == "X" && cb6.getSelectedItem().toString() == "X" && cb9.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb3.getSelectedItem().toString() == "O" && cb6.getSelectedItem().toString() == "O" && cb9.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb1.getSelectedItem().toString() == "X" && cb5.getSelectedItem().toString() == "X" && cb9.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb1.getSelectedItem().toString() == "O" && cb5.getSelectedItem().toString() == "O" && cb9.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
				if(cb3.getSelectedItem().toString() == "X" && cb5.getSelectedItem().toString() == "X" && cb7.getSelectedItem().toString() == "X") {
					txtVencedor.setText("X");
					pontos.setPontosJogador1(pontos.getPontosJogador1() + 1);
					txtPlacarX.setText(""+pontos.getPontosJogador1());
					return;
				} else if(cb3.getSelectedItem().toString() == "O" && cb5.getSelectedItem().toString() == "O" && cb7.getSelectedItem().toString() == "O") {
					txtVencedor.setText("O");
					pontos.setPontosJogador2(pontos.getPontosJogador2() + 1);
					txtPlacarY.setText(""+pontos.getPontosJogador2());
					return;
				}
				
			}
			
		});
		btaoJogar.setBounds(175, 197, 75, 25);
		frame.getContentPane().add(btaoJogar);
		
	
	}
}
