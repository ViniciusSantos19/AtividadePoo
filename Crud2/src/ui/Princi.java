package ui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import connectDb.DAOpostgres;
import negocio.Agenda;
import negocio.Aluno;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.awt.event.ActionEvent;

public class Princi {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtProva1;
	private JTextField txtProva2;
	private JTextField txtProva3;
	private Agenda agenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Princi window = new Princi();
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
	public Princi() {
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
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(12, 45, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prova1:");
		lblNewLabel_1.setBounds(12, 90, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prova2:");
		lblNewLabel_2.setBounds(12, 135, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Trabalho:");
		lblNewLabel_3.setBounds(12, 190, 70, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(84, 43, 143, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtProva1 = new JTextField();
		txtProva1.setBounds(84, 88, 93, 19);
		frame.getContentPane().add(txtProva1);
		txtProva1.setColumns(10);
		
		txtProva2 = new JTextField();
		txtProva2.setBounds(84, 133, 93, 19);
		frame.getContentPane().add(txtProva2);
		txtProva2.setColumns(10);
		
		txtProva3 = new JTextField();
		txtProva3.setBounds(84, 188, 93, 19);
		frame.getContentPane().add(txtProva3);
		txtProva3.setColumns(10);
		
		agenda = new Agenda();
		
		final JButton btnInsert = new JButton("Adicionar");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnInsert) {
					
					try {
						agenda.addAluno(new Aluno(txtNome.getText(), Double.parseDouble(txtProva1.getText()), Double.parseDouble(txtProva2.getText()), Double.parseDouble(txtProva3.getText())));
						JOptionPane.showMessageDialog(btnInsert, "Sucessso ao inserir no banco de dados");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(btnInsert, "Erro ao inserir no banco de dados");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(btnInsert, "Erro ao inserir no banco de dados");
						e1.printStackTrace();
					}
				}
			}
		});
		btnInsert.setBounds(44, 231, 117, 25);
		frame.getContentPane().add(btnInsert);
		
		final JButton btnSelect = new JButton("Listar");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSelect) {
					try {
						File file = new File("/home/viniciusr/git/AtividadePoo/Crud2/src/ui/Notas.txt");
						FileWriter fw = new FileWriter(file);
						PrintWriter pw = new PrintWriter(fw);
						try {
							List<Aluno> lista = agenda.getListaMedias();
							pw.println("Médias");
							for(int i = 0; i < lista.size(); i++) {
								if(lista.get(i).getMedia() >= 5) {
									pw.println("---------------");
									pw.println("Aprovado");
									pw.println(lista.get(i).getNome());
									pw.println(lista.get(i).getMedia());
									pw.println("---------------");
									pw.println("\n");
								}else {
									pw.println("---------------");
									pw.println("Reprovado");
									pw.println(lista.get(i).getNome());
									pw.println(lista.get(i).getMedia());
									pw.println("---------------");
									pw.println("\n");
								}
							}
							lista = agenda.getListaAluno();
							pw.println("Dados");
							for(int j = 0; j < lista.size(); j++) {
								pw.println("---------------");
								pw.println(lista.get(j).getNome());
								pw.println(lista.get(j).getProva1());
								pw.println(lista.get(j).getProva2());
								pw.println(lista.get(j).getTrabalho());
								pw.println("---------------");
								pw.println("\n");
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						pw.close();
					} catch (IOException e1) {
						try {
							JOptionPane.showMessageDialog(btnSelect, agenda.getMedia("Vini"));
						} catch (HeadlessException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}
				}
			}
		});
		btnSelect.setBounds(282, 231, 117, 25);
		frame.getContentPane().add(btnSelect);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnDelete) {
					String nome = JOptionPane.showInputDialog("Digite o nome do aluno que você gostaria de deletar");
					try {
						agenda.deleteAluno(nome);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setBounds(282, 130, 117, 25);
		frame.getContentPane().add(btnDelete);
	}
}
