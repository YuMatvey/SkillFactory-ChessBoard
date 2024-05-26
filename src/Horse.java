public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkPos(line) || !checkPos(column) || !checkPos(toLine) || !checkPos(toColumn)){
            return false;
        }
        if(line == toLine && toColumn == column){
            return false;
        }
        int hPow1 = Math.abs(line - toLine);
        int hPow2 = Math.abs(column - toColumn);
        if((hPow1 == 1 && hPow2 == 2) || (hPow1 == 2 && hPow2 == 1))
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)){
                return true;
            }else return false;
        return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
