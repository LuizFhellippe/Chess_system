package application;

import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        
        while(true){
            UI.printBoard(chessMatch.getPieces());
            System.out.print("\nSource: ");
            ChessPosition source = UI.readChessPosition(input);

            System.out.print("\nTarget: ");
            ChessPosition target = UI.readChessPosition(input);

            ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);
        }
    }
}
