package chess;

public class SuperQueens {
	
	// squares per row or column
	public static final int BOARD_SIZE = 8;

	// used to indicate an empty square
	public static final int EMPTY = -1;

	// used to indicate square contains a queen
	public static final int QUEEN = 1;
	private int col[]; // chess board
	private int rowAttack[];
	private int posDiagonal[];
	private int negDiagonal[];
	public int backTracks = 0;
	public int isUnderAttack = 0;
	public int placeQueens = 0;

	public SuperQueens() {
		// -------------------------------------------------
		// Constructor: Creates an empty square board.
		// -------------------------------------------------
		col = new int[BOARD_SIZE];
		rowAttack = new int[BOARD_SIZE];
		posDiagonal = new int[BOARD_SIZE];
		negDiagonal = new int[BOARD_SIZE];
	} // end constructor
	
	public void startQueen(int i){
		col[0] = i;
	}

	public void clearBoard() {
		// -------------------------------------------------
		// Clears the board.
		// Precondition: None.
		// Postcondition: Sets all squares to EMPTY.
		// -------------------------------------------------
		// To be implemented for Homework 5
		// end clearBoard
		int column = 0;
		while(column < BOARD_SIZE){			
			col[column] = EMPTY;
			column ++;			
		}
	} 

	public void displayBoard() {
		// -------------------------------------------------
		// Displays the board.
		// Precondition: None.
		// Postcondition: Board is displayed as follows
		// with a blank indicating an EMPTY square, and a Q 
		// is a square containing a queen.
		// 
		// +---+---+---+---+---+---+---+---+
		// | Q |   |   |   |   |   |   |   |
		// +---+---+---+---+---+---+---+---+
		// |   |   |   |   |   |   | Q |   |
		// +---+---+---+---+---+---+---+---+
		// |   |   |   |   | Q |   |   |   |
		// +---+---+---+---+---+---+---+---+
		// |   |   |   |   |   |   |   | Q |
		// +---+---+---+---+---+---+---+---+
		// |   | Q |   |   |   |   |   |   |
		// +---+---+---+---+---+---+---+---+
		// |   |   |   | Q |   |   |   |   |
		// +---+---+---+---+---+---+---+---+
		// |   |   |   |   |   | Q |   |   |
		// +---+---+---+---+---+---+---+---+
		// |   |   | Q |   |   |   |   |   |
		// +---+---+---+---+---+---+---+---+
		// 
		// -------------------------------------------------
		// To be implemented for Homework 5
		int row = 0, collumn = 0;
		while( row < ((BOARD_SIZE * 2) + 1)){
			collumn = 0;
			while(collumn < ((BOARD_SIZE * 2) + 1)){
				if( row % 2 == 0){
					if(collumn % 2 == 0){
						System.out.print("+");
					}else{
						System.out.print("---");
					}
				}else{
					if(collumn % 2 == 0){
						System.out.print("|");
					}else{
						if(col[(collumn - 1)/2] == (row - 1)/2){
							System.out.print(" Q ");
						}else{
							System.out.print("   ");
						}						
					}
				}				
				collumn ++;
			}
			System.out.println("");
			row ++;
		}
	} // end displayBoard

	public boolean placeQueens(int column) {
		// -------------------------------------------------
		// Places queens in columns of the board beginning
		// at the column specified.
		// Precondition: Queens are placed correctly in
		// columns 1 through column-1.
		// Postcondition: If a solution is found, each
		// column of the board contains one queen and method
		// returns true; otherwise, returns false (no
		// solution exists for a queen anywhere in column
		// specified).
		// -------------------------------------------------
		placeQueens ++;
		if (column > BOARD_SIZE) {
			return true; // base case
		} else {
			boolean queenPlaced = false;
			int row = 1; // number of square in column
			while (!queenPlaced && (row <= BOARD_SIZE)) {
				// if square can be attacked
				if (isUnderAttack(row, column)) {
					++row; // consider next square in column
				} // end if
				else { // place queen and consider next column
					setQueen(row, column);
					queenPlaced = placeQueens(column + 1);
					// if no queen is possible in next column,
					if (!queenPlaced) {
						// backtrack: remove queen placed earlier
						// and try next square in column
						backTracks ++;
						removeQueen(row, column);
						++row;
					} // end if
				} // end if
			} // end while
			return queenPlaced;
		} // end if
	} // end placeQueens

	private void setQueen(int row, int column) {
		// --------------------------------------------------
		// Sets a queen at square indicated by row and
		// column.
		// Precondition: None.
		// Postcondition: Sets the square on the board in a
		// given row and column to QUEEN.
		// --------------------------------------------------
		// To be implemented for Homework 5
		col[column - 1] = row - 1;
	} // end setQueen

	private void removeQueen(int row, int column) {
		// --------------------------------------------------
		// Removes a queen at square indicated by row and
		// column.
		// Precondition: None.
		// Postcondition: Sets the square on the board in a
		// given row and column to EMPTY.
		// --------------------------------------------------
		// To be implemented for Homework 5
		col[column - 1] = EMPTY;
	} // end removeQueen

	private boolean isUnderAttack(int row, int column) {
		// --------------------------------------------------
		// Determines whether the square on the board at a
		// given row and column is under attack by any queens
		// in the columns to the right or left of the given collumn
		// Precondition: Each column between 1 and column-1
		// has a queen placed in a square at a specific row.
		// None of these queens can be attacked by any other
		// queen.
		// Postcondition: If the designated square is under
		// attack, returns true; otherwise, returns false.
		// --------------------------------------------------
		// To be implemented for Homework 5
		isUnderAttack ++;
		for (int j = 0; j < column - 1; j ++){
			if(col[j] == (row - 1)){
				rowAttack[j] = QUEEN;
				return true;
			}
		}
		
		for( int j = 0; j < column - 1; j++){
			if((j - (column - 1)) == ((row - 1) - col[j])){
				posDiagonal[j] = QUEEN;
				return true;
			}
		}
		
		for( int j = 0; j < column - 1; j++){
			if((j - (column - 1)) == (col[j] - (row - 1))){
				negDiagonal[j] = QUEEN;
				return true;
			}
		}
		return false;
	} // end isUnderAttack

	private int index(int number) {
		// --------------------------------------------------
		// Returns the array index that corresponds to
		// a row or column number.
		// Precondition: 1 <= number <= BOARD_SIZE.
		// Postcondition: Returns adjusted index value.
		// --------------------------------------------------
		// To be implemented for Homework 5
		return (number - 1);
	} // end index
} // end Queens
