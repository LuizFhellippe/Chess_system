package chessPieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class King extends ChessPiece{

    public King(Board board, Color color) {
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

        
        return mat;
    }
    
    @Override
    public String toString(){
        return "K";
    }
    
}
