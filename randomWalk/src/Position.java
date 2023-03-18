public class Position {
    public int row;
    public int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }

    @Override
    public boolean equals(Object obj) {
        boolean status=false;
        if(obj instanceof Position other) {
            status= (other.row==this.row) && (other.col==this.col);
        }
        return status;
    }
}
