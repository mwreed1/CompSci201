public class PercolationUF implements IPercolate {
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size){
        myGrid = new boolean[size][size];
        finder.initialize(size*size +2);
        myFinder = finder;
        VTOP = size*size;
        VBOTTOM = size*size +1;
    }


    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if(myGrid[row][col]) return;
        int size = myGrid.length;
        myGrid[row][col] = true;
        myOpenCount ++;
        if(inBounds(row -1, col) && isOpen(row -1, col)) {
            myFinder.union(row*size + col, (row-1)*size + col);
        }
        if(inBounds(row +1, col) && isOpen(row +1, col)) {
            myFinder.union(row*size + col, (row+1)*size + col);
        }
        if(inBounds(row, col-1) && isOpen(row, col-1)) {
            myFinder.union(row*size + col, (row)*size + col-1);
        }
        if(inBounds(row, col+1) && isOpen(row, col+1)) {
            myFinder.union(row*size + col, row*size + col+1);
        }
        if(row == 0) myFinder.union(row*size+col, VTOP);
        if(row == size-1) myFinder.union(row*size+col, VBOTTOM);

    }

    @Override
    public boolean isOpen(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        int size = myGrid.length;
        return myFinder.connected(row*size+col, VTOP);
    }

    @Override
    public boolean percolates() {
        return myFinder.connected(VTOP,VBOTTOM);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    public boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }
}
