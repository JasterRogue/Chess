public class Pawn extends Piece{

    public Pawn(PieceColor color, Position position)
    {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board)
    {
        int forwardDirection = color == PieceColor.WHITE ? -1 : 1;
        int rowDiff = (newPosition.getRow() - position.getRow()) * forwardDirection;
        int colDiff = newPosition.getColumn() - position.getColumn();

        //forward move
        if (colDiff == 0 && rowDiff == 1 && board[newPosition.getRow()][newPosition.getColumn()] == null)
        {
            //initial two square move
            boolean isStartingPosition = (color == PieceColor.WHITE && position.getRow() == 6) || (color == PieceColor.BLACK && position.getRow() == 1);

            //check the square in between for blocking pieces
            int middleRow = position.getRow() + forwardDirection;

            if(board[middleRow][position.getColumn()] == null)
            {
                return true;
                //move forward two squares
            }

        }

        //diagonal capture
        if (Math.abs(colDiff) == 1 && rowDiff == 1 && board[newPosition.getRow()][newPosition.getColumn()] != null && board[newPosition.getRow()][newPosition.getColumn()].color != this.color)
        {
            return true;
            //capture piece
        }

        return false;

    }//end isValidMove()
}
