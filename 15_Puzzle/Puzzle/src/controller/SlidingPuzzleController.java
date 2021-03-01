package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.SlidingPuzzleModel;
import view.SlidingPuzzleView;

public class SlidingPuzzleController {

	private SlidingPuzzleView view;

	private SlidingPuzzleModel model;
/**
 * Controlerul
 * @param view Interfata grafica a jocului
 * @param model Modelul Jocului
 */
	public SlidingPuzzleController(SlidingPuzzleView view, SlidingPuzzleModel model) {

		this.view = view;

		this.model = model;

		view.setNumbers(model.getNumberList(), model.getDimension());

		view.setAction(new SlidingButtonListener(), model.getDimension());

		model.setEmptyCell(indexOf(Integer.toString(0)));

	}
/**
 * Ne da indexul valorii corespunzatoare coloanei si liniei butonului
 * @param i linia
 * @param j coloana
 * @return indexul corespunzator liniei si coloanei
 */
	private int getIndex(int i, int j) {

		return (i * model.getDimension() + j);

	}
/**
 * Ne da indexul procesand textul pe buton
 * @param matrixIndex numarul butonului
 * @return indexul butonului
 */
	private int indexOf(String matrixIndex) {

		for (int i = 0; i < model.getDimension(); i++) {

			for (int j = 0; j < model.getDimension(); j++) {

				if (view.getButtonMatrix()[i][j].getText().equals(matrixIndex)) {

					return (getIndex(i, j));
				}
			}
		}
		return -1;

	}
/**
 * Muta butonul cu care se interactioneaza
 * @author valen
 *
 */
	public class SlidingButtonListener implements ActionListener {

		@Override

		public void actionPerformed(ActionEvent e) throws IllegalArgumentException {

			JButton buttonPressed = (JButton) e.getSource();

			int index = indexOf(buttonPressed.getText());

			System.out.println(index);

			if (index == -1) {

				throw (new IllegalArgumentException("Eroare"));
			}
			int row = index / model.getDimension();

			int col = index % model.getDimension();

			makeMove(row, col);

			if (isFinished()) {
				JOptionPane.showMessageDialog(null, "You Win The Game");
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				
				dialogButton = JOptionPane.showConfirmDialog(null, "Try again? ",null,dialogButton);
				
				if (dialogButton == JOptionPane.NO_OPTION) {
					view.dispose();
					System.exit(0);
				} else if (dialogButton == JOptionPane.YES_OPTION) {
					SlidingPuzzleModel puzzleModel = new SlidingPuzzleModel();

					SlidingPuzzleView puzzleView = new SlidingPuzzleView(puzzleModel.getDimension(), puzzleModel.getSize());

					new SlidingPuzzleController(puzzleView, puzzleModel);

					puzzleView.setVisible(true);;
				}

			}

		}
/**
 * Verifica daca un buton poate fi mutat in zona libera
 * @param row indexul liniei
 * @param col indexul coloane
 * @return true, daca am apasat pe un buton care poate fi mutat in zona goala a tablei
 */
		private boolean makeMove(int row, int col) {

			int emptyRow = model.getEmptyCell() / model.getDimension();

			int emptyCol = model.getEmptyCell() % model.getDimension();

			int rowDiff = emptyRow - row;

			int colDiff = emptyCol - col;

			boolean isInRow;

			boolean isInCol;

			boolean isNotDiagonal;

			if (row == emptyRow)
				isInRow = true;
			else
				isInRow = false;
			if (col == emptyCol)
				isInCol = true;
			else
				isInCol = false;

			if (isInRow || isInCol)
				isNotDiagonal = true;
			else
				isNotDiagonal = false;

			if (isNotDiagonal) {
				int diff = Math.abs(colDiff);
				if (colDiff < 0 & isInRow) {
					for (int i = 0; i < diff; i++)
						view.getButtonMatrix()[emptyRow][emptyCol + i]
								.setText(view.getButtonMatrix()[emptyRow][emptyCol + (i + 1)].getText());
				} else if (colDiff > 0 & isInRow) {
					for (int i = 0; i < diff; i++)
						view.getButtonMatrix()[emptyRow][emptyCol - i]
								.setText(view.getButtonMatrix()[emptyRow][emptyCol - (i + 1)].getText());
				}
				diff = Math.abs(rowDiff);
				if (rowDiff < 0 & isInCol) {
					for (int i = 0; i < diff; i++)
						view.getButtonMatrix()[emptyRow + i][emptyCol]
								.setText(view.getButtonMatrix()[emptyRow + (i + 1)][emptyCol].getText());
				} else if (rowDiff > 0 & isInCol) {
					for (int i = 0; i < diff; i++)
						view.getButtonMatrix()[emptyRow - i][emptyCol]
								.setText(view.getButtonMatrix()[emptyRow - (i + 1)][emptyCol].getText());
				}
				view.getButtonMatrix()[emptyRow][emptyCol].setVisible(true);
				view.getButtonMatrix()[row][col].setText(Integer.toString(0));
				view.getButtonMatrix()[row][col].setVisible(false);
				model.setEmptyCell(getIndex(row, col));
			}
			return true;
		}
/**
 * Verifica daca jocul este terminat
 * @return true daca butoanele sunt puse in ordinea corecta
 */
		public boolean isFinished() {
			for (int i = model.getWinArray().length - 1; i > 0; i--) {
				String number = view.getButtonMatrix()[i / model.getDimension()][i % model.getDimension()].getText();
				if (!number.equals(model.getWinArray()[i])) {
					return false;
				}
			}
			return true;
		}
	}
}