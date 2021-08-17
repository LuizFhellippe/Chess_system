package chessPieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Rook extends ChessPiece{

    public Rook(Board board, Color color) {
        super(board, color);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //logica dos movimentos
        //above
        p.setvalues(position.getRow()-1, position.getcolumn());
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setRow(p.getRow()-1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }
        
        //left
        p.setvalues(position.getRow(), position.getcolumn()-1);
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setColumn(p.getcolumn()-1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //Right
        p.setvalues(position.getRow(), position.getcolumn()+1);
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setColumn(p.getcolumn()+1 );
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }

        //below
        p.setvalues(position.getRow()+1, position.getcolumn());
        while(getBoard().positionExisits(p) && !getBoard().thereIsAPiece(p)){//enquanto a posicao existir e estiver vaga
            mat[p.getRow()][p.getcolumn()] = true;
            p.setRow(p.getRow()+1);
        }
        if(getBoard().positionExisits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getcolumn()] = true;
        }
        return mat;
    }
    
}
