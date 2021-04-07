package pt2020.tema1.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindValuePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel polinom1;
	private JLabel valueLabel;
	private JTextField polinom1TextField;
	private JTextField valueTextField;
	private JTextField resultTextField;
	private JButton valueButton;
	private JButton backButton;
	private JButton resetButton;

	public FindValuePanel() {
		setLayout(new FlowLayout());
		polinom1 = new JLabel("Polinom P");
		add(polinom1);
		polinom1TextField = new JTextField(10);
		add(polinom1TextField);
		valueButton = new JButton("Find Value in point");
		add(valueButton);
		valueTextField = new JTextField(2);
		add(valueTextField);

		valueLabel = new JLabel("=");
		add(valueLabel);
		resultTextField = new JTextField(10);
		add(resultTextField);
		resetButton = new JButton("Reset");
		add(resetButton);
		backButton = new JButton("Back");
		add(backButton);
		setVisible(true);

	}

	public void addFindValueButtonAction(ActionListener l) {
		valueButton.addActionListener(l);
	}
	public void addResetButtonAction(ActionListener l) {
		resetButton.addActionListener(l);
	}

	public void addBackButtonAction(ActionListener l) {
		backButton.addActionListener(l);
	}

	public JTextField getPolinom1TextField() {
		return polinom1TextField;
	}
	public void setPolinom1TextField(String s) {
		 polinom1TextField.setText(s);;
	}
	
	public JTextField getValueTextField() {
		return valueTextField;
	}
	public void setValueextField(String s) {
		 valueTextField.setText(s);
	}

	public void setFindValueTextField(int s) {
		 resultTextField.setText(Integer.toString(s));;
	}
}
