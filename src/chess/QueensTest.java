package chess;

public class QueensTest {
	public static void main(String [] args){
		test();
		test2();
	}
	
	public static void test(){
		Queens chess = new Queens();		
		int row = 1;
		System.out.println("Testing the Queens Program while placing a Queen in Column 1\n "
				+ "while varying the initial Row placement");
		
		while(row <= chess.BOARD_SIZE){
			System.out.println("\nPlacing Queen in Row "+ row + " Column 1");
			chess.clearBoard();
			chess.startQueen(row, 1);
			chess.placeQueens(2);
			chess.displayBoard();
			System.out.println("Number of BackTracks: " + chess.backTracks);
			System.out.println("Number of Calls to isUnderAttack: " + chess.isUnderAttack);
			System.out.println("Number of Calls to placeQueens: " + chess.placeQueens);
			chess.backTracks = 0;
			chess.isUnderAttack = 0;
			chess.placeQueens = 0;
			row ++;
		}
	}
	
	public static void test2(){
		SuperQueens chess = new SuperQueens();
		chess.clearBoard();
		int row = 1;
		System.out.println("Testing the SuperQueens Program while placing a Queen in Column 1\n "
				+ "while varying the initial Row placement");
		
		while(row <= chess.BOARD_SIZE){
			System.out.println("\nPlacing Queen in Row "+ row + " Column 1");
			chess.clearBoard();
			chess.startQueen(row - 1);
			chess.placeQueens(2);
			chess.displayBoard();
			System.out.println("Number of BackTracks: " + chess.backTracks);
			System.out.println("Number of Calls to isUnderAttack: " + chess.isUnderAttack);
			System.out.println("Number of Calls to placeQueens: " + chess.placeQueens);
			chess.backTracks = 0;
			chess.isUnderAttack = 0;
			chess.placeQueens = 0;
			row ++;
		}
	}
}


