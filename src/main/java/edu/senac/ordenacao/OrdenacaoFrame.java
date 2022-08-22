package edu.senac.ordenacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class OrdenacaoFrame extends JFrame {

	private static final long serialVersionUID = -3234138620479184569L;

	private JPanel contentPane;

	private Ordernacao ordernacao = new Ordernacao();
	private OperacoesComponentes componentes = new OperacoesComponentes();

	private JRadioButton rdbtnBubbleSort;
	private JRadioButton rdbtnSelectionSort;
	private JRadioButton rdbtnInsertionSort;

	private JButton btnGerarValores;
	private JButton btnOrdenar;

	private JLabel lblStatus;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenacaoFrame frame = new OrdenacaoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OrdenacaoFrame() {
		criarComponentePrincipal();
		criarComponentes();
		criarBotaoOrdenar();
		criarBotaoGerarValores();

		ordernacao.gerarValoresVetor();
		componentes.mostrarOrdenacao(ordernacao.getValores());
	}
	
	private void criarComponentePrincipal() {
		setTitle("Algortimos de Ordena\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		componentes.setContentPane(contentPane);
	}
	
	private void criarBotaoOrdenar() {
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("Ordernando. Aguarde...");
				btnOrdenar.setEnabled(false);
				btnGerarValores.setEnabled(false);
				rdbtnBubbleSort.setEnabled(false);
				rdbtnInsertionSort.setEnabled(false);
				rdbtnSelectionSort.setEnabled(false);
				
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						ordernacao.setListener(new OrdenacaoListener() {

							@Override
							public void onExecution(Integer[] valores) {
								componentes.removerComponentes();
								componentes.mostrarOrdenacao(ordernacao.getValores());
								contentPane.revalidate();
								contentPane.repaint();
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});

						if (rdbtnBubbleSort.isSelected())
							ordernacao.bubbleSort();
						
						if (rdbtnInsertionSort.isSelected())
							ordernacao.insertionSort();
						
						if (rdbtnSelectionSort.isSelected())
							ordernacao.selectionSort();
						
						btnOrdenar.setEnabled(true);
						btnGerarValores.setEnabled(true);
						rdbtnBubbleSort.setEnabled(true);
						rdbtnInsertionSort.setEnabled(true);
						rdbtnSelectionSort.setEnabled(true);
						lblStatus.setText("Ordenação concluída com sucesso.");
					}
				});
				thread.start();
			}
		});

		btnOrdenar.setBounds(463, 239, 89, 23);
		contentPane.add(btnOrdenar);
	}
	
	private void criarBotaoGerarValores() {
		btnGerarValores = new JButton("Gerar Valores");
		btnGerarValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("");
				componentes.removerComponentes();
				ordernacao.gerarValoresVetor();
				componentes.mostrarOrdenacao(ordernacao.getValores());
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		btnGerarValores.setBounds(333, 239, 122, 23);
		contentPane.add(btnGerarValores);
	}
	
	private void criarComponentes() {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(430, 11, 122, 192);
		contentPane.add(panel);
		panel.setLayout(null);

		rdbtnBubbleSort = new JRadioButton("Bubble Sort");
		rdbtnBubbleSort.setSelected(true);
		rdbtnBubbleSort.setBounds(6, 27, 109, 23);
		panel.add(rdbtnBubbleSort);

		rdbtnSelectionSort = new JRadioButton("Selection Sort");
		rdbtnSelectionSort.setBounds(6, 82, 109, 23);
		panel.add(rdbtnSelectionSort);

		rdbtnInsertionSort = new JRadioButton("Insertion Sort");
		rdbtnInsertionSort.setBounds(6, 139, 109, 23);
		panel.add(rdbtnInsertionSort);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnBubbleSort);
		buttonGroup.add(rdbtnSelectionSort);
		buttonGroup.add(rdbtnInsertionSort);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(10, 243, 313, 14);
		contentPane.add(lblStatus);
	}
}
