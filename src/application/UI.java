package application;

import game.Mark;

public class UI {
	
	//Cores
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	//Limpa a tela
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
	}
	
	public static void printMatch(Mark turn, Mark[][] spaces) {		
		char[][] marks = printMarks(spaces);
		
		//Variáveis auxiliares para deixar o código embaixo mais legível
		String titulo = ANSI_GREEN + "Jogo da Velha" + ANSI_RESET;
		String colunas = ANSI_YELLOW + "Colunas       1     2     3    " + ANSI_RESET;
		String linha1 = ANSI_YELLOW + "Linha 1" + ANSI_RESET;
		String linha2 = ANSI_YELLOW + "Linha 2" + ANSI_RESET;
		String linha3 = ANSI_YELLOW + "Linha 3" + ANSI_RESET;
		
		System.out.println();
		System.out.println("================================");
		System.out.println("         " + titulo);
		System.out.println("================================");
		System.out.println();
		
		System.out.println(colunas);
		System.out.println();
		System.out.printf(linha1 + "       %c  |  %c  |  %c%n",
				marks[0][0], marks[0][1], marks[0][2]); 
		System.out.println("             ---------------   ");
		System.out.printf(linha2 + "       %c  |  %c  |  %c%n",
				marks[1][0], marks[1][1], marks[1][2]);
		System.out.println("             ---------------   ");
		System.out.printf(linha3 + "       %c  |  %c  |  %c%n",
				marks[2][0], marks[2][1], marks[2][2]); 
		
		System.out.println();
		System.out.println("================================");
		System.out.println("Vez do jogador " + turn);
		
		System.out.println();
		System.out.println(ANSI_GREEN + "Escolha uma casa" + ANSI_RESET);

	}
	
	//Overload to método printMatch para quando o jogo acaba mostrando apenas o tabuleiro
	public static void printMatch(Mark[][] spaces) {
		char[][] marks = printMarks(spaces);
		
		//Variáveis auxiliares para deixar o código embaixo mais legível
		String titulo = ANSI_GREEN + "Jogo da Velha" + ANSI_RESET;
		String colunas = ANSI_YELLOW + "Colunas       1     2     3    " + ANSI_RESET;
		String linha1 = ANSI_YELLOW + "Linha 1" + ANSI_RESET;
		String linha2 = ANSI_YELLOW + "Linha 2" + ANSI_RESET;
		String linha3 = ANSI_YELLOW + "Linha 3" + ANSI_RESET;
		
		System.out.println();
		System.out.println("================================");
		System.out.println("         " + titulo);
		System.out.println("================================");
		System.out.println();
		
		System.out.println(colunas);
		System.out.println();
		System.out.printf(linha1 + "       %c  |  %c  |  %c%n",
				marks[0][0], marks[0][1], marks[0][2]); 
		System.out.println("             ---------------   ");
		System.out.printf(linha2 + "       %c  |  %c  |  %c%n",
				marks[1][0], marks[1][1], marks[1][2]);
		System.out.println("             ---------------   ");
		System.out.printf(linha3 + "       %c  |  %c  |  %c%n",
				marks[2][0], marks[2][1], marks[2][2]); 
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
	
	public static void youWin(Mark turn, Mark[][] spaces) {	
		clearScreen();
		printMatch(spaces);
		
		String vencedor = ANSI_GREEN + "O jogador " + turn + " venceu! :)"; //Auxiliar
		
		System.out.println();
		System.out.println("================================");
		System.out.println();
		System.out.println("     " + vencedor);    
		System.out.println("         Jogo encerrado" + ANSI_RESET);
	}
	
	public static void youLose(Mark[][] spaces) {	
		clearScreen();
		printMatch(spaces);
		
		System.out.println();
		System.out.println("================================");
		System.out.println();
		System.out.println(ANSI_GREEN + "         O jogo empatou");    
		System.out.println("         Jogo encerrado" + ANSI_RESET);
	}
	
	public static void playAgain() {		
		System.out.println();
		System.out.println("================================");
		System.out.println("  Gostaria de jogar novamente?  ");    
		System.out.println("              (S/N)             ");
		System.out.println("================================");
		
		System.out.println();
		System.out.print(ANSI_GREEN + "Digite sua resposta: " + ANSI_RESET);
	}
	
	public static void error(String mensagem) {
		clearScreen();
		System.out.println();
		System.out.print(ANSI_RED + "ERRO: " + ANSI_RESET);
		System.out.println(mensagem);
	}
}
