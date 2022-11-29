package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

import negocio.Acao;
import negocio.Advogado;
import negocio.Herdeiro;
import negocio.Propriedade;
import negocio.Testamento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela {

	private JFrame frame;
	private JTextField txtHerdeiro1;
	private JTextField txtHerdeiro2;
	private JTextField txtAdvogado;
	private JTextField txtValor;
	private Testamento testamento;

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
		frame.setBounds(100, 100, 490, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String opcoes[] = {"Acao","Propriedade"};
		String opecoes2[] = {"primeiro","segundo"};
		
		JLabel lblNewLabel = new JLabel("Herdeiro1:");
		lblNewLabel.setBounds(12, 25, 83, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Herdeiro2:");
		lblNewLabel_1.setBounds(12, 75, 83, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Advogado:");
		lblNewLabel_2.setBounds(12, 125, 83, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo;");
		lblNewLabel_3.setBounds(12, 200, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox(opcoes);
		comboBox.setBounds(100, 195, 122, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Valor:");
		lblNewLabel_4.setBounds(264, 200, 70, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(12, 267, 462, 160);
		frame.getContentPane().add(editorPane);
		
		txtHerdeiro1 = new JTextField();
		txtHerdeiro1.setBounds(100, 23, 114, 19);
		frame.getContentPane().add(txtHerdeiro1);
		txtHerdeiro1.setColumns(10);
		
		txtHerdeiro2 = new JTextField();
		txtHerdeiro2.setBounds(100, 73, 114, 19);
		frame.getContentPane().add(txtHerdeiro2);
		txtHerdeiro2.setColumns(10);
		
		txtAdvogado = new JTextField();
		txtAdvogado.setBounds(100, 123, 114, 19);
		frame.getContentPane().add(txtAdvogado);
		txtAdvogado.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(313, 198, 114, 19);
		frame.getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox(opecoes2);
		comboBox_1.setBounds(372, 147, 102, 24);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnResumo = new JButton("Registrar");
		btnResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnResumo) {
					if(txtValor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(btnResumo, "O campo de valor esta vazio!");
					} else {
						if(comboBox_1.getSelectedItem().toString().equalsIgnoreCase("primeiro")) {
							if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Acao")) {
								testamento.registrarBem("primeiro", new Acao(Double.parseDouble(txtValor.getText())));
							}else {
								testamento.registrarBem("primeiro", new Propriedade(Double.parseDouble(txtValor.getText())));
							}
						} else {
							if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Acao")) {
								testamento.registrarBem("segundo", new Acao(Double.parseDouble(txtValor.getText())));
							}else {
								testamento.registrarBem("segundo", new Propriedade(Double.parseDouble(txtValor.getText())));
							}
						}
						editorPane.setText(testamento.getRelatorio());
					}
				}
			}
		});
		btnResumo.setEnabled(false);
		btnResumo.setBounds(167, 231, 117, 25);
		frame.getContentPane().add(btnResumo);
		
		JButton btnCadastrar = new JButton("Iniciar testamento");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCadastrar) {
					if(txtHerdeiro1.getText().isEmpty() || txtHerdeiro2.getText().isEmpty() || txtAdvogado.getText().isEmpty()) {
						JOptionPane.showMessageDialog(btnCadastrar, "Um dos campos de cadastro esta vazio!");
						btnResumo.setEnabled(false);
					} else {
						testamento = new Testamento(new Advogado(txtAdvogado.getText()), new Herdeiro(txtHerdeiro1.getText()), new Herdeiro(txtHerdeiro2.getText()));
						btnResumo.setEnabled(true);
						JOptionPane.showMessageDialog(btnCadastrar, "Advogado, herdeiro1 e herdeiro2 cadastrados com sucesso!");
;					}
				}
			}
		});
		btnCadastrar.setBounds(264, 20, 164, 25);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_5 = new JLabel("Esc Herdeiro:");
		lblNewLabel_5.setBounds(264, 152, 124, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		
	}
}
