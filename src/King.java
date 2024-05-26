public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!checkPos(line) || !checkPos(column) || !checkPos(toLine) || !checkPos(toColumn)) {
            return false;
        }
        if (line == toLine && column == toColumn) {
            return false;
        }
        if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
            if (!isUnderAttack(chessBoard, toLine, toColumn)) {
                if(chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)){
                    check = false;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (!checkPos(line) || !checkPos(column)) {
            return false;
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color)) {
                    if (piece.canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
