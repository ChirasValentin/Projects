package pt2020.tema1.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DerivativePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel polinom;
	private JLabel derivativeLabel;
	private JTextField polinomTextField;
	private JTextField derivativeTextField;
	private JButton derivativeButton;
	private JButton backButton;
	private JButton resetButton;

	public DerivativePanel() {
		setLayout(new FlowLayout());
		polinom = new JLabel("Polinom P");
		add(polinom);
		polinomTextField = new JTextField(20);
		add(polinomTextField);
		derivativeButton = new JButton("Derivate");
		add(derivativeButton);
		derivativeLabel = new JLabel("=");
		add(derivativeLabel);
		derivativeTextField = new JTextField(20);
		add(derivativeTextField);
		resetButton = new JButton("Reset");
		add(resetButton);
		backButton = new JButton("Back");
		add(backButton);
		setVisible(true);

	}

	public void addDerivativeButtonAction(ActionListener l) {
		derivativeButton.addActionListener(l);
	}

	public void addBackButtonAction(ActionListener l) {
		backButton.addActionListener(l);
	}
	public void addResetButtonAction(ActionListener l) {
		resetButton.addActionListener(l);
	}

	public JTextField getPolinomTextField() {
		return polinomTextField;
	}
	public void setPolinomTextField(String s) {
		 polinomTextField.setText(s);;
	}


	public JTextField getDerivativeTextField() {
		return derivativeTextField;
	}
	public void setDerivativeTextField(String s) {
		 derivativeTextField.setText(s);
	}
}