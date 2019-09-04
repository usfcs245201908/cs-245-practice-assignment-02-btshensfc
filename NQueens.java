public class NQueens {

	public int[][] board;
	public int num = 4;

	public NQueens(int size){ //generates board
		num = size;
		board = new int[num][num];

	}

	public boolean placeNQueens() throws Exception{
		if (num <= 0){
			throw new Exception("Size must be a number greater than 0");
		}

		return placeNCol(0);
	}


	public boolean placeNCol(int col){
		if (col >= num){
			return true;
		}
		for (int i = 0; i < num; i++){
			if (attackCheck(i, col)){
				board[i][col] = 1;
				if (placeNCol(col+1)){
					return true;
				} else {
					board[i][col] = 0;
				}
			}
		}

		return false;
	}

	//print console
	public static void printToConsole(int[][] board){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				if(board[i][j] == 1) { 
					System.out.println("Q\t");
				} else { System.out.println("-\t"); }

			}
			System.out.println();
		}
	}

	private boolean attackCheck(int row, int col){
		//check sides
		int i = 0;
		int j = 0;
		for (i = 0; i < col; i++){
			if (board[row][i] == 1) {
				return false;
			}
		}

		//check diagonal upper left
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--){ 
			if (board[i][j] == 1) {
				return false;
			}
		} 

		//check diagonal lower left
		for (i = row, j = col; j >= 0 && i < num; i++, j--){ 
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;

	}

}