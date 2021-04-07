package pt2020.tema1.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdditionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel polinom1;
	private JLabel polinom2;
	private JLabel sumLabel;
	private JTextField polinom1TextField;
	private JTextField polinom2TextField;
	private JTextField sumTextField;
	private JButton sumButton;
	private JButton backButton;
	private JButton resetButton;


	public AdditionPanel() {
		setLayout(new FlowLayout());
	
		polinom1 = new JLabel("Polinom P");
		add(polinom1);
		polinom1TextField = new JTextField(10);
		add(polinom1TextField);
		sumButton = new JButton("+");
		add(sumButton);
		polinom2 = new JLabel("Polinom Q");
		add(polinom2);
		polinom2TextField = new JTextField(10);
		add(polinom2TextField);
		sumLabel = new JLabel("=");
		add(sumLabel);
		sumTextField = new JTextField(10);
		add(sumTextField);
		resetButton=new JButton("Reset");
		add(resetButton);
		backButton = new JButton("Back");
		add(backButton);
		
		setVisible(true);
		

	}

	public void addSumButtonAction(ActionListener l) {
		sumButton.addActionListener(l);
	}

	public void addBackButtonAction(ActionListener l) {
		backButton.addActionListener(l);
	}
	public void addResetButtonAction(ActionListener l) {
		resetButton.addActionListener(l);
	}

	public JTextField getPolinom1TextField() {
		return polinom1TextField;
	}
	public void setPolinom1TextField(String s) {
		polinom1TextField.setText(s);;
	}
	public void setPolinom2TextField(String s) {
		polinom2TextField.setText(s);;
	}

	public JTextField getPolinom2TextField() {
		return polinom2TextField;
	}

	public void setSumTextField(String s) {
		 sumTextField.setText(s);
	}
}
