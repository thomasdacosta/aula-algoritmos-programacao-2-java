package edu.senac.aula06;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class OrdenacaoFrame extends JFrame {
	
	private static final Integer TAMANHO_VETOR = 20;

	private static final long serialVersionUID = -3234138620479184569L;

	private JPanel contentPane;

	private JPanel jPanels[] = new JPanel[TAMANHO_VETOR];
	private JLabel jLabels[] = new JLabel[TAMANHO_VETOR];

	private JRadioButton rdbtnBubbleSort;
	private JRadioButton rdbtnSelectionSort;
	private JRadioButton rdbtnInsertionSort;

	private JButton btnGerarValores;
	private JButton btnOrdenar;

	private JLabel lblStatus;
	
	private Ordenacao ordernacao = new Ordenacao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenacaoFrame frame = new OrdenacaoFrame();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	public OrdenacaoFrame() {
		criarComponentePrincipal();
		criarComponentes();
		criarBotaoOrdenar();
		criarBotaoGerarValores();

		Integer[] valores = gerarVetor();
		ordernacao.setValores(valores);
		mostrarOrdenacao(valores);
	}
	
	private void removerComponentes() {
		for (JPanel jPanel : jPanels)
			if (jPanel != null)
				contentPane.remove(jPanel);
		
		for (JLabel jLabel : jLabels)
			if (jLabel != null)
				contentPane.remove(jLabel);				
	}
	
	private void mostrarOrdenacao(Integer valores[]) {
		int posicaoInicial = 55;
		int posicaoIncremento = 36;
		
		for (int i=0;i<=valores.length-1;i++) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLUE);
			panel.setBounds(posicaoInicial, 
					227 - (valores[i] * 10), 
					26, 
					(56 + (valores[i] * 10)));
			contentPane.add(panel);
			jPanels[i] = panel;
			
			JLabel label = new JLabel(valores[i] + "");
			label.setBounds(posicaoInicial, 290, 26, 14);
			contentPane.add(label);
			jLabels[i] = label;
			
			posicaoInicial += posicaoIncremento;
		}
	}
	
	private void criarComponentePrincipal() {
		setTitle("Algortimos de Ordena\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 412);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
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
								removerComponentes();
								mostrarOrdenacao(ordernacao.getValores());
								
								contentPane.revalidate();
								contentPane.repaint();
								
								try {
									Thread.sleep(250);
								} catch (InterruptedException ex) {
									ex.printStackTrace();
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
						
						lblStatus.setText("Ordena��o conclu�da com sucesso.");
					}
				});
				thread.start();
			}
		});

		btnOrdenar.setBounds(863, 339, 89, 23);
		contentPane.add(btnOrdenar);
	}
	
	private Integer[] gerarVetor() {
		List<Integer> integers = new ArrayList<>();
		for (int i=0;i<TAMANHO_VETOR;i++)
			integers.add(i+1);
		
		Collections.shuffle(integers);
		return integers.toArray(new Integer[integers.size()]);
	}
	
	private void criarBotaoGerarValores() {
		btnGerarValores = new JButton("Gerar Valores");
		btnGerarValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setText("");
				removerComponentes();
				
				ordernacao.setValores(gerarVetor());
				mostrarOrdenacao(ordernacao.getValores());

				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		btnGerarValores.setBounds(733, 339, 122, 23);
		contentPane.add(btnGerarValores);
	}
	
	private void criarComponentes() {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(800, 71, 142, 192);
		panel.setLayout(null);
		contentPane.add(panel);

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
		lblStatus.setBounds(10, 350, 313, 14);
		contentPane.add(lblStatus);
	}
	
}
