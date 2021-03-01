package controller;

import model.SlidingPuzzleModel;
import view.SlidingPuzzleView;

public class SlidingPuzzleMain {



 /** 
  * Main-ul jocului
  * @param args
  */
	public static void main(String[] args) {
	
		SlidingPuzzleModel puzzleModel = new SlidingPuzzleModel();

		SlidingPuzzleView puzzleView = new SlidingPuzzleView(puzzleModel.getDimension(), puzzleModel.getSize());

		new SlidingPuzzleController(puzzleView, puzzleModel);

		puzzleView.setVisible(true);

	}



}
