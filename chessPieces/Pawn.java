package chessPieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Pawn extends ChessPiece{

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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
            //special move enPassant white
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getcolumn()-1);
                if(getBoard().positionExisits(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow()-1][left.getcolumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getcolumn()+1);
                if(getBoard().positionExisits(right) && isThereOpponentPiece(left) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow()-1][left.getcolumn()] = true;
                }
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
            //special move enPassant black
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getcolumn()-1);
                if(getBoard().positionExisits(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow()+1][left.getcolumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getcolumn()+1);
                if(getBoard().positionExisits(right) && isThereOpponentPiece(left) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow()+1][left.getcolumn()] = true;
                }
            }

        }
        return mat;
    }

    @Override
    public String toString(){
        return "P";
    } 
}
