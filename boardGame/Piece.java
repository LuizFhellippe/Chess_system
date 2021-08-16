package boardGame;

public class Piece {
    protected Position position;
    private Board board;
    public Piece(Board board){
        this.board = board;
        position = null;
    }
    protected Board getBoard(){
        return board;
    }
    //apenas o get, pq o set permite alterar o tabuleiro
}
