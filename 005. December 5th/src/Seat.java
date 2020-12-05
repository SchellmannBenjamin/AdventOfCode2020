public class Seat {
    int row;
    int column;
    int seatID;

    public Seat(){
        this.row = -1;
        this.column = -1;
        this.seatID = -1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getSeatID() {
        return row*8+column;
    }

  /*  public boolean isValid(){
        if(this.row!=-1&&this.column!=-1)return true;
        return false;
    }*/

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", seatID=" + seatID +
                '}';
    }
}
