package view;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JFrame;

import model.RoundedBorder;

public class SlidingPuzzleView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton[][] buttonMatrix;

	/**
	 * Creaza panoul  jocului
	 * @param DIM numarul de butoane pe un rand 
	 * @param SIZE numarul total de butoane de pe tabla 
	 */
	public SlidingPuzzleView(int DIM, int SIZE) {

		this.setTitle("Sliding puzzle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(650, 650));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.buttonMatrix = new JButton[DIM][DIM];
		this.setLayout(new GridLayout(DIM, DIM));
		for (int i = 0; i < SIZE; i++) {
			int row = i / DIM;
			int column = i % DIM;
			buttonMatrix[row][column] = new JButton();
			buttonMatrix[row][column].setBounds(row, column, 30, 25);
			buttonMatrix[row][column].setBorder(new RoundedBorder(10));
			buttonMatrix[row][column].setForeground(Color.white);
			buttonMatrix[row][column].setBackground(new Color(228, 54, 0));
			buttonMatrix[row][column].setFont(new Font("Arial", Font.BOLD, 60));
			this.add(buttonMatrix[row][column]);
		}
	}
	/**
	 * 
	 * @return Matricea de butoane
	 */

	public JButton[][] getButtonMatrix() {
		return this.buttonMatrix;
	}
	/**
	 * Pune pe butoane numerele din lista "numberList"
	 * @param numberList lista de numere care controleaza jocul
	 * @param DIM numarul de butoane de pe un rand
	 */
	public void setNumbers(ArrayList<Integer> numberList, int DIM) {
		for (int i = 0; i < numberList.size(); i++) {
			final int row = i / DIM;
			final int col = i % DIM;
			if (numberList.get(i) == 0) {
				this.buttonMatrix[row][col].setVisible(false);
			}

			this.buttonMatrix[row][col].setText(String.valueOf(numberList.get(i)));
		}
	}
	/**
	 * creaza evenimente
	 * @param l evenimentul care modifica interfata dupa un click
	 * @param DIM numarul de butoane care vor fi actionate la un click
	 */
	public void setAction(ActionListener l, int DIM) {
		for (int i = 0; i < DIM; i++)
			for (int j = 0; j < DIM; j++)
				this.buttonMatrix[i][j].addActionListener(l);
	}
}