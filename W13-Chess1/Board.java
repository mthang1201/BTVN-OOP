import java.util.ArrayList;

/**
 * Board.
 */
public class Board {
    public static final int WIDTH = 8;

    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    /**
     * Board.
     *
     */
    public Board() {
        this.pieces = new ArrayList<>();
    }

    /**
     * Board.
     *
     * @param piece Board.
     */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();

        if (getAt(x, y) == null) {
            this.pieces.add(piece);
        }
    }

    /**
     * Board.
     *
     * @param x Board.
     * @param y Board.
     * @return Board.
     */
    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    /**
     * Board.
     *
     * @param x Board.
     * @param y Board.
     */
    public void removeAt(int x, int y) {
        if (validate(x, y)) {
            for (Piece piece : pieces) {
                if (piece.getCoordinatesX() == x
                        && piece.getCoordinatesY() == y) {
                    pieces.remove(piece);
                    return;
                }
            }
        }
    }

    /**
     * Board.
     *
     * @param x Board.
     * @param y Board.
     * @return Board.
     */
    public Piece getAt(int x, int y) {
        if (validate(x, y)) {
            for (Piece piece : pieces) {
                if (piece.getCoordinatesX() == x
                        && piece.getCoordinatesY() == y) {
                    return piece;
                }
            }
        }

        return null;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
