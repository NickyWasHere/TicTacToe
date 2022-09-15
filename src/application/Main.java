package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.Match;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean playGame = false;
		
		do {
		
			Match match = new Match();
			
			while (match.getWin()==false && match.getLose()==false) {
				UI.clearScreen();
				gameplayLoop(match, sc);
				match.checkWin();
				match.checkLoss();
				
				//Muda o turno apenas se um dos jogadores não tiver ganhado
				if (match.getWin()==false) {
					match.switchTurn();
				}	
			}
			
			//Mostra mensagem de fim de jogo
			if (match.getWin()) {
				UI.youWin(match.getTurn(), match.getSpaces());
			} else if (match.getLose()) {
				UI.youLose(match.getSpaces());
			}
			
			playGame = playAgain(sc); //Verifica se o usuário deseja jogar novamente
			
		} while (playGame);
		sc.close();
	}
	
	public static void gameplayLoop(Match match, Scanner sc) {
		
		try {
			UI.printMatch(match.getTurn(), match.getSpaces());
			System.out.print("Linha: ");
			int linha = sc.nextInt();
			System.out.print("Coluna: ");
			int coluna = sc.nextInt();
			
			//Diminui as linhas e as colunas digitadas pelo usuário por 1 para bater com a matriz
			linha--;
			coluna--;
			
			if (linha>=0 && linha<=2 && coluna>=0 && coluna<=2) {
				match.placeMark(linha, coluna, match, sc);
				
			} else {
				UI.error("Por favor digite apenas \nnúmeros equivalentes à casa \ndesejada");
				gameplayLoop(match, sc);
			}
			
		} catch (InputMismatchException err) {
			//Jogo encerra pois houve erro ao tentar repetir este pedaço
			System.out.println("Jogo encerrado");
			System.exit(0);
		}
	}
	
	public static boolean playAgain(Scanner sc) {
		boolean playGame = false;
		
		UI.playAgain();
		char again = sc.next().charAt(0);
		
		if (again=='S' || again=='s') {
			playGame = true;
			
		} else if (again=='N' || again=='n') {
			playGame = false;
			
		} else {
			UI.error("Por favor digite uma das\n2 opções");
			playGame=playAgain(sc);
		}
		
		return playGame;
	}

}
