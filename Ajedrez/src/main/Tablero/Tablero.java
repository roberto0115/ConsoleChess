package main.Tablero;

import main.Pieza.Alfil;
import main.Pieza.Caballo;
import main.Pieza.Dama;
import main.Pieza.Peon;
import main.Pieza.Pieza;
import main.Pieza.Rey;
import main.Pieza.Torre;
import main.Pieza.Vacia;
import main.Tablero.Casilla.Casilla;

public class Tablero {

	public Casilla casillas[];
	
	private final int lado;
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[46m";
	public static final String ANSI_BLACK = "\u001B[30m";
	
	private Pieza PiezasRojas[] = {new Torre(0,0,1,this),new Caballo(1,0,1,this),new Alfil(2,0,1,this),new Dama(3,0,1,this),new Rey(4,0,1,this),new Alfil(5,0,1,this),new Caballo(6,0,1,this),new Torre(7,0,1,this)
			,new Peon(0,1,1,this),new Peon(1,1,1,this),new Peon(2,1,1,this),new Peon(3,1,1,this),new Peon(4,1,1,this),new Peon(5,1,1,this),new Peon(6,1,1,this),new Peon(7,1,1,this)};
	private Pieza PiezasNegras[] = {new Torre(0,7,-1,this),new Caballo(1,7,-1,this),new Alfil(2,7,-1,this),new Dama(3,7,-1,this),new Rey(4,7,-1,this),new Alfil(5,7,-1,this),new Caballo(6,7,-1,this),new Torre(7,7,-1,this)
			,new Peon(0,6,-1,this),new Peon(1,6,-1,this),new Peon(2,6,-1,this),new Peon(3,6,-1,this),new Peon(4,6,-1,this),new Peon(5,6,-1,this),new Peon(6,6,-1,this),new Peon(7,6,-1,this)};
	private int NumPiezas = 16;
	
	public Tablero() {
		this.lado = 8;
		casillas = new Casilla[lado*lado];
		TableroInicial();
	}
	
	public void imprimirtablero() {
		for(int y = 0; y < lado+2; y++) {
			for(int x = 0; x< lado+2; x++) {
				if(y == 0  || y == GetLado()+1) {
					switch(x) {
					 case 0:
						 System.out.print(" ");
						 System.out.print(" ");
						 System.out.print(" ");
						 break;
					 case 1:
						 System.out.print(" ");
						 System.out.print("A");
						 System.out.print(" ");
						 break;
					 case 2:
						 System.out.print(" ");
						 System.out.print("B");
						 System.out.print(" ");
						 break;
					 case 3:
						 System.out.print(" ");
						 System.out.print("C");
						 System.out.print(" ");
						 break;
					 case 4:
						 System.out.print(" ");
						 System.out.print("D");
						 System.out.print(" ");
						 break;
					 case 5:
						 System.out.print(" ");
						 System.out.print("E");
						 System.out.print(" ");
						 break;
					 case 6:
						 System.out.print(" ");
						 System.out.print("F");
						 System.out.print(" ");
						 break;
					 case 7:
						 System.out.print(" ");
						 System.out.print("G");
						 System.out.print(" ");
						 break;
					 case 8:
						 System.out.print(" ");
						 System.out.print("H");
						 System.out.print(" ");
						 break;
					 case 9:
						 System.out.print(" ");
						 System.out.print(" ");
						 System.out.print(" ");
						 break;
					}
				}else {
					if(x == 0 || x == GetLado()+1) {
						System.out.print(" ");
						System.out.print(y);
						System.out.print(" ");
					}else {
						if(y%2 == 0) {
							if(x%2 == 0) {
								if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == 1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+ANSI_RED + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
								}else if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == -1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+ANSI_BLACK+ casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
								}else {
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+casillas[(x-1)+(y-1)*lado].getPieza().Imprimir());
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
								}
							}else {
								if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == 1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									
								}else if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == -1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND  +ANSI_BLACK + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
								
								}else {
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
								}
							}
						}else {
							if(x%2 == 0) {
								if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == 1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									
								}else if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == -1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND  +ANSI_BLACK + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
								
								}else {
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_WHITE_BACKGROUND +" "+  ANSI_RESET);
									
								}
							}else {
								if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == 1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+ ANSI_RED + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
								}else if(casillas[(x-1)+(y-1)*lado].getPieza().getColor() == -1 && casillas[(x-1)+(y-1)*lado].getPieza().getComida() == false) {
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+ ANSI_BLACK + casillas[(x-1)+(y-1)*lado].getPieza().Imprimir()+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
								}else {
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
									System.out.print(ANSI_BLUE_BACKGROUND+casillas[(x-1)+(y-1)*lado].getPieza().Imprimir());
									System.out.print(ANSI_BLUE_BACKGROUND+" "+  ANSI_RESET);
								}
							}
						}
						
					}
				}
				
			}
			System.out.println();
		}
	}
	
	public void TableroInicial() {
		for(int y = 0; y<lado; y++) {	
			for(int x = 0; x<lado; x++) {
				casillas[x+y*lado] = new Casilla(new Vacia(x,y), this);
			}
		}
		for(int y = 0 ; y<GetLado();y++) {
			for(int x = 0; x<GetLado(); x++) {
				if(y == 0 && x<(PiezasRojas.length/2)) {
					casillas[x+y*lado].setPieza(PiezasRojas[x+0*(PiezasRojas.length/2)]);
					
				}
				if(y== 1 && x<(PiezasRojas.length/2)) {
					casillas[x+y*lado].setPieza(PiezasRojas[x+1*((PiezasRojas.length/2))]);
				}
				if(y== GetLado()-2 && x<(PiezasRojas.length/2)) {
					casillas[x+y*lado].setPieza(PiezasNegras[x+1*((PiezasRojas.length/2))]);
				}
				if(y == GetLado()-1 && x<(PiezasRojas.length/2)) {
					casillas[x+y*lado].setPieza(PiezasNegras[x+0*((PiezasRojas.length/2))]);
				}
				
			}
		}
	}
	public int GetLado() {
		return lado;
	}
	
	public Pieza GetPiezaRoja(int i) {
		return PiezasRojas[i];
	}
	public Pieza GetPiezaNegra(int i) {
		return PiezasNegras[i];
	}
	public int getNumPiezas() {
		return PiezasRojas.length;
	}
}
