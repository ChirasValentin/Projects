package pt2020.tema1.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PolynomFrame {

	MainFrame frame = new MainFrame();
	private JButton addition = new JButton("Addition Polynoms");
	private JButton substract = new JButton("Substract Polynoms");
	private JButton multiply = new JButton("Multiply Polynoms");
	private JButton derivative = new JButton("Derivative Polynom");
	private JButton findValue = new JButton("Find Value");
	private AdditionPanel additionPanel;
	private SubstractPanel substractionPanel;
	private DerivativePanel derivativePanel;
	private MultiplicationPanel multiplicationPanel;
	private FindValuePanel findValuePanel;
	private JLabel TextLabel= new JLabel("Polinoamele trebuie sa fiu de forma anx^bn+...+a1x^1+a0x^0");
	public PolynomFrame() {

	}

	public void showPolynomFrame() {
		frame.setTitle("Polynomial Calculator");
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.setLayout(new FlowLayout());
		frame.add(addition);
		frame.add(substract);
		frame.add(derivative);
		frame.add(multiply);
		frame.add(findValue);
		TextLabel.setFont(new Font("BOSKO", Font.BOLD, 12));
		TextLabel.setForeground(Color.red);
		frame.add(TextLabel);
		JLabel image= new JLabel();
		image.setIcon(new ImageIcon("C://Users//valen//Documents//pt2020_30223_chiras_valentin-fanica_assignment_1//Tema1Project//mathematics.jpg"));
		frame.add(image);
		frame.setBounds(400, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void showAdditionPanel() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.setTitle("Addition");
		additionPanel = new AdditionPanel();
		frame.add(additionPanel);
		frame.pack();
	}

	public void showSubstractionPanel() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.setTitle("Substract");
		substractionPanel = new SubstractPanel();
		frame.add(substractionPanel);
		frame.pack();
	}

	public void showDerivativePanel() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.setTitle("Derivative");
		derivativePanel = new DerivativePanel();
		frame.add(derivativePanel);
		frame.pack();
	}
	public void showMultimplicationPanel() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.setTitle("Multiplication");
		multiplicationPanel = new MultiplicationPanel();
		frame.add(multiplicationPanel);
		frame.pack();
	}
	public void showFindValuePanel() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.setTitle("FindValue");
		findValuePanel = new FindValuePanel();
		frame.add(findValuePanel);
		frame.pack();
	}

	public MainFrame getMainFrame() {
		return frame;
	}

	public PolynomFrame getPolynomFrame() {
		return this;
	}

	public AdditionPanel getAdditionPanel() {
		return additionPanel;
	}
	public DerivativePanel getDerivativePanel() {
		return derivativePanel;
	}

	public SubstractPanel getSubstractionPanel() {
		return substractionPanel;
	}
	public MultiplicationPanel getMultiplicationPanel() {
		return multiplicationPanel;
	}
	public FindValuePanel getFindValuePanel() {
		return findValuePanel;
	}


	public void addAdditionButtonAction(ActionListener l) {
		addition.addActionListener(l);
	}

	public void addSubstractionButtonAction(ActionListener l) {
		substract.addActionListener(l);
	}
	public void addDerivativeButtonAction(ActionListener l) {
		derivative.addActionListener(l);
	}
	public void addMultiplicationButtonAction(ActionListener l) {
		multiply.addActionListener(l);
	}
	public void addFindValueButtonAction(ActionListener l) {
		findValue.addActionListener(l);
	}
}
