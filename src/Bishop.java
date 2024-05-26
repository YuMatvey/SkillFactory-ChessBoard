public class Bishop extends ChessPiece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(!checkPos(line) || !checkPos(column) || !checkPos(toLine) || !checkPos(toColumn)){
            return false;
        }
        if(line == toLine && column == toColumn){
            return false;
        }
        if(Math.abs(line - toLine) != Math.abs(column - toColumn)){
            return false;
        }
        int lineStep = toLine > line ? 1 : -1;
        int columnStep = toColumn > column ? 1 : -1;
        int currentLine = line + lineStep;
        int currentColumn = columnStep + column;
        while (toColumn != currentColumn && toLine != currentLine){
            if(chessBoard.board[currentLine][currentColumn] != null){
                return false;
            }
            currentLine += lineStep;
            currentColumn += columnStep;
        }
        if(chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)){
            return true;
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}
