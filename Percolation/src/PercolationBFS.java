import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }
    @Override
    protected void dfs(int row, int col){
        if (! inBounds(row,col)) return;
        if (isFull(row, col) || !isOpen(row, col)) return;
        int size = myGrid.length;

        Queue<Integer> qp = new LinkedList<>();
        myGrid[row][col] = FULL;
        qp.add(row*size + col);
        while(qp.size() != 0){
            int rem = qp.remove();
            row = rem/size;
            col = rem % size;
            if(inBounds(row -1, col) && isOpen(row -1, col) && !isFull(row -1, col)){
                myGrid[row-1][col] = FULL;
                qp.add((row-1)*size+col);
            }
            if(inBounds(row +1, col) && isOpen(row +1, col) && !isFull(row +1, col)){
                myGrid[row+1][col] = FULL;
                qp.add((row+1)*size+col);
            }
            if(inBounds(row, col-1) && isOpen(row , col-1) && !isFull(row , col-1)){
                myGrid[row][col-1] = FULL;
                qp.add((row)*size+(col-1));
            }
            if(inBounds(row, col+1) && isOpen(row , col+1) && !isFull(row , col+1)){
                myGrid[row][col+1] = FULL;
                qp.add((row)*size+(col+1));
            }
        }
    }
}
