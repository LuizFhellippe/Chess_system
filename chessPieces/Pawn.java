package chessPieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Pawn extends ChessPiece{

    public Pawn(Board board, Color color) {
        super(board, color);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        if(getColor() == Color.WHITE){
            p.setvalues(position.getRow()-1, position.getcolumn());
            if(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getcolumn()] = true;
            }
            p.setvalues(position.getRow()-2, position.getcolumn());
            Position p2 = new Position(position.getRow()-1, position.getcolumn());
            if(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExisits(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
            mat[p.getRow()][p.getcolumn()] = true;
            }
            p.setvalues(position.getRow()-1, position.getcolumn()-1);
            if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getcolumn()] = true;
            }
            p.setvalues(position.getRow()-1, position.getcolumn()+1);
            if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getcolumn()] = true;
            }
        
        }else{
            p.setvalues(position.getRow()+1, position.getcolumn());
            if(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getcolumn()] = true;
            }
            p.setvalues(position.getRow()+2, position.getcolumn());
            Position p2 = new Position(position.getRow()+1, position.getcolumn());
            if(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExisits(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
            mat[p.getRow()][p.getcolumn()] = true;
            }
            p.setvalues(position.getRow()+1, position.getcolumn()-1);
            if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getcolumn()] = true;
            }
            p.setvalues(position.getRow()+1, position.getcolumn()+1);
            if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getcolumn()] = true;
            }

        }
        return mat;
    }

    @Override
    public String toString(){
        return "P";
    } 
}
