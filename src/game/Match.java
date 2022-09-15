package game;

import java.util.Scanner;

import application.Main;
import application.UI;

public class Match {

	private Mark turn;
	private Mark[][] spaces; //Matriz de enum para salvar os X e O no tabuleiro
	private boolean win;
	private boolean lose;
	
	public Match() {
		this.turn = turn.X; //X começa
		this.spaces = new Mark[3][3]; //Inicializa com tudo null
		this.win = false;
		this.lose = false;
	}

	public Mark getTurn() {
		return turn;
	}
	
	public Mark[][] getSpaces() {
		return spaces;
	}
	
	public boolean getWin() {
		return win;
	}
	
	public boolean getLose() {
		return lose;
	}
	
	public void switchTurn() { //Muda o turno
		turn = (turn==Mark.X) ? Mark.O : Mark.X;
	}
	
	public void placeMark(int linha, int coluna, Match match, Scanner sc) {
		
		if (spaces[linha][coluna]==null) { //Espaço vazio
			spaces[linha][coluna] = turn;
		} else {
			UI.error("Espaço já ocupado");
			Main.gameplayLoop(match, sc);

		}
	}
	
	//Não gostei da implementação mas deixei assim
		public void checkWin() {
			
			//Variáveis auxiliares para facilitar as comparações
			Mark top = spaces[0][0];
			Mark middle = spaces[1][1];
			Mark bottom = spaces[2][2];
			
			if (top==spaces[0][1] && top==spaces[0][2] && top!=null) { //Linha 1 completa
				win = true;	
			} else if (middle==spaces[1][0] && middle==spaces[1][2] && middle!=null) { //Linha 2 completa
				win = true;	
			} else if (bottom==spaces[2][0] && bottom==spaces[2][1] && bottom!=null) { //Linha 3 completa
				win = true;		
			} else if (top==spaces[1][0] && top==spaces[2][0] && top!=null) { //Coluna 1 completa
				win = true;	
			} else if (middle==spaces[0][1] && middle==spaces[2][1]  && middle!=null) { //Coluna 2 completa
				win = true;	
			} else if (bottom==spaces[0][2] && bottom==spaces[1][2] && bottom!=null) { //Coluna 3 completa
				win = true;	
			} else if (top==middle && middle==bottom && top!=null) { //Diagonal direita completa
				win = true;
			} else if (middle==spaces[0][2] && middle==spaces[2][0]  && middle!=null) { //Diagonal esquerda completa
				win = true;
			}
		}
		
		public void checkLoss() {
			int cont = 0; //Contador para auxiliar
			
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					if (spaces[i][j]!=null) { //Conta todos os espaços que não estão vazios
						cont++;
					}
				}
			}
			
			if (cont>=9) {
				lose = true;
			}
		}
}
