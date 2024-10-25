/**
 * Piece.
 */
public abstract class Piece {
    private int coordinatesX;

    private int coordinatesY;

    private String color;

    /**
     * Piece.
     *
     * @param coordinatesX Piece.
     * @param coordinatesY Piece.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.setCoordinatesX(coordinatesX);
        this.setCoordinatesY(coordinatesY);
        this.color = "white";
    }

    /**
     * Piece.
     *
     * @param coordinatesX Piece.
     * @param coordinatesY Piece.
     * @param color Piece.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.setCoordinatesX(coordinatesX);
        this.setCoordinatesY(coordinatesY);
        this.setColor(color);
    }

    /**
     * Piece.
     *
     * @return Piece.
     */
    public abstract String getSymbol();

    /**
     * Piece.
     *
     * @param board Piece.
     * @param x Piece.
     * @param y Piece.
     * @return Piece.
     */
    public abstract boolean canMove(Board board, int x, int y);

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public String getColor() {
        return color;
    }

    /**
     * Piece.
     *
     * @param coordinatesX Piece.
     */
    public void setCoordinatesX(int coordinatesX) {
        if (1 <= coordinatesX && coordinatesX <= 8) {
            this.coordinatesX = coordinatesX;
        }
    }

    /**
     * Piece.
     *
     * @param coordinatesY Piece.
     */
    public void setCoordinatesY(int coordinatesY) {
        if (1 <= coordinatesY && coordinatesY <= 8) {
            this.coordinatesY = coordinatesY;
        }
    }

    /**
     * Piece.
     *
     * @param color Piece.
     */
    public void setColor(String color) {
        if (color.equals("white") || color.equals("black")) {
            this.color = color;
        }
    }

    public boolean checkPosition(Piece piece) {
        return true;
    }
}
