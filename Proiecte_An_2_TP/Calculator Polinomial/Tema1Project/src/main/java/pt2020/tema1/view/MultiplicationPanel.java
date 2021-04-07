package pt2020.tema1.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiplicationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel polinom1;
	private JLabel polinom2;
	private JLabel mulLabel;
	private JTextField polinom1TextField;
	private JTextField polinom2TextField;
	private JTextField mulTextField;
	private JButton mulButton;
	private JButton backButton;
	private JButton resetButton;

	public MultiplicationPanel() {
		setLayout(new FlowLayout());
		polinom1 = new JLabel("Polinom P");
		add(polinom1);
		polinom1TextField = new JTextField(10);
		add(polinom1TextField);
		mulButton = new JButton("*");
		add(mulButton);
		polinom2 = new JLabel("Polinom Q");
		add(polinom2);
		polinom2TextField = new JTextField(10);
		add(polinom2TextField);
		mulLabel = new JLabel("=");
		add(mulLabel);
		mulTextField = new JTextField(30);
		add(mulTextField);
		resetButton = new JButton("Reset");
		add(resetButton);
		backButton = new JButton("Back");
		add(backButton);
		setVisible(true);

	}

	public void addMulButtonAction(ActionListener l) {
		mulButton.addActionListener(l);
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
		 polinom1TextField.setText(s);
	}

	public void setPolinom2TextField(String s) {
		 polinom2TextField.setText(s);;
	}
	public JTextField getPolinom2TextField() {
		return polinom2TextField;
	}


	public JTextField getMulTextField() {
		return mulTextField;
	}
	public void setMulTextField(String s) {
		 mulTextField.setText(s);
	}
}