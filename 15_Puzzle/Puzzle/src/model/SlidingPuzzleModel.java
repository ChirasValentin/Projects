package model;

import java.util.ArrayList;

import java.util.Collections;

public class SlidingPuzzleModel {

	private final int DIM = 4;

	private final int SIZE = DIM * DIM;

	final String[] WIN = new String[SIZE - 1];

	private int emptyCell = DIM * DIM;

	private ArrayList<Integer> initialList;
/**
 * Modelul jocului
 * Creaza o lista de butoane initiala care este amestecata 
 * si verifica daca poate fi rezolvata
 */
	public SlidingPuzzleModel() {

		for (int i = 1; i < SIZE; i++)

			WIN[i - 1] = Integer.toString(i);

		for (boolean isSolvable = false; isSolvable == false;) {

			initialList = new ArrayList<Integer>(SIZE);

			for (int i = 0; i < SIZE; i++) {

				initialList.add(i, i);

			}

			Collections.shuffle(initialList);

			isSolvable = isSolvable(initialList);

		}

	}
/**
 * Verifica astfel incat tabla initiala sa poate fi rezolvata
 * deoarece SlidingPuzzle poate fi rezolvata in jumatate din cazurile
 * tabelei initiale
 * @param numberList lista de butoane
 * @return true, daca poate fi rezolvata
 * 			false in caz contrar
 */
	private boolean isSolvable(ArrayList<Integer> numberList) {

		int inversionSum = 0;

		for (int i = 0; i < numberList.size(); i++) {

			if (numberList.get(i) == 0) {

				inversionSum += ((i / this.DIM) + 1);

				continue;

			}

			int count = 0;

			for (int j = i + 1; j < numberList.size(); j++) {

				if (numberList.get(j) == 0) {

					continue;

				} else if (numberList.get(i) > numberList.get(j)) {

					count++;

				}

			}

			inversionSum += count;

		}

		if (inversionSum % 2 == 0)

			return true;

		else

			return false;

	}
/**
 * 
 * @return Numarul de butoane de pe un rand
 */
	public int getDimension() {

		return this.DIM;

	}
/**
 * 
 * @return Numarul total de butoane
 */
	public int getSize() {

		return this.SIZE;

	}
/**
 * 
 * @return Matricea finala in care trebuie ajuns pentru a castiga
 */
	public String[] getWinArray() {

		return this.WIN;

	}
/**
 * 
 * @return Celula/Butonul gol
 */
	public int getEmptyCell() {

		return this.emptyCell;

	}
/**
 * 
 * @param pos
 */
	public void setEmptyCell(int pos) {

		this.emptyCell = pos;

	}
/**
 * 
 * @return Lista initiala a numerelor
 */
	public ArrayList<Integer> getNumberList() {

		return this.initialList;

	}

}