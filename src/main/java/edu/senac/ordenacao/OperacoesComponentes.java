package edu.senac.ordenacao;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OperacoesComponentes {
	
	private JPanel jPanels[] = new JPanel[Ordernacao.TAMANHO_VETOR];
	private JLabel jLabels[] = new JLabel[Ordernacao.TAMANHO_VETOR];
	
	private JPanel contentPane = null;
	
	public void removerComponentes() {
		for (JPanel jPanel : jPanels)
			if (jPanel != null)
				contentPane.remove(jPanel);
		
		for (JLabel jLabel : jLabels)
			if (jLabel != null)
				contentPane.remove(jLabel);				
	}
	
	public void mostrarOrdenacao(Integer valores[]) {
		int posicaoInicial = 55;
		int posicaoIncremento = 36;
		
		for (int i=0;i<=valores.length-1;i++) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLUE);
			panel.setBounds(posicaoInicial, 
					127 - (valores[i] * 10), 
					26, 
					(56 + (valores[i] * 10)));
			contentPane.add(panel);
			jPanels[i] = panel;
			
			JLabel label = new JLabel(valores[i] + "");
			label.setBounds(posicaoInicial, 190, 26, 14);
			contentPane.add(label);
			jLabels[i] = label;
			
			posicaoInicial += posicaoIncremento;
		}
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

}
