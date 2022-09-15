package application;

import game.Mark;

public class UI {

	//Limpa a tela
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
	}
	
	public static void printMatch(Mark turn, Mark[][] spaces) {
		clearScreen();
		
		char[][] marks = printMarks(spaces);
		
		System.out.println();
		System.out.println("===============================");
		System.out.println("         Jogo da Velha         ");
		System.out.println("===============================");
		System.out.println();
		
		System.out.println("Colunas       1     2     3    ");
		System.out.println();
		System.out.printf("Linha 1       %c  |  %c  |  %c%n",    //[0][0] | [0][1] | [0][2]
				marks[0][0], marks[0][1], marks[0][2]); 
		System.out.println("             ---------------   ");   //-------|--------|-------
		System.out.printf("Linha 2       %c  |  %c  |  %c%n",    //[1][0] | [1][1] | [1][2]
				marks[1][0], marks[1][1], marks[1][2]);
		System.out.println("             ---------------   ");   //-------|--------|-------
		System.out.printf("Linha 3       %c  |  %c  |  %c%n",    //[2][0] | [2][1] | [2][2]
				marks[2][0], marks[2][1], marks[2][2]); 
		
		System.out.println();
		System.out.println("===============================");
		System.out.println("Vez do jogador " + turn);
		
		System.out.println();
		System.out.println("Escolha uma casa");

	}
	
	//Transforma os valores de spaces em caracteres para mostrar ao usuário
	public static char[][] printMarks(Mark[][] spaces) {
		char[][] aux = new char[3][3]; //Variável auxiliar
				
		for (int i=0; i<3; i++) {		
			for (int j=0; j<3; j++) {
				if (spaces[i][j]==null) {
					aux[i][j] = '*';
					
				} else if (spaces[i][j]==Mark.X) {
					aux[i][j] = 'X';
					
				} else if (spaces[i][j]==Mark.O) {
					aux[i][j] = 'O';
				}
			}
		}
		return aux;
	}
	
	public static void youWin(Mark turn) {
		clearScreen();
		
		System.out.println();
		System.out.println("================================");
		System.out.println("     O jogador " + turn + " venceu! :)");    
		System.out.println("         Jogo encerrado         ");
	}
	
	public static void youLose() {
		clearScreen();
		
		System.out.println();
		System.out.println("================================");
		System.out.println("         O jogo empatou         ");    
		System.out.println("         Jogo encerrado         ");
	}
	
	public static void playAgain() {
		System.out.println();	
		System.out.println("  Gostaria de jogar novamente?  ");    
		System.out.println("             (S/N)              ");
		System.out.println("================================");	
		
		System.out.println();
		System.out.print("Digite sua resposta: ");
	}
	
	public static void errorPlayAgain() {
		clearScreen();
		System.out.println();
		System.out.println("===========================================");
		System.out.println("     Por favor digite uma das 2 opções     ");
	}
}
