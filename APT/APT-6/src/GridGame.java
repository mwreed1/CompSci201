public class GridGame {
    private int winCount(char[][] board) {
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                board[r][c] = 'X';
                int opponentCount = winCount(board);
                if(opponentCount == 0){
                    count +=1;
                }
                board[r][c] = '.';
            }
        }
        return count;
    }
    public int winningMoves(String[] grid){
        char[][] board = new char[4][4];
        for(int i = 0; i < grid.length; i++){
            String line = grid[i];
            char[] newLine = line.toCharArray();
            for(int j = 0; j < newLine.length; j++) {
                board[i][j] = newLine[j];
            }
        }
        return winCount(board);
    }
}