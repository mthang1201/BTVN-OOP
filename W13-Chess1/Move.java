/**
 * Move.
 */
public class Move {
    private int startX;

    private int endX;

    private int startY;

    private int endY;

    private Piece movedPiece;

    private Piece killedPiece;

    /**
     * Move.
     *
     * @param startX Move.
     * @param endX Move.
     * @param startY Move.
     * @param endY Move.
     * @param movedPiece Move.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Move.
     *
     * @param startX Move.
     * @param endX Move.
     * @param startY Move.
     * @param endY Move.
     * @param movedPiece Move.
     * @param killedPiece Move.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * Move.
     *
     * @return Move.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(movedPiece.getColor());
        output.append("-");
        output.append(movedPiece.getSymbol());

        char posX = (char) ('a' + endX - 1);

        output.append(posX);
        output.append(endY);

        return output.toString();
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
