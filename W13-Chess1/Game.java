import java.util.ArrayList;

/**
 * Game.
 */
public class Game {
    private Board board;

    private ArrayList<Move> moveHistory;

    /**
     * Game.
     *
     * @param board Game.
     */
    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<>();
    }

    /**
     * Game.
     *
     * @param piece Game.
     * @param x Game.
     * @param y Game.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move newMove;
            Piece killedPiece = board.getAt(x, y);

            if (killedPiece == null) {
                newMove = new Move(
                        piece.getCoordinatesX(),
                        piece.getCoordinatesY(),
                        x,
                        y,
                        piece
                );
            } else {
                newMove = new Move(
                        piece.getCoordinatesX(),
                        piece.getCoordinatesY(),
                        x,
                        y,
                        piece,
                        killedPiece
                );

                board.removeAt(x, y);
            }

            moveHistory.add(newMove);

            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
