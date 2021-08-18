package chessPieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Knight extends ChessPiece{

    public Knight(Board board, Color color) {
        super(board, color);
        //TODO Auto-generated constructor stub
    }
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0, 0);
        
        p.setvalues(position.getRow()-1 , position.getcolumn()-2);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()-2 , position.getcolumn()-1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()-2 , position.getcolumn()+1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()-1, position.getcolumn()+2);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()+1 , position.getcolumn()+2);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()+2 , position.getcolumn()+1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()+2 , position.getcolumn()-1);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        p.setvalues(position.getRow()+1 , position.getcolumn()-2);
        if(getBoard().positionExisits(p) && canMove(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        
        return mat;
    }

    @Override
    public String toString(){
        return "N";
    }
    
}
