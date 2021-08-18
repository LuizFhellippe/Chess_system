package chessPieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Bishop extends ChessPiece{

    public Bishop(Board board, Color color) {
        super(board, color);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //logica dos movimentos
        //northwest
        p.setvalues(position.getRow()-1, position.getcolumn()-1);
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setvalues(p.getRow()-1, p.getcolumn()-1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }
        
        //north east
        p.setvalues(position.getRow()-1, position.getcolumn()+1);
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setvalues(p.getRow()-1, p.getcolumn()+1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //southesat
        p.setvalues(position.getRow()+1, position.getcolumn()+1);
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setvalues(p.getRow()+1, p.getcolumn()+1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //south-west
        p.setvalues(position.getRow()+1, position.getcolumn()-1);
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setvalues(p.getRow()+1, p.getcolumn()-1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }
        return mat;
    }

    @Override
    public String toString(){
        return "B";
    }
    
}
