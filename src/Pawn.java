public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if(!checkPos(column) || !checkPos(line) || !checkPos(toLine) || !checkPos(toColumn)){
            return false;
        }
        if(toLine == line && toColumn == 0){
            return false;
        }
        if(color.equals("White")){
            if(toColumn == column && line - toLine == -1 && chessBoard.board[toLine][toColumn] == null){
                return true;
            }
            if (toColumn == column && line - toLine == -2 && chessBoard.board[2][toColumn] == null && chessBoard.board[3][toColumn] == null){
                return true;
            }
            if (Math.abs(column - toColumn) == 1 && line - toLine == -1 && chessBoard.board[toLine][toColumn] != null && getColor().equals(this.color)){
                return true;
            }
        }else if(color.equals("Black")){
            if(toColumn == column && line - toLine == 1 && chessBoard.board[toLine][toColumn] == null){
                return true;
            }
            if (toColumn == column && line - toLine == 2 && chessBoard.board[4][toColumn] == null && chessBoard.board[5][toColumn] == null){
                return true;
            }
            if (Math.abs(column - toColumn) == 1 && line - toLine == 1 && chessBoard.board[toLine][toColumn] != null && getColor().equals(this.color)){
                return true;
            }
        } else return false;
        return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
