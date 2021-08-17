package boardGame;

public abstract class Piece {
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
    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){//testa se é possível mover para o local
        return possibleMoves()[position.getRow()][position.getcolumn()];
    }
    public boolean isThereAnyPossibleMove(){//testa se ha pelo menos um movimento possivel
        boolean[][] mat = possibleMoves();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
