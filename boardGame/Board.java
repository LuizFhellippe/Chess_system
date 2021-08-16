package boardGame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns){
        if(rows<1 || columns<1){
            throw new BoardException("Error creating board");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public Piece piece(int row, int column){
        if(!positionExisits(row, column)){//caso a linha e coluna nao exixtirem
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionExisits(position)){//caso a posica nao exista
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getcolumn()];
    }
    //coloca a peca na posicao do tabuleiro
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is a piece on position " + position);
        }
        pieces[position.getRow()][position.getcolumn()] = piece;
        //a posicao a peca muda de nula pra atual
        piece.position = position;
    }
    private boolean positionExisits(int row, int column){
        //verifica se a posicao na dada linha e coluna existe
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    //testa se a posicao existe
    public boolean positionExisits(Position position){
        return positionExisits(position.getRow(), position.getcolumn());
    }
    public boolean thereIsAPiece(Position position){
        if(!positionExisits(position)){//
            throw new BoardException("Position is not on the board");
        }
        //verifica se ha peca na posicao
        return piece(position) != null;
    }
}
