public class Rook extends ChessPiece {

    public Rook(String color) {
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
        if (column == toColumn && line == toLine) {
            return false;
        }
        if (column != toColumn && line != toLine) {
            return false;
        }
        if (line == toLine) {
            int columnStep = toColumn > column ? 1 : -1;
            int currentColumn = column + columnStep;
            while (currentColumn != toColumn) {
                if (chessBoard.board[line][currentColumn] != null) {
                    return false;
                }
                currentColumn += columnStep;
            }

        } else {
            int lineStep = toLine > line ? 1 : -1;
            int currentLine = line + lineStep;
            while (currentLine != toLine) {
                if (chessBoard.board[currentLine][column] != null) {
                    return false;
                }
                currentLine += lineStep;
            }
        }

        if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
            check = false;
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
