/**
 * Rook.
 */
public class Rook extends Piece {
    /**
     * Rook.
     *
     * @param x Rook.
     * @param y Rook.
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Rook.
     *
     * @param x Rook.
     * @param y Rook.
     * @param color Rook.
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Rook.
     *
     * @return Rook.
     */
    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Rook.
     *
     * @param board Rook.
     * @param x Rook.
     * @param y Rook.
     * @return Rook.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        // not on the same line.
        if (getCoordinatesX() != x && getCoordinatesY() != y) {
            return false;
        }

        Piece pieceAt = board.getAt(x, y);
        if (pieceAt != null
                && pieceAt.getColor().equals(getColor())) {
            return false;
        }

        // vertical (same x, different y).
        if (getCoordinatesX() == x) {
            int minY = Math.min(getCoordinatesY(), y);
            int maxY = Math.max(getCoordinatesY(), y);

            for (Piece piece : board.getPieces()) {
                int otherY = piece.getCoordinatesY();

                // not on the same line.
                if (piece.getCoordinatesX() != x) {
                    continue;
                }

                if (minY < otherY && otherY < maxY) {
                    return false;
                }
            }
        }

        // horizontal (same y, different x).
        if (getCoordinatesY() == y) {
            int minX = Math.min(getCoordinatesX(), x);
            int maxX = Math.max(getCoordinatesX(), x);

            for (Piece piece : board.getPieces()) {
                int otherX = piece.getCoordinatesX();

                // not on the same line.
                if (piece.getCoordinatesY() != y) {
                    continue;
                }

                if (minX < otherX && otherX < maxX) {
                    return false;
                }
            }
        }

        return true;
    }
}
