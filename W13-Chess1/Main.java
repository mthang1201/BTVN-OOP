public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Piece r1 = new Rook(6,1);
        board.addPiece(r1);

        Game game = new Game(board);
        game.movePiece(r1, 6,3);
//        game.movePiece(r1, 6,7);
//        game.movePiece(r1, 1,7);

        for (int i = 0 ; i < game.getMoveHistory().size() ; i++) {
            System.out.println(game.getMoveHistory().get(i).toString());
        }

        Piece r2 = new Rook(6,5, "black");
        board.addPiece(r2);
        Move m1 = new Move(3, 6, 3, 3, r2);
        System.out.println(m1.toString());
    }
}
