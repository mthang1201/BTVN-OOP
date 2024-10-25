public class Main {
    public static void main(String[] args) {
        // Create a new chess board
        Board board = new Board();

        // Add a Rook piece to the board at position (1, 1)
        Rook rook = new Rook(1, 1, "white");
        board.addPiece(rook);

        Rook rook2 = new Rook(7, 7, "black");
        board.addPiece(rook2);
        boolean b = rook2.canMove(board,7, 3);
        System.out.println(b);


        // Create a Game instance and associate the board
        Game game = new Game(board);

        // Try moving the Rook to a valid position (1, 4)
        System.out.println("Attempting to move Rook to (1, 4):");
        game.movePiece(rook, 1, 5);
        game.movePiece(rook, 3, 5);
        game.movePiece(rook, 3, 4);
        game.movePiece(rook, 7, 4);
        System.out.println(board.getAt(1, 4) != null ? "Move successful!" : "Move failed!");

        // Try an invalid move for Rook (like moving diagonally)
        System.out.println("Attempting to move Rook to (2, 5) (invalid):");
        game.movePiece(rook, 2, 5);
        System.out.println(board.getAt(2, 5) == null ? "Move failed as expected!" : "Unexpected success!");

        // Try to capture a black piece by adding it and moving the Rook
        Rook enemyRook = new Rook(1, 7, "black");
        board.addPiece(enemyRook);
        System.out.println("Attempting to capture black Rook at (1, 7):");
        game.movePiece(rook, 1, 7);
        System.out.println(board.getAt(1, 7) == rook ? "Capture successful!" : "Capture failed!");

        // Output move history
        System.out.println("Move History:");
        for (Move move : game.getMoveHistory()) {
            System.out.println(move);
        }
    }
}
