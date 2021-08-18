package chessPieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class King extends ChessPiece{
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
        //TODO Auto-generated constructor stub
    }

    private boolean testRookCastling(Position position){//testa se a torre está hapta para um rock
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0, 0);
        
        //above
        p.setvalues(position.getRow()-1 , position.getcolumn());
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //below
        p.setvalues(position.getRow()+1 , position.getcolumn());
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //left
        p.setvalues(position.getRow() , position.getcolumn()-1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //right
        p.setvalues(position.getRow() , position.getcolumn()+1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //noroeste
        p.setvalues(position.getRow()-1 , position.getcolumn()-1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //nordeste
        p.setvalues(position.getRow()-1 , position.getcolumn()+1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //sudoeste
        p.setvalues(position.getRow()+1 , position.getcolumn()-1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //sudeste
        p.setvalues(position.getRow()+1 , position.getcolumn()+1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }
        //special move castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            //little rook
            Position posT1 = new Position(position.getRow(), position.getcolumn()+3);
            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getcolumn()+1);
                Position p2 = new Position(position.getRow(), position.getcolumn()+2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getcolumn()+2] = true;
                }
            }
            //great rook
            Position posT2 = new Position(position.getRow(), position.getcolumn()-4);
            if(testRookCastling(posT2)){
                Position p1 = new Position(position.getRow(), position.getcolumn()-1);
                Position p2 = new Position(position.getRow(), position.getcolumn()-2);
                Position p3 = new Position(position.getRow(), position.getcolumn()-3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getcolumn()-2] = true;
                }
            }
        }

        
        return mat;
    }
    
    @Override
    public String toString(){
        return "K";
    }
    
}
