package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        
        while(!chessMatch.getCheckMate()){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.print("\nSource: ");
                ChessPosition source = UI.readChessPosition(input);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.print("\nTarget: ");
                ChessPosition target = UI.readChessPosition(input);

                ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);

                if(capturedPiece != null){//verifica se a peca foi capturada
                    captured.add(capturedPiece);
                }
                if(chessMatch.getPromoted() != null){
                    System.out.print("Enter Piece for promotion (B/N/Q/R): ");
                    String type = input.nextLine().toUpperCase();
                    while(!type.equals("B") && !type.equals("N") && !type.equals("Q") && !type.equals("R")){
                        System.out.println("Invalid value! Enter piece for promotion (B/N/Q/R)");
                        type = input.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            }catch(ChessException e){
                System.out.println(e.getMessage());
                input.nextLine();
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
